/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.pojo;

/**
 *
 * @author sachi
 */
public class ProductsPojo {

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ProductsPojo() {
    }

    public ProductsPojo(String productId, String productName, String productCompanyName, double price, double ourPrice, int tax, int quantity,double total) {
        this.productId = productId;
        this.productName = productName;
        this.productCompanyName = productCompanyName;
        this.price = price;
        this.ourPrice = ourPrice;
        this.tax = tax;
        this.quantity = quantity;
        this.total = total;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCompanyName() {
        return productCompanyName;
    }

    public void setProductCompanyName(String productCompanyName) {
        this.productCompanyName = productCompanyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    private String productId;
    private String productName;
    private String productCompanyName;
    private double price;
    private double ourPrice;
    private int tax;
    private int quantity;
    private double total;
}
