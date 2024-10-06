/**
 * The Course class represents a course in the Google Classroom system.
 * It contains a list of students, announcements, and assignments for the course.
 *
 * Author: Malasan, Edison M.
 * <p>Date: 9/16/2024</p>
 */
package prelimproject2;

/**
 * Represents a course in Google Classroom with a name and lists of students,
 * announcements, and assignments.
 */
public class Course {
    private String courseName;
    private GoogleClassroomList<Student> students;
    private GoogleClassroomList<Announcement> announcements;
    private GoogleClassroomList<Assignment> assignments;

    /**
     * Constructs a Course with the specified name.
     * Initializes empty lists for students, announcements, and assignments.
     *
     * @param name The name of the course.
     */
    public Course(String name) {
        courseName = name;
        students = new GoogleClassroomList<>();
        announcements = new GoogleClassroomList<>();
        assignments = new GoogleClassroomList<>();
    }

    /**
     * Constructs a Course with the specified name, student list, announcement list, and assignment list.
     *
     * @param courseName     The name of the course.
     * @param students       The list of students in the course.
     * @param announcements  The list of announcements made in the course.
     * @param assignments    The list of assignments given in the course.
     */
    public Course(String courseName, GoogleClassroomList<Student> students, GoogleClassroomList<Announcement> announcements, GoogleClassroomList<Assignment> assignments) {
        this.courseName = courseName;
        this.students = students;
        this.announcements = announcements;
        this.assignments = assignments;
    }

    /**
     * Gets the name of the course.
     *
     * @return The name of the course.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of the course.
     *
     * @param courseName The new name of the course.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the list of students enrolled in the course.
     *
     * @return The list of students.
     */
    public GoogleClassroomList<Student> getStudents() {
        return students;
    }

    /**
     * Sets the list of students enrolled in the course.
     *
     * @param students The new list of students.
     */
    public void setStudents(GoogleClassroomList<Student> students) {
        this.students = students;
    }

    /**
     * Gets the list of announcements made in the course.
     *
     * @return The list of announcements.
     */
    public GoogleClassroomList<Announcement> getAnnouncements() {
        return announcements;
    }

    /**
     * Sets the list of announcements made in the course.
     *
     * @param announcements The new list of announcements.
     */
    public void setAnnouncements(GoogleClassroomList<Announcement> announcements) {
        this.announcements = announcements;
    }

    /**
     * Retrieves the list of assignments from the announcements.
     * This method scans the list of announcements and collects all instances
     * of Assignment objects.
     *
     * @return A list of assignments for the course.
     */
    public GoogleClassroomList<Assignment> getAssignments() {
        GoogleClassroomList<Assignment> assignments = new GoogleClassroomList<>();
        for (int i = 0; i < announcements.getSize(); i++) {
            if (announcements.get(i) instanceof Assignment) {
                assignments.addToHead((Assignment) announcements.get(i));
            }
        }
        return assignments;
    }

    /**
     * Sets the list of assignments for the course.
     *
     * @param assignments The new list of assignments.
     */
    public void setAssignments(GoogleClassroomList<Assignment> assignments) {
        this.assignments = assignments;
    }

    /**
     * Returns the course name as a string representation of the course.
     *
     * @return The name of the course.
     */
    @Override
    public String toString() {
        return courseName;
    }
}
