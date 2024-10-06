/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim.MyFixedArrayList;

import prelim.ListOverflowException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        MyFixedArrayList<Product> list = new MyFixedArrayList<>();

        while (true) {
            System.out.println("\n[1] Add Product");
            System.out.println("[2] View Product");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");

            String choice = bufferedReader.readLine();
            int option = Integer.parseInt(choice);

            switch (option) {
                case 1 -> {
                    System.out.print("\nModel Number: ");
                    String modelNumber = bufferedReader.readLine();

                    System.out.print("Color: ");
                    String color = bufferedReader.readLine();

                    String productStatus = null;
                    while (productStatus == null) {
                        System.out.println("\n[1] Like New");
                        System.out.println("[2] Good");
                        System.out.println("[3] Old");
                        System.out.print("Product Status: ");

                        String statusChoice = bufferedReader.readLine();
                        switch (statusChoice) {
                            case "1" -> productStatus = "Like New";
                            case "2" -> productStatus = "Good";
                            case "3" -> productStatus = "Old";
                            default -> System.out.println("Invalid Choice. Please Try Again");
                        }
                    }

                    System.out.print("Quantity: ");
                    int quantity = Integer.parseInt(bufferedReader.readLine());

                    Product product = new Product(modelNumber, color, productStatus, quantity);

                    System.out.println("\nItem to be Added: " + product.toString());
                    System.out.print("Confirm (Y/N): ");
                    String confirmChoice = bufferedReader.readLine();;

                    if (confirmChoice.toLowerCase().equals("y")) {
                        try {
                            list.insert(product);
                            System.out.println("Item Added Successfully.");
                        } catch (ListOverflowException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        System.out.println("Item not Added.");
                    }
                }
                case 2 -> {
                    if (list.getSize() == 0) {
                        System.out.println("There's no item on the list");
                    } else {
                        System.out.println("\nItem on the list: ");
                        for (int i = 0; i < list.getSize(); i++) {
                            try {
                                Product product = list.getElement(i);
                                System.out.println(product);
                            } catch (IndexOutOfBoundsException ex) {
                                System.out.println("No Product Found");
                            }
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Thank you for using the program!");
                    bufferedReader.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please Try Again.");
            }
        }
    }
}
