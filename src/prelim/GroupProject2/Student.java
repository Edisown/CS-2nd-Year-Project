package prelimproject2;

import java.util.Objects;

/**
 * Represents a student with a name and an email address.
 *
 * <p>Author: Roxas, Jhorone Lance M.</p>
 * <p>Date: 9/16/2024</p>
 */
public class Student implements Comparable<Student> {
    private String name;
    private String email;

    /**
     * Constructs a Student with the specified name and email.
     *
     * @param name The name of the student.
     * @param email The email of the student.
     */
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Gets the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     *
     * @param name The name to set for the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the student.
     *
     * @return The email of the student.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the student.
     *
     * @param email The email to set for the student.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of the student, which is the student's name.
     *
     * @return The student's name as a string.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Checks if this student is equal to another object.
     * Two students are considered equal if they have the same name and email.
     *
     * @param obj The object to compare with this student.
     * @return True if this student is equal to the specified object, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return Objects.equals(name, student.name) && Objects.equals(email, student.email);
    }

    /**
     * Compares this student to another student based on their names.
     *
     * @param other The other student to compare with.
     * @return A negative integer, zero, or a positive integer as this student's name
     *         is lexicographically less than, equal to, or greater than the other student's name.
     */
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}// end of class
