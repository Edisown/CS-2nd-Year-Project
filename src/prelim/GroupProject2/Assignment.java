/**
 * The Assignment class extends the Announcement class and adds a due date
 * to represent a student's assignment in the Google Classroom system.
 *
 * Author: Espartinas, Carl Angelo B.
 * Date: 9/16/2024
 */

package prelimproject2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Represents an assignment with a title, description, posting date, and due date.
 * Inherits from the Announcement class.
 */
public class Assignment extends Announcement {
    private LocalDateTime dueDate;

    /**
     * Constructs an Assignment with the specified title, description, posting date, and due date.
     *
     * @param title      The title of the assignment.
     * @param desc       The description of the assignment.
     * @param datePosted The date and time the assignment was posted.
     * @param dueDate    The date and time the assignment is due.
     */
    public Assignment(String title, String desc, LocalDateTime datePosted, LocalDateTime dueDate) {
        super(title, desc, datePosted);
        this.dueDate = dueDate;
    }

    /**
     * Gets the due date of the assignment.
     *
     * @return The due date of the assignment.
     */
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date of the assignment.
     *
     * @param dueDate The new due date to set.
     */
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Returns a string representation of the assignment, including the title,
     * description, date posted, and due date.
     *
     * @return A formatted string of the assignment details.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy hh:mm a");
        return super.toString() + " due " + formatter.format(dueDate);
    }

    /**
     * Compares this assignment with another object for equality.
     * Two assignments are considered equal if they have the same due date.
     *
     * @param o The object to compare with.
     * @return true if the assignments have the same due date, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return Objects.equals(dueDate, that.dueDate);
    }
}
