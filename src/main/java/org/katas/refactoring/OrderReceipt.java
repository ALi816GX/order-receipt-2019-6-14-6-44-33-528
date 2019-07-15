package org.katas.refactoring;

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

        double totSalesTx = 0d;
        double totAmountOfLineItem = 0d;

        for (LineItem lineItem : this.order.getLineItems()) {

            printLineItem(output,lineItem);

            double salesTax = lineItem.totalAmount() * TAX_RATE;
            totSalesTx += salesTax;

            totAmountOfLineItem += lineItem.totalAmount() + salesTax;
        }

        printStateTax(output,totSalesTx);

        printTotalAmount(output,totAmountOfLineItem);

    }

    private void printLineItem(StringBuilder output,LineItem lineItem){
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
    }


    private void printStateTax(StringBuilder output,double totSalesTx){
        output.append("Sales Tax").append('\t').append(totSalesTx);
    }

    private void printTotalAmount(StringBuilder output,double totAmountOfLineItem){
        output.append("Total Amount").append('\t').append(totAmountOfLineItem);
    }
}