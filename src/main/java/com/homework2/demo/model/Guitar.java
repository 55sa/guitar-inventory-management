package com.homework2.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "guitar")
public class Guitar {
    public Guitar() {
    }

    @Id
     @Column(name = "serialNumber")
    String serialNumber;

    @Column(name = "price")
    Double price;

    @Column(name = "builder")
    Builder builder;

    @Column(name = "model")
    String model;

    @Column(name = "type")
    Type type;
    @Column(name = "backwood")
    Wood backWood;
    @Column(name="topwood")
    Wood topWoop;




    public Guitar(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Guitar(Double price) {
        this.price = price;
    }


    public Guitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backwood, Wood topWood) {
        this.backWood=backwood;
        this.serialNumber=serialNumber;
        this.builder=builder;
        this.price=price;
        this.topWoop=topWood;
        this.model=model;
        this.type=type;
    }




    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public void setBackWood(Wood backWood) {
        this.backWood = backWood;
    }

    public Wood getTopWoop() {
        return topWoop;
    }

    public void setTopWoop(Wood topWoop) {
        this.topWoop = topWoop;
    }
}
