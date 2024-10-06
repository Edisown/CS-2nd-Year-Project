/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim.MyFixedArrayList;

public class Product {
    private String modelNumber; // The model number of the product
    private String color;       // The color of the product
    private String status;      // The status of the product
    private int quantity;       // The quantity of the product in stock

    /**
     * Constructs a Product with specified attributes.
     *
     * @param modelNumber The model number of the product.
     * @param color       The color of the product.
     * @param status      The status of the product.
     * @param quantity    The quantity of the product in stock.
     */
    public Product(String modelNumber, String color, String status, int quantity) {
        this.modelNumber = modelNumber;
        this.color = color;
        this.status = status;
        this.quantity = quantity;
    }

    /**
     * Returns the model number of the product.
     *
     * @return The model number of the product.
     */
    public String getModelNumber() {
        return modelNumber;
    }

    /**
     * Sets the model number of the product.
     *
     * @param modelNumber The model number to set.
     */
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    /**
     * Returns the color of the product.
     *
     * @return The color of the product.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the product.
     *
     * @param color The color to set.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Returns the status of the product.
     *
     * @return The status of the product.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the product.
     *
     * @param status The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the quantity of the product in stock.
     *
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in stock.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of the product formatted in a tabular style.
     *
     * @return A formatted string representing the product.
     */
    @Override
    public String toString() {
        // Format the output
        return String.format(
                "\n---------------------------------------------------------------------------------------\n" +
                        "                                      PRODUCT\n" +
                        "---------------------------------------------------------------------------------------\n" +
                        "   MODEL NUMBER                   COLOR                           STATUS                          QUANTITY\n" +
                        "---------------------------------------------------------------------------------------\n" +
                        "   %-30s  %-30s  %-30s  %-10d\n" +
                        "---------------------------------------------------------------------------------------",
                modelNumber,
                color,
                status,
                quantity
        );
    }
}
