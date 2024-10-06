package prelimproject2;

/**
 * The GoogleClassroom interface defines the operations for managing students,
 * assignments, and announcements within a course.
 */
public interface GoogleClassroom {

    /**
     * Enrolls a student in a course.
     *
     * @param student The student to be enrolled.
     * @param course  The course in which the student will be enrolled.
     */
    void enrollStudent(Student student, Course course);

    /**
     * Removes a student from a course.
     *
     * @param student The student to be removed.
     * @param course  The course from which the student will be removed.
     */
    void removeStudent(Student student, Course course);

    /**
     * Assigns an assignment to a course.
     *
     * @param assignment The assignment to be given.
     * @param course     The course to which the assignment will be assigned.
     */
    void giveAssignment(Assignment assignment, Course course);

    /**
     * Makes an announcement in a course.
     *
     * @param announcement The announcement to be made.
     * @param course       The course where the announcement will be made.
     */
    void announce(Announcement announcement, Course course);
}
