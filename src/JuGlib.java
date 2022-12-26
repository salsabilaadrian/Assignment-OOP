
public class JuGlib {
	private String name;
	private int price;
	private String desc;
	private String library;
	private String id;
	public JuGlib(String name, int price, String desc, String library, String id) {
		super();
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.library = library;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
