package cn.easybuy.utils;

import cn.easybuy.entity.Product;
import cn.easybuy.entity.ProductCategory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bdqn on 2016/4/25.
 */
public class ProductCategoryVo implements Serializable {

    private ProductCategory productCategory;
    private List<ProductCategoryVo> productCategoryVoList;
    private List<Product> productList;

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<ProductCategoryVo> getProductCategoryVoList() {
        return productCategoryVoList;
    }

    public void setProductCategoryVoList(List<ProductCategoryVo> productCategoryVoList) {
        this.productCategoryVoList = productCategoryVoList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

	@Override
	public String toString() {
		return "ProductCategoryVo [productCategory=" + productCategory
				+ ", productCategoryVoList=" + productCategoryVoList
				+ ", productList=" + productList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productCategory == null) ? 0 : productCategory.hashCode());
		result = prime
				* result
				+ ((productCategoryVoList == null) ? 0 : productCategoryVoList
						.hashCode());
		result = prime * result
				+ ((productList == null) ? 0 : productList.hashCode());
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
		ProductCategoryVo other = (ProductCategoryVo) obj;
		if (productCategory == null) {
			if (other.productCategory != null)
				return false;
		} else if (!productCategory.equals(other.productCategory))
			return false;
		if (productCategoryVoList == null) {
			if (other.productCategoryVoList != null)
				return false;
		} else if (!productCategoryVoList.equals(other.productCategoryVoList))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		return true;
	}
	
	
    
    
}
