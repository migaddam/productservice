package com.hsbc.productservice.dto;

public class AddProduct {

    private String name;
    private String description;
    private String ImageUrl;
    private String createdBy;
    private String modifiedBy;
    private Integer stock;
    private Integer originalStock;
    private Float pricePerUnit;
    private Float originalPricePerUnit;

    public AddProduct() {
    }

    public AddProduct(String name, String description, String imageUrl, String createdBy, String modifiedBy, Integer stock, Integer originalStock, Float pricePerUnit, Float originalPricePerUnit) {
        this.name = name;
        this.description = description;
        ImageUrl = imageUrl;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.stock = stock;
        this.originalStock = originalStock;
        this.pricePerUnit = pricePerUnit;
        this.originalPricePerUnit = originalPricePerUnit;
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

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Float getOriginalPricePerUnit() {
        return originalPricePerUnit;
    }

    public void setOriginalPricePerUnit(Float originalPricePerUnit) {
        this.originalPricePerUnit = originalPricePerUnit;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", stock=" + stock +
                ", originalStock=" + originalStock +
                ", pricePerUnit=" + pricePerUnit +
                ", originalPricePerUnit=" + originalPricePerUnit +
                '}';
    }

}
