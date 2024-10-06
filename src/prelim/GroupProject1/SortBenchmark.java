package PrelimProject;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Authors:
 * Edison M. Malasan
 * Dadpaas, Renz C.
 * Alcazar, Xymond Louisse M.
 * Date: August 22, 2024
 * (Updated by Alcazar: September 1, 2024)
 */
public class SortBenchmark {
    private static final String fileName = "PrelimGroupProject1/Customer List/finalCustomer1M.csv";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final SortingAlgorithmCounter sortAlgorithmCounter = new SortingAlgorithmCounter(); //made this constant

    public static void main(String[] args) {
        SortBenchmark myProgram = new SortBenchmark();
        try {
            myProgram.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        List<Customer> records = readData();



        // Generate test cases
        Customer[] bestCase = generateCases(records, 500000, "Best Case");
//        displayContents(bestCase);
        Customer[] worstCase = generateCases(records, 500000, "Worst Case");
//        displayContents(worstCase);
        Customer[] averageCase = generateCases(records, 500000, "Average Case");
//        displayContents(averageCase);
        // Sort and count statements for different cases
        displayResults("Bubble Sort", bestCase, worstCase, averageCase);
        displayResults("Selection Sort", bestCase, worstCase, averageCase);
        displayResults("Insertion Sort", bestCase, worstCase, averageCase);
    }


    /**
     * Reads contents of a data file and adds them to a list
     * @return The list of objects created from the contents
     *         of the list
     */
    private List<Customer> readData() {
        List<Customer> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] element = line.split(",");
                String customerID = element[0];
                String customerName = element[1];
                String orderID = element[2];
                int quantity = Integer.parseInt(element[3]);
                LocalDateTime dateAndTime = LocalDateTime.parse(element[4], dateTimeFormatter);

                Customer customer = new Customer(customerID, customerName, orderID, quantity, dateAndTime);
                records.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    /**
     * Sorts a list arranged in a given case using the
     * identified algorithm and counts how many statements
     * have been executed
     * @param data The array that will be sorted
     * @param algorithmName The sorting algorithm that will
     *                      be used in sorting
     * @param caseType The case type or order of the list (descending,
     *                 ascending, or random)
     */
    private void sortAndCount(Customer[] data, String algorithmName, String caseType) {
        sortAlgorithmCounter.resetCounter();

        switch (algorithmName) {
            case "Bubble Sort" -> sortAlgorithmCounter.getBubbleSortStatementDate(data.clone());
            case "Insertion Sort" -> sortAlgorithmCounter.getInsertionSortStatementDate(data.clone());
            case "Selection Sort" -> sortAlgorithmCounter.getSelectionSortStatementDate(data.clone());
        }

        System.out.println(caseType + ": " + SortingAlgorithmCounter.getCount());
    }

    /**
     * Displays the result after sorting and counting for each case type
     * and sorting algorithm
     * @param algorithmName The sorting algorithm used to sort the list
     * @param bestCase The array arranged in descending order
     * @param worstCase The array arranged in ascending order
     * @param averageCase The array arranged randomly
     */
    private void displayResults(String algorithmName, Customer[] bestCase, Customer[] worstCase, Customer[] averageCase) {
        System.out.println("----------------------------------");
        System.out.println("           " + algorithmName);
        System.out.println("----------------------------------");
        System.out.println("Total Statements Executed\n");

        sortAndCount(bestCase, algorithmName, "Best Case");

        sortAndCount(worstCase, algorithmName, "Worst Case");

        sortAndCount(averageCase, algorithmName, "Average Case");

        System.out.println("----------------------------------");

    }

    /**
     * Generates an array with the identified size that is sorted
     * according to the case type: descending order (Best case),
     * ascending order (Worst case), average case (Average case)
     * @param customers The list where the contents of the arrays
     *                  will be derived from
     * @param size The size of the array that will be generated
     * @param caseType The case type which will determine the
     *                 order of sorting that will be done on
     *                 the array
     * @return An array that is of the given size and sorted according
     *         to case type
     * @throws IllegalArgumentException if there has been an error in input
     */
    public Customer[] generateCases(List<Customer> customers, int size, String caseType) throws IllegalArgumentException {
        List<Customer> subList = customers.subList(0, size);

        return switch (caseType) {
            case "Best Case" -> {
                Collections.sort(subList);
                yield subList.toArray(new Customer[0]);
            }
            case "Worst Case" -> {
                subList.sort(Collections.reverseOrder());
                yield subList.toArray(new Customer[0]);
            }
            case "Average Case" -> {
                Collections.shuffle(subList);
                yield subList.toArray(new Customer[0]);
            }
            default -> new Customer[0];
        }; //returns switch case itself instead of each case -Alcazar
    }


}
