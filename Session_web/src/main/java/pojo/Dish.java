package pojo;

public class Dish {
    private Long id;
    private String name;
    private Double price;
    private String description;

    public Dish() {
    }

    public Dish(Long id, String name, Double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * 获取
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Dish{id = " + id + ", name = " + name + ", price = " + price + ", description = " + description + "}";
    }
}
