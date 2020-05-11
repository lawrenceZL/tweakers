package com.data.model;

public class Tweakers extends Entity {

    private int id;

    private String type;

    private String product;

    private String name;

    private String price;

    public Tweakers() {
        super();
    }

    public Tweakers(String type, String product, String name, String price) {
        this();
        this.type = type;
        this.product = product;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
