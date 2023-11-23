 package com.spring_mvc.admin.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;
import com.spring_mvc.admin.entities.Category;
import com.spring_mvc.admin.validator.FileNotNull;
import com.spring_mvc.admin.validator.ValidImage;

public class ProductDTO {

	private Integer productId;
	@NotEmpty(message = "Tên không được để trống")
	private String productName;
	@FileNotNull(message = "File không được để trống")
	@ValidImage(type = {"image/jpeg","image/png","image/jpg"},message = "File  không đúng định dạng")
	private MultipartFile image;
	@NotNull(message = "Giá không được để trống")
	private Double price;
	@NotNull(message = "Bạn chưa nhập giá sale")
	private Double sale_price; 
	@NotEmpty(message = "Bạn chưa nhập mô tả")
	private String description;
	@ManyToOne
	@JoinColumn(name = "categoryId",referencedColumnName = "categoryId")
	private Category category;
	public ProductDTO() {
		
	}
	public ProductDTO(Integer productId, @NotEmpty(message = "Tên không được để trống") String productName,
			MultipartFile image, @NotNull(message = "Giá không được để trống") Double price,
			@NotNull(message = "Bạn chưa nhập giá sale") Double sale_price,
			@NotEmpty(message = "Bạn chưa nhập mô tả") String description, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.image = image;
		this.price = price;
		this.sale_price = sale_price;
		this.description = description;
		this.category = category;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSale_price() {
		return sale_price;
	}

	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
