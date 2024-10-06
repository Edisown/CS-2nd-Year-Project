/**
 * Author: Edison Malasan
 * 8/22/2024
 */
package PrelimProject;

import java.time.LocalDateTime;

public class Customer implements Comparable<Customer> {
    private String customerID;
    private String customerName;
    private String orderID;
    private int quantity;
    private LocalDateTime dateAndTime;

    /**
     * Constructor of {@code Customer} that will initialize values to
     * the attributes of Customer
     * @param customerID The ID unique to a single {@code Customer}
     * @param customerName The full name of the {@code Customer}
     * @param orderID The ID unique to an order made by a {@code Customer}
     * @param quantity The quantity of the order
     * @param dateAndTime The date and time the order was made
     */
    public Customer(String customerID, String customerName, String orderID, int quantity, LocalDateTime dateAndTime) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.orderID = orderID;
        this.quantity = quantity;
        this.dateAndTime = dateAndTime;
    }

    /**
     * Returns the ID of a {@code Customer}
     * @return The string representation of the {@code customerID}
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Assigns a unique {@code customerID} to a {@code Customer}
     * @param customerID The {@code customerID} that will be assigned to a {@code Customer}
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * Returns the name of a {@code Customer}
     * @return The string representation of a {@code Customer}'s name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Assign a name to a {@code Customer}
     * @param customerName The name that will be assigned to
     *                     the {@code Customer}
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Returns the {@code orderID} of an order made by a {@code Customer}
     * @return The string representation of a {@code Customer}'s {@code orderID}
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * Assign a unique {@code orderID} of an order made by a
     * {@code Customer}
     * @param orderID The ID that will be assigned to
     *                     the order of a {@code Customer}
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * Returns the {@code quantity} of an order of a {@code Customer}
     * @return The integer representation of a {@code Customer}'s
     * order {@code quantity}
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Assign a number that will tell the order's {@code quantity}
     * by a {@code Customer}
     * @param quantity The number of orders made by a Customer
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the {@code dateAndTime} that a {@code Customer} has made an order
     * @return The date and time the order was made
     */
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    /**
     * Assign the {@code dateAndTime} that an order has been made by
     * a {@code Customer}
     * @param dateAndTime The date and time that will be assigned
     */
    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    /**
     * Returns the string representation of a {@code Customer}
     * @return The string format of a {@code Customer}
     */
    @Override
    public String toString() {
        return customerID+","+customerName+","+orderID+","+quantity+","+dateAndTime;
    }

    /**
     * Compares the {@code dateAndTime} of different {@code Customer}s
     * @param other the object to be compared.
     * Returns: 1 if this {@code dateAndTime} is after the {@code dateAndTime}
     * being compared to
     * Returns : -1 if the {@code dateAndTime} is before the {@code dateAndTime}
     * being compared to
     * @return : 0 if both {@code dateAndTime}'s are the same
     */
    @Override
    public int compareTo(Customer other) {
        if (this.dateAndTime.isAfter(other.getDateAndTime())){
            return 1;
        }else if(this.dateAndTime.isBefore(other.getDateAndTime())){
            return -1;
        }else{
            return 0;
        }
    }
}
