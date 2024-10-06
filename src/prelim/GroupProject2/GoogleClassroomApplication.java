package prelimproject2;
import java.time.LocalDateTime;
import java.util.Scanner;

public class GoogleClassroomApplication implements GoogleClassroom{

    GoogleClassroomList<Course> courses = new GoogleClassroomList<>();

    public static void main(String[] args) {
        GoogleClassroomApplication program;
        try{
            program = new GoogleClassroomApplication();
            program.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        System.out.println("Welcome to Google Classroom!");
        processMainMenuChoice();
    }

    // Displays the main menu for the application
    public void showMainMenu(){
        System.out.println();
        System.out.println("""
                Choose how to proceed among the following choices
                [1] Show Courses
                [2] Add Course
                [3] Remove Course
                [4] Exit""");
    }

    public void processMainMenuChoice(){
        while(true){
            showMainMenu();
            System.out.print("Choice: ");
            int choice = readInteger();
            switch (choice){
                case 1 -> {
                    System.out.printf("%n%n%s%n", "Choose which course to view");
                    courses.displayList();
                    chooseCourse();
                }
                case 2 -> courses.addToHead(describeCourse());
                case 3 -> {
                    System.out.print("Index of the course to remove: ");
                    int i = readInteger() - 1; // Adjust for zero-based index
                    if (i < 0 || i >= courses.getSize()) {
                        System.out.println("Please enter a valid index.");
                    } else if (courses.isEmpty()){
                        System.out.println("Nothing to remove");
                    }else {
                        courses.remove(courses.get(i));
                        System.out.println("Course removed successfully.");
                    }
                }
                case 4 -> System.exit(0);
                default -> {
                    System.out.println("Please enter a valid choice...");
                    showMainMenu();
                }
            }
        }
    }

    public void chooseCourse() {
        if (courses.isEmpty()) {
            System.out.println("No courses to view.");
            return;
        }

        boolean isValid = false;
        while (!isValid) {
            System.out.print("Enter course number: ");
            int choice = readInteger();
            if (choice > 0 && choice <= courses.getSize()) {
                Course selectedCourse = courses.get(choice - 1);
                processCourseMenuChoice(selectedCourse);
                isValid = true;  // Break loop on valid choice
            } else {
                System.out.println("Please enter a valid index.");
            }
        }
    }



    public void showCourseMenu(Course course){
        System.out.printf("\n\nWelcome to %s!%n%n", course);
        System.out.println("""
                [1] Show stream
                [2] Show assignments
                [3] Show students
                [4] Add assignment
                [5] Make an announcement
                [6] Enroll student
                [7] Remove student
                [8] Back to main
                """);
    }

    public void processCourseMenuChoice(Course course){
        while(true){
            showCourseMenu(course);
            System.out.print("Choice: ");
            int choice = readInteger();
            switch (choice){
                case 1 -> course.getAnnouncements().displayList();
                case 2 -> course.getAssignments().displayList();
                case 3 -> course.getStudents().displayList();
                case 4 -> giveAssignment(describeAssignment(), course);
                case 5 -> announce(describeAnnouncement(), course);
                case 6 -> enrollStudent(describeStudent(), course);
                case 7 -> removeStudent(describeStudent(), course);
                case 8 -> {
                    return;
                }
                default -> System.out.println("Please enter a valid choice...");
            }
        }
    }

    /**
     * Assigned to: JHORONE
     * 1. Get list of students from course
     * 2. Create new list of students and assign the retrieved list
     * 3. Add student to the created list
     * 4. Set the course's student list to the created list. (use setStudents())
     * 5. Prompt the user of the successful operation*/
    @Override
    public void enrollStudent(Student student, Course course) {

        // Create a new list of students and assign the retrieved list
        GoogleClassroomList<Student> newStudentList = course.getStudents();

        //  Add the student to the created list
        newStudentList.addToTail(student);

        //  Set the course's student list to the created list
        course.setStudents(newStudentList);

        // Prompt the user of the successful operation
        System.out.println("Student " + student.getName() + " has been successfully enrolled in the course " + course.getCourseName() + ".");


    }

    /**
     * Assigned to: CARL
     * 1. Get list of students from the course
     * 2. Create new list of students and assign the retrieved list to it
     * 3. Remove the said student from the created list
     * 4. Assign created list to course. use setStudents()
     * 5. Prompt user of the successful operation*/
    @Override
    public void removeStudent(Student student, Course course) {
        // Create a new list of students and assign the retrieved list
        GoogleClassroomList<Student> newStudentList = course.getStudents();

        // Remove the specified student from the list. Assuming the list already contains students.
        newStudentList.remove(student);

        // Update the course's student list to reflect the removal of the student
        course.setStudents(newStudentList);

        // Prompt the user of the successful operation
        System.out.println("Student " + student.getName() + " has been successfully removed in the course " + course.getCourseName() + ".");
    }

    /**
     * Assigned to: XYMOND
     * 1. Get list from course
     * 2. Assign list to created list
     * 3. Add assignment to created list
     * 4. Assign created list to course. Use setAssignments*/
    @Override
    public void giveAssignment(Assignment assignment, Course course) {
        GoogleClassroomList<Announcement> newAssignmentList = course.getAnnouncements();//creates LinkedList for the assignment.
        newAssignmentList.addToHead(assignment);//adds the newly made assignment to head to make it appear early (for prioritization).
        course.setAnnouncements(newAssignmentList);//adds the LinkedList to the course object.

        System.out.print("\n\n-- Assignment added successfully --\n\n");
    }

    /**
     * Assigned to: XYMOND
     * 1. Get list from course
     * 2. Assign list to created list
     * 3. Add announcement to created list
     * 4. Assign created list to course. Use setAnnouncements*/
    @Override
    public void announce(Announcement announcement, Course course) {
        GoogleClassroomList<Announcement> newAnnouncementList = course.getAnnouncements();//creates LinkedList for the assignment.
        newAnnouncementList.addToHead(announcement);//adds the newly made announcement to head to make it appear early (for prioritization).
        course.setAnnouncements(newAnnouncementList);//adds the LinkedList to the course object.

        System.out.print("\n\n-- Announcement added successfully --\n\n");
    }

    /**
     * Assigned to: ADRIA
     * 1. Ask for course name
     * 2. Return new course object with the course name*/
    public Course describeCourse(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        return new Course(courseName);
    }

    /**
     * Assigned to: WHAQUIN
     * 1. Ask for student name
     * 2. ASk for student email
     * 3. Return new student with the name and email*/
    public Student describeStudent(){
        Scanner stu = new Scanner(System.in);

        // Ask for student's name
        System.out.print("Enter student name: ");
        String name = stu.nextLine();

        // Ask for student's email
        System.out.print("Enter student email: ");
        String email = stu.nextLine();

        // Return a new Student object with the given name and email
        return new Student(name, email);
    }
    /**
     * Assigned to: ADRIA
     * 1. Ask for title
     * 2. Ask for description
     * 3. Return new announcement with the date as now. (LocalDateTime.now())
     * */
    public Announcement describeAnnouncement(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Announcement Title: ");
        String title = scan.nextLine();

        System.out.print("Enter Announcement Description: ");
        String description = scan.nextLine();

        LocalDateTime dateCreated = LocalDateTime.now();

        return new Announcement(title, description, dateCreated);
    }


    /**
     * Assigned to: WHAQUIN
     * 1. Ask for title
     * 2. Ask for description
     * 3. Ask for duration
     * 4. Return new assignment with the title, desc, and duration.
     *    The datePosted should be now (LocalDateTime.now()), and the dueDate should
     *    be the date now plus the duration (LocalDateTime.now.plusDays(duration))*/
    public Assignment describeAssignment() {
        Scanner ass = new Scanner(System.in);

        System.out.print("Enter assignment title: ");
        String title = ass.nextLine();

        System.out.print("Enter assignment description: ");
        String desc = ass.nextLine();

        System.out.print("Enter duration in days: ");
        int duration = readInteger();

        LocalDateTime datePosted = LocalDateTime.now();

        LocalDateTime dueDate = datePosted.plusDays(duration);

        return new Assignment(title, desc, datePosted, dueDate);
    }

    /**
     * Assigned to: XYMOND
     * 1. Prompts user to enter choice
     * 2. Throws number format exception when a non integer is inputted
     * 3. Will loop until a valid input is given*/
    public int readInteger(){
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        int choice = 0;
        while (!isValid){
            try{
                choice = Integer.parseInt(scan.nextLine());
                isValid = true;
            }catch (NumberFormatException e){
                System.out.println("Please enter a number");
            }
        }
        return choice;
    }
}


