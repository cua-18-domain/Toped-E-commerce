package del.ac.id.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.client.result.UpdateResult;

import del.ac.id.demo.jpa.*;

@RestController
public class ItemController {
	@Autowired ItemRepository itemRepository;
	@Autowired StoreRepository storeRepository;
	@Autowired MongoTemplate tampungData;
	
	
	@RequestMapping("/item")
	public ModelAndView item()
	{
		List<Items> item=itemRepository.findAll();
		
		ModelAndView mv=new ModelAndView("item");
		mv.addObject("item", item);
		return mv;
	}
	
	@GetMapping("/store/{store_name}") 
	  public ModelAndView itemStore(@PathVariable(name="store_name") String store_name) {
			Query query = new Query(Criteria.where("store_name").is(store_name));
			List<Store> store = tampungData.find(query, Store.class);
			ModelAndView mv = new ModelAndView("store");
			mv.addObject("store",store);
			return mv;
		}
	
	@RequestMapping("/items")
	public ModelAndView items()
	{
		List<Items> items=itemRepository.findAll();
		
		ModelAndView mv=new ModelAndView("items");
		mv.addObject("items",items);
		
		
		return mv;
	}
	@GetMapping("/showFormForUpdate/{id}")
	public ModelAndView showFormUpdate(@PathVariable(name="id") String id) {
		Optional<Items> items = itemRepository.findById(id);
		
		ModelAndView mv = new ModelAndView("showFormForUpdate");
		mv.addObject("items", items);
		return mv;
	}
	
	@GetMapping("/saveItem")
	public ModelAndView updateItem(@RequestParam(name="id") String id, @RequestParam(name="stock") double stock, @RequestParam(name="itemDetail.weight") double weight, @RequestParam(name="itemDetail.condition") String condition, @RequestParam(name="itemDetail.category") String category) {
		Optional<Items> item = itemRepository.findById(id);
		Query query = new Query(Criteria.where("id").is(id));
		List<Items> item2 = tampungData.find(query, Items.class);
		if(item2!=null) {
			Update update = new Update();
			update.set("stock", stock);
			update.set("item_detail.weight", weight);
			update.set("item_detail.condition", condition);
			update.set("item_detail.category", category);
			UpdateResult result = tampungData.updateFirst(query, update, Items.class);
		}
		ModelAndView mv = new ModelAndView("redirect:/items");
		
		return mv;
	}
}
