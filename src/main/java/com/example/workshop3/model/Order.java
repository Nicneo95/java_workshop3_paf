package com.example.workshop3.model;

import java.sql.Date;

public class Order {
    private Integer orderId;
    private Date orderDate;
    private Integer customerId;
    private Float quantity;
    private Float unitPrice;
    private Float discount;
    private Float shippingFee;
    private Float cost;
    private Float totalCost;

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Float getQuantity() {
        return quantity;
    }
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }
    public Float getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Float getDiscount() {
        return discount;
    }
    public void setDiscount(Float discount) {
        this.discount = discount;
    }
    public Float getShippingFee() {
        return shippingFee;
    }
    public void setShippingFee(Float shippingFee) {
        this.shippingFee = shippingFee;
    }
    public Float getCost() {
        return cost;
    }
    public void setCost(Float cost) {
        this.cost = cost;
    }
    public Float getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

}
