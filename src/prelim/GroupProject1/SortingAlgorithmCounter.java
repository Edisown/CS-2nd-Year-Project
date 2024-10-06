/**
 * Authors:
 * Xymond Louisse M. Alcazar
 *
 *
 * Date: August 22, 2024
 */
package PrelimProject;

import java.text.NumberFormat;

public class SortingAlgorithmCounter implements SortAlgoProfiler {
    private static long programCounter = 0;


    /**
     * Return the number of statement executions after sorting
     * an array using the bubble sort algorithm
     * @param customers The array that will be sorted
     * @return The number of statement executions
     */
    public long getBubbleSortStatementDate(Customer[] customers){
        boolean swapped;
        incrementCount(1);
        for (int i = 0; i < customers.length - 1; i++){
            incrementCount(2);
            swapped = false;
            incrementCount(1);
            for (int j = 0; j < customers.length-i-1; j++){
                incrementCount(2);
                if (customers[j].getDateAndTime().isAfter(customers[j+1].getDateAndTime())){
                    incrementCount(3); //getter method calls and isAfter comparison
                    Customer temp = customers[j];
                    customers[j] = customers[j+1];
                    customers[j+1] = temp;
                    swapped = true;
                    incrementCount(4); // 4 assignment statements
                }
            }
            if (!swapped){
                incrementCount(2);
                break;
            }
        }
        incrementCount(1);
        return programCounter;
    }

    /**
     * Return the number of statement executions after sorting
     * an array using the insertion sort algorithm
     * @param customer The array that will be sorted
     * @return The number of statement executions
     */
    public long getInsertionSortStatementDate(Customer[] customer) { // Changed parameter name to customer
        resetCounter();

        for (int i = 1; i < customer.length; i++) {
            incrementCount(2); //adds 2 for variable assignment and logical comparison
            Customer temp = customer[i]; // temporary variable to store the taken element.
            int j = i - 1; // stores the prior element of the customer array to j.
            incrementCount(2);//assignments

            while (j >= 0 && customer[j].getDateAndTime().isAfter(temp.getDateAndTime())) {
                incrementCount(4); //j>=0 and getter methods and compareTo method usage
                customer[j + 1] = customer[j]; // shifts the element to the right.
                j--; // decrements j to compare the taken element to other elements to the left.
                incrementCount(2); // assignment and decrement
            }
            customer[j + 1] = temp; // stores the taken element to the empty index.
            incrementCount(1);
        }
        incrementCount(1);
        return programCounter; // Return the programCounter
    }

    /**
     * Return the number of statement executions after sorting
     * an array using the selection sort algorithm
     * @param customer The array that will be sorted
     * @return The number of statement executions
     */
    public long getSelectionSortStatementDate(Customer[] customer) { // Changed parameter name to customer
        int minIndex;
        incrementCount(1);
        resetCounter();
        for (int i = 0; i < customer.length - 1; i++) {
            incrementCount(2);//i=0, i++
            minIndex = i; // sets/selects the first element to minimum index variable.
            incrementCount(1);//minIndex=i

            for (int j = i + 1; j < customer.length; j++) {
                incrementCount(2);//j assignment and j++
                if (customer[j].getDateAndTime().isBefore(customer[minIndex].getDateAndTime())) { // Fixed comparison for finding the minimum
                    incrementCount(3);//getter methods and compareTo method usage
                    minIndex = j; // changes the minimum index value to an element lesser than the current minimum.
                    incrementCount(1);
                }
            }
            // Swapping Method (this swaps the selected minimum index value and the first index)
            // For the succeeding iterations, the minimum index value will get stored to the next index (i.e. index 2 until customer.length - 1).
            Customer temp = customer[minIndex];
            customer[minIndex] = customer[i];
            customer[i] = temp;
            incrementCount(3);//swapping method
        }
        incrementCount(1);
        return programCounter; // Return the programCounter
    }

    /**
     * Increments the number of statement executions by
     * the given number
     * @param increment The number that will be added to the
     *                  counter
     */
    private void incrementCount(int increment){
        programCounter += increment;
    }

    /**
     * Resets the counter back to zero
     */
    public void resetCounter(){
        programCounter = 0;
    }

    /**
     * Returns a string format of the number of
     * statement executions for better readability
     * @return The string representation of the
     *         number of statement executions
     */
    public static String getCount(){
        NumberFormat formatter = NumberFormat.getInstance();
        return formatter.format(programCounter);
    }
}
