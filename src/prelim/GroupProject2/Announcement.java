package prelimproject2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Announcement class represents an announcement in the Google Classroom system.
 * It contains details such as the title, description, and the date it was posted.
 */
public class Announcement {
    private String title;
    private String desc;
    private LocalDateTime datePosted;

    /**
     * Default constructor that initializes the announcement with empty title, description,
     * and null date.
     */
    public Announcement() {
        title = "";
        desc = "";
        datePosted = null;
    }

    /**
     * Constructor that initializes the announcement with the specified title, description,
     * and date it was posted.
     *
     * @param title The title of the announcement.
     * @param desc The description of the announcement.
     * @param datePosted The date and time when the announcement was posted.
     */
    public Announcement(String title, String desc, LocalDateTime datePosted) {
        this.title = title;
        this.desc = desc;
        this.datePosted = datePosted;
    }

    /**
     * Gets the title of the announcement.
     *
     * @return The title of the announcement.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the announcement.
     *
     * @param title The title to set for the announcement.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the announcement.
     *
     * @return The description of the announcement.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the description of the announcement.
     *
     * @param desc The description to set for the announcement.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Gets the date when the announcement was posted.
     *
     * @return The date and time when the announcement was posted.
     */
    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    /**
     * Sets the date when the announcement was posted.
     *
     * @param datePosted The date and time to set for the announcement.
     */
    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }

    /**
     * Converts the announcement to a formatted string representation.
     *
     * @return A string representation of the announcement in the format:
     * "title posted on date".
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy hh:mm a");
        return title + " posted on " + formatter.format(datePosted);
    }

    /**
     * Compares this announcement to another announcement for equality.
     *
     * @param other The announcement to compare with.
     * @return true if the announcements are considered equal, false otherwise.
     */
    public boolean equals(Announcement other) {
        return false;
    }
}
