/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim.MyGrowingArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a project with a name, assigned date, and submission date.
 */
public class CourseProject {
    private String projectName;
    private LocalDate dateAssigned;
    private LocalDate dateSubmitted;

    // Date formatter for formatting dates as strings
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructs a CourseProject with the specified project name, assigned date, and submission date.
     *
     * @param projectName    The name of the project.
     * @param dateAssigned   The date the project was assigned.
     * @param dateSubmitted  The date the project was submitted.
     */
    public CourseProject(String projectName, LocalDate dateAssigned, LocalDate dateSubmitted) {
        this.projectName = projectName;
        this.dateAssigned = dateAssigned;
        this.dateSubmitted = dateSubmitted;
    }

    /**
     * Returns the name of the project.
     *
     * @return The project name.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets the name of the project.
     *
     * @param projectName The project name to set.
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Returns the date the project was assigned.
     *
     * @return The date assigned.
     */
    public LocalDate getDateAssigned() {
        return dateAssigned;
    }

    /**
     * Sets the date the project was assigned.
     *
     * @param dateAssigned The date assigned to set.
     */
    public void setDateAssigned(LocalDate dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    /**
     * Returns the date the project was submitted.
     *
     * @return The date submitted.
     */
    public LocalDate getDateSubmitted() {
        return dateSubmitted;
    }

    /**
     * Sets the date the project was submitted.
     *
     * @param dateSubmitted The date submitted to set.
     */
    public void setDateSubmitted(LocalDate dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    /**
     * Returns a string representation of the CourseProject, formatted to show project details in a table format.
     *
     * @return A formatted string representing the project.
     */
    @Override
    public String toString() {
        // Format the dates as strings
        String formattedDateAssigned = dateAssigned.format(dateFormatter);
        String formattedDateSubmitted = dateSubmitted.format(dateFormatter);

        // Format the output
        return String.format(
                "\n---------------------------------------------------------------------------------------\n" +
                        "                               COURSE PROJECT\n" +
                        "---------------------------------------------------------------------------------------\n" +
                        "   PROJECT NAME                   DATE ASSIGNED                   DATE SUBMITTED\n" +
                        "---------------------------------------------------------------------------------------\n" +
                        "   %-30s  %-30s  %-30s\n" +
                        "---------------------------------------------------------------------------------------",
                projectName,
                formattedDateAssigned,
                formattedDateSubmitted
        );
    }
}
