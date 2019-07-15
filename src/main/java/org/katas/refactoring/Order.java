package org.katas.refactoring;

import java.util.List;

public class Order {

    private String name;
    private String address;
    private List<LineItem> itemList;

    public Order(String name, String address, List<LineItem> itemList) {
        this.name = name;
        this.address = address;
        this.itemList = itemList;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return itemList;
    }

}
