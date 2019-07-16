package org.katas.refactoring;

import java.util.Collection;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {

    public static final double TAX_RATE = .10;

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {

        StringBuilder output = new StringBuilder();

        printHeaders(output);

        printNameAndAddress(output);

        printLineItems(output);

        printStateTax(output);

        printTotalAmount(output);

        return output.toString();

    }


    private void printHeaders(StringBuilder output){
        output.append("======Printing Orders======\n");
    }

    private void printNameAndAddress(StringBuilder output){

        output.append(this.order.getCustomerName());
        output.append(this.order.getCustomerAddress());

    }

    private void printLineItems(StringBuilder output){

        for (LineItem lineItem : this.order.getItemList()) {

            printLineItem(output,lineItem);

        }

    }

    private void printLineItem(StringBuilder output,LineItem lineItem){
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.getTotalAmount());
        output.append('\n');
    }

    private void printStateTax(StringBuilder output){

        double totalSalesTx = order.getItemList().stream().mapToDouble(
                lineItem -> {
                    double salesTax  = lineItem.getTotalAmount() * TAX_RATE;
                    return salesTax;
                }).sum();

        output.append("Sales Tax").append('\t').append(totalSalesTx);
    }

    private void printTotalAmount(StringBuilder output){

        double totalAmountOfLineItem = order.getItemList().stream().mapToDouble(
                lineItem -> {
                    double salesTax  = lineItem.getTotalAmount() * TAX_RATE;
                    double amountOfLineItem = lineItem.getTotalAmount() + salesTax ;
                    return amountOfLineItem;
                }).sum();

        output.append("Total Amount").append('\t').append(totalAmountOfLineItem);

    }
}