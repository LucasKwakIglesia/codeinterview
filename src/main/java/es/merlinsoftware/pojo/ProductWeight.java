package es.merlinsoftware.pojo;

public class ProductWeight {

    private Long productId;
    private Double weight;

    public ProductWeight(Long productId, Double weight) {
        this.productId = productId;
        this.weight = weight;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
