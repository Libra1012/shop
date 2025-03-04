package cn.it.shop.model;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields
	

	private Integer id;
	private String type;
	private Boolean hot;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(Integer id, String type, Boolean hot) {
		super();
		this.id = id;
		this.type = type;
		this.hot = hot;
	}
	
	/** full constructor */
	public Category(String type, Boolean hot) {
		super();
		this.type = type;
		this.hot = hot;
	}
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getHot() {
		return this.hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

}