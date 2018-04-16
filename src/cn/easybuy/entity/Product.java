package cn.easybuy.entity;

import java.io.Serializable;

public class Product implements Serializable {
	private Integer id;// ID
	private String name;// 商品名
	private String description;// 描述
	private Float price;// 单价
	private Integer stock;// 数量
	private Integer categoryLevel1Id;// 一级分类
	private Integer categoryLevel2Id;// 二级分类
	private Integer categoryLevel3Id;// 三级分类
	private String fileName;// 图片名称

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((categoryLevel1Id == null) ? 0 : categoryLevel1Id.hashCode());
		result = prime
				* result
				+ ((categoryLevel2Id == null) ? 0 : categoryLevel2Id.hashCode());
		result = prime
				* result
				+ ((categoryLevel3Id == null) ? 0 : categoryLevel3Id.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (categoryLevel1Id == null) {
			if (other.categoryLevel1Id != null)
				return false;
		} else if (!categoryLevel1Id.equals(other.categoryLevel1Id))
			return false;
		if (categoryLevel2Id == null) {
			if (other.categoryLevel2Id != null)
				return false;
		} else if (!categoryLevel2Id.equals(other.categoryLevel2Id))
			return false;
		if (categoryLevel3Id == null) {
			if (other.categoryLevel3Id != null)
				return false;
		} else if (!categoryLevel3Id.equals(other.categoryLevel3Id))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getCategoryLevel1Id() {
		return categoryLevel1Id;
	}

	public void setCategoryLevel1Id(Integer categoryLevel1Id) {
		this.categoryLevel1Id = categoryLevel1Id;
	}

	public Integer getCategoryLevel2Id() {
		return categoryLevel2Id;
	}

	public void setCategoryLevel2Id(Integer categoryLevel2Id) {
		this.categoryLevel2Id = categoryLevel2Id;
	}

	public Integer getCategoryLevel3Id() {
		return categoryLevel3Id;
	}

	public void setCategoryLevel3Id(Integer categoryLevel3Id) {
		this.categoryLevel3Id = categoryLevel3Id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", stock=" + stock
				+ ", categoryLevel1Id=" + categoryLevel1Id
				+ ", categoryLevel2Id=" + categoryLevel2Id
				+ ", categoryLevel3Id=" + categoryLevel3Id + ", fileName="
				+ fileName + "]";
	}

}