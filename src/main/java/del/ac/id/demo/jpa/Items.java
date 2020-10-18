package del.ac.id.demo.jpa;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("items")
public class Items {
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAccept_installment_payment() {
		return accept_installment_payment;
	}

	public void setAccept_installment_payment(String accept_installment_payment) {
		this.accept_installment_payment = accept_installment_payment;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getSeen() {
		return seen;
	}

	public void setSeen(double seen) {
		this.seen = seen;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public ItemDetail getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(ItemDetail itemDetail) {
		this.itemDetail = itemDetail;
	}

	public Items() {
		super();
	}

	public Items(String id, String item_name, String color, String accept_installment_payment, String store_id,
			double price, double discount, double rating, double seen, int stock, int sold, int length,
			ItemDetail itemDetail) {
		super();
		this.id = id;
		this.item_name = item_name;
		this.color = color;
		this.accept_installment_payment = accept_installment_payment;
		this.store_id = store_id;
		this.price = price;
		this.discount = discount;
		this.rating = rating;
		this.seen = seen;
		this.stock = stock;
		this.sold = sold;
		this.length = length;
		this.itemDetail = itemDetail;
	}

	@Id
	private String id;

	private String item_name,color,accept_installment_payment,store_id;
	private double price,discount,rating,seen;
	private int stock,sold,length;
	
	@DBRef
	@Field("item_detail")
	private ItemDetail itemDetail;
	
	
	
}
