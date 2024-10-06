/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */

package prelim.MyGrowingArrayList;

import prelim.ListOverflowException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Test  {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        MyGrowingArrayList<CourseProject> projectList = new MyGrowingArrayList<>();

        while (true) {
            System.out.println("\n[1] Store Completed Project");
            System.out.println("[2] View Completed Project");
            System.out.println("[3] Exit Program");
            System.out.print("Choose an option: ");

            String choice = bufferedReader.readLine();
            int option = Integer.parseInt(choice);

            switch (option) {
                case 1 -> {
                    System.out.print("\nName of the Project: ");
                    String nameOfProject = bufferedReader.readLine();

                    System.out.print("\nDate Assigned (e.g., day/month/year (01/02/2024)): ");
                    String dateAssignedInput = bufferedReader.readLine();

                    System.out.print("\nDate Submitted (e.g., day/month/year (01/02/2024)) : ");
                    String dateSubmittedInput = bufferedReader.readLine();

                    LocalDate dateAssigned = null;
                    LocalDate dateSubmitted = null;

                    try {
                        dateAssigned = LocalDate.parse(dateAssignedInput, dateTimeFormatter);
                        dateSubmitted = LocalDate.parse(dateSubmittedInput, dateTimeFormatter);
                    } catch (DateTimeParseException ex) {
                        System.out.println("Error parsing dates. Please check your format.");
                    }

                    if (dateAssigned != null && dateSubmitted != null) {
                        CourseProject courseProject = new CourseProject(nameOfProject, dateAssigned, dateSubmitted);

                        System.out.println("\nProject to be Added: " + courseProject.toString());
                        System.out.print("\nConfirm (Y/N): ");
                        String confirmChoice = bufferedReader.readLine();

                        if (confirmChoice.toLowerCase().equals("y")) {
                            try {
                                projectList.insert(courseProject);
                                System.out.println("Project successfully added in the List\n");
                            } catch (ListOverflowException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("Project Not Added\n");
                        }
                    } else {
                        System.out.println("Project not added due to invalid dates.\n");
                    }
                }
                case 2 -> {
                    if (projectList.getSize() == 0) {
                        System.out.println("There's no item on the list");
                    } else {
                        System.out.println("Item on the list: ");
                        for (int i = 0; i< projectList.getSize(); i++) {
                            try {
                                CourseProject courseProject = projectList.getElement(i);
                                System.out.println(courseProject);
                            } catch (IndexOutOfBoundsException ex) {
                                System.out.println("No Project Found");
                            }
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Thank you for using the program!");
                    bufferedReader.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice. Please Try Again.");
            }

        }
    }
}
