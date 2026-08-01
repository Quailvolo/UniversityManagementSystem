package university;

import university.entities.Course;
import university.entities.Student;
import university.entities.Teacher;
import university.enums.StudentStatus;
import university.enums.TeacherPosition;
import university.services.CourseService;
import university.services.EnrollmentService;
import university.services.StudentService;
import university.services.TeacherService;
import java.util.Scanner;
import university.enums.Grade;

public class Main {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();
        Scanner scanner = new Scanner(System.in);

        Teacher teacher1 = new Teacher(
                1,
                "Іван Петренко",
                "ivan@university.com",
                TeacherPosition.PROFESSOR
        );

        teacherService.addTeacher(teacher1);

        Student student1 = new Student(
                1,
                "Володимир Перепелиця",
                "volodymyr@gmail.com",
                2,
                StudentStatus.ACTIVE
        );

        Student student2 = new Student(
                2,
                "Олександр Коваль",
                "alex@gmail.com",
                1,
                StudentStatus.ACTIVE
        );

        studentService.addStudent(student1);
        studentService.addStudent(student2);

        Course javaCourse = new Course(
                1,
                "Java Core",
                5,
                teacher1
        );

        courseService.addCourse(javaCourse);

        enrollmentService.enrollStudent(
                student1,
                javaCourse,
                "Spring 2026"
        );

        while (true) {

            try {

                System.out.println("\n==============================");
                System.out.println("UNIVERSITY MANAGEMENT SYSTEM");
                System.out.println("==============================");
                System.out.println("1. Students");
                System.out.println("2. Teachers");
                System.out.println("3. Courses");
                System.out.println("4. Enrollments");
                System.out.println("5. Reports");
                System.out.println("0. Exit");
                System.out.print("Choose: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:

                        while (true) {

                            System.out.println("\n----- STUDENTS -----");
                            System.out.println("1. Show all");
                            System.out.println("2. Add");
                            System.out.println("3. Delete");
                            System.out.println("4. Change status");
                            System.out.println("5. Search");
                            System.out.println("6. Sort");
                            System.out.println("0. Back");
                            System.out.print("Choose: ");

                            int studentChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (studentChoice) {

                                case 1:
                                    studentService.showAllStudents();
                                    break;

                                case 2:

                                    System.out.print("ID: ");
                                    int id = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Name: ");
                                    String name = scanner.nextLine();

                                    System.out.print("Email: ");
                                    String email = scanner.nextLine();

                                    System.out.print("Study year: ");
                                    int year = scanner.nextInt();
                                    scanner.nextLine();

                                    studentService.addStudent(
                                            new Student(
                                                    id,
                                                    name,
                                                    email,
                                                    year,
                                                    StudentStatus.ACTIVE
                                            )
                                    );

                                    System.out.println("Student added.");
                                    break;

                                case 3:

                                    System.out.print("Student ID: ");
                                    studentService.deleteStudent(scanner.nextInt());
                                    scanner.nextLine();
                                    break;

                                case 4:

                                    System.out.print("Student ID: ");
                                    int studentId = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("1 ACTIVE");
                                    System.out.println("2 ON_LEAVE");
                                    System.out.println("3 EXPELLED");
                                    System.out.println("4 GRADUATED");

                                    int status = scanner.nextInt();
                                    scanner.nextLine();

                                    StudentStatus newStatus = StudentStatus.ACTIVE;

                                    switch (status) {
                                        case 2 -> newStatus = StudentStatus.ON_LEAVE;
                                        case 3 -> newStatus = StudentStatus.EXPELLED;
                                        case 4 -> newStatus = StudentStatus.GRADUATED;
                                    }

                                    studentService.changeStatus(studentId, newStatus);

                                    break;

                                case 5:

                                    System.out.print("Search: ");
                                    studentService.searchStudents(scanner.nextLine());

                                    break;

                                case 6:

                                    studentService.sortByName();
                                    studentService.showAllStudents();

                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("Wrong choice.");
                            }

                            if (studentChoice == 0)
                                break;
                        }

                        break;

                    case 2:

                        while (true) {

                            System.out.println("\n----- TEACHERS -----");
                            System.out.println("1. Show all");
                            System.out.println("2. Add");
                            System.out.println("3. Delete");
                            System.out.println("0. Back");
                            System.out.print("Choose: ");

                            int teacherChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (teacherChoice) {

                                case 1:
                                    teacherService.showAllTeachers();
                                    break;

                                case 2:

                                    System.out.print("ID: ");
                                    int teacherId = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Name: ");
                                    String teacherName = scanner.nextLine();

                                    System.out.print("Email: ");
                                    String teacherEmail = scanner.nextLine();

                                    System.out.println("1. Assistant");
                                    System.out.println("2. Lecturer");
                                    System.out.println("3. Professor");

                                    int positionChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    TeacherPosition position = TeacherPosition.ASSISTANT;

                                    switch (positionChoice) {
                                        case 2 -> position = TeacherPosition.LECTURER;
                                        case 3 -> position = TeacherPosition.PROFESSOR;
                                    }

                                    teacherService.addTeacher(
                                            new Teacher(
                                                    teacherId,
                                                    teacherName,
                                                    teacherEmail,
                                                    position
                                            )
                                    );

                                    System.out.println("Teacher added.");

                                    break;

                                case 3:

                                    System.out.print("Teacher ID: ");
                                    teacherService.deleteTeacher(scanner.nextInt());
                                    scanner.nextLine();

                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("Wrong choice.");
                            }

                            if (teacherChoice == 0)
                                break;
                        }

                        break;

                    case 3:

                        while (true) {

                            System.out.println("\n----- COURSES -----");
                            System.out.println("1. Show all");
                            System.out.println("2. Add");
                            System.out.println("3. Delete");
                            System.out.println("0. Back");
                            System.out.print("Choose: ");

                            int courseChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (courseChoice) {

                                case 1:
                                    courseService.showAllCourses();
                                    break;

                                case 2:

                                    System.out.print("Course ID: ");
                                    int courseId = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Title: ");
                                    String title = scanner.nextLine();

                                    System.out.print("Credits: ");
                                    int credits = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Teacher ID: ");
                                    int teacherId = scanner.nextInt();
                                    scanner.nextLine();

                                    Teacher teacher = teacherService.findById(teacherId);

                                    if (teacher == null) {
                                        System.out.println("Teacher not found.");
                                        break;
                                    }

                                    courseService.addCourse(
                                            new Course(
                                                    courseId,
                                                    title,
                                                    credits,
                                                    teacher
                                            )
                                    );

                                    System.out.println("Course added.");

                                    break;

                                case 3:

                                    System.out.print("Course ID: ");
                                    courseService.deleteCourse(scanner.nextInt());
                                    scanner.nextLine();

                                    break;


                                case 0:
                                    break;

                                default:
                                    System.out.println("Wrong choice.");
                            }

                            if (courseChoice == 0)
                                break;
                        }

                        break;

                    case 4:

                        while (true) {

                            System.out.println("\n----- ENROLLMENTS -----");
                            System.out.println("1. Enroll student");
                            System.out.println("2. Set grade");
                            System.out.println("3. Mark as paid");
                            System.out.println("4. Show student enrollments");
                            System.out.println("5. Print transcript");
                            System.out.println("6. Show unpaid");
                            System.out.println("0. Back");
                            System.out.print("Choose: ");

                            int enrollmentChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (enrollmentChoice) {

                                case 1:

                                    System.out.print("Student ID: ");
                                    int studentId = scanner.nextInt();
                                    scanner.nextLine();

                                    Student student = studentService.findById(studentId);

                                    if (student == null) {
                                        System.out.println("Student not found.");
                                        break;
                                    }

                                    System.out.print("Course ID: ");
                                    int courseId = scanner.nextInt();
                                    scanner.nextLine();

                                    Course course = courseService.findById(courseId);

                                    if (course == null) {
                                        System.out.println("Course not found.");
                                        break;
                                    }

                                    System.out.print("Semester: ");
                                    String semester = scanner.nextLine();

                                    enrollmentService.enrollStudent(student, course, semester);

                                    break;

                                case 2:

                                    System.out.print("Enrollment ID: ");
                                    int enrollmentId = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("1 - A");
                                    System.out.println("2 - B");
                                    System.out.println("3 - C");
                                    System.out.println("4 - D");
                                    System.out.println("5 - F");

                                    int gradeChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    Grade grade = Grade.NA;

                                    switch (gradeChoice) {
                                        case 1 -> grade = Grade.A;
                                        case 2 -> grade = Grade.B;
                                        case 3 -> grade = Grade.C;
                                        case 4 -> grade = Grade.D;
                                        case 5 -> grade = Grade.F;
                                    }

                                    enrollmentService.setGrade(enrollmentId, grade);

                                    break;

                                case 3:

                                    System.out.print("Enrollment ID: ");
                                    enrollmentService.markAsPaid(scanner.nextInt());
                                    scanner.nextLine();

                                    break;

                                case 4:

                                    System.out.print("Student ID: ");
                                    enrollmentService.showStudentEnrollments(scanner.nextInt());
                                    scanner.nextLine();

                                    break;

                                case 5:

                                    System.out.print("Student ID: ");
                                    enrollmentService.printTranscript(scanner.nextInt());
                                    scanner.nextLine();

                                    break;

                                case 6:

                                    enrollmentService.showUnpaidEnrollments();

                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("Wrong choice.");
                            }

                            if (enrollmentChoice == 0)
                                break;
                        }

                        break;

                    case 5:

                        while (true) {

                            System.out.println("\n----- REPORTS -----");
                            System.out.println("1. Search student");
                            System.out.println("2. Filter by status");
                            System.out.println("3. Filter by study year");
                            System.out.println("4. Sort students");
                            System.out.println("5. Show unpaid enrollments");
                            System.out.println("0. Back");
                            System.out.print("Choose: ");

                            int reportChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (reportChoice) {

                                case 1:

                                    System.out.print("Search text: ");
                                    studentService.searchStudents(scanner.nextLine());

                                    break;

                                case 2:

                                    System.out.println("1 ACTIVE");
                                    System.out.println("2 ON_LEAVE");
                                    System.out.println("3 EXPELLED");
                                    System.out.println("4 GRADUATED");

                                    int statusChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    StudentStatus status = StudentStatus.ACTIVE;

                                    switch (statusChoice) {
                                        case 2 -> status = StudentStatus.ON_LEAVE;
                                        case 3 -> status = StudentStatus.EXPELLED;
                                        case 4 -> status = StudentStatus.GRADUATED;
                                    }

                                    studentService.filterByStatus(status);

                                    break;

                                case 3:

                                    System.out.print("Study year: ");
                                    studentService.filterByStudyYear(scanner.nextInt());
                                    scanner.nextLine();

                                    break;

                                case 4:

                                    studentService.sortByName();
                                    studentService.showAllStudents();

                                    break;

                                case 5:

                                    enrollmentService.showUnpaidEnrollments();

                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("Wrong choice.");
                            }

                            if (reportChoice == 0)
                                break;
                        }

                        break;

                    case 0:

                        System.out.println("Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Menu is under development...");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Некоректне введення.");
                scanner.nextLine();
            }
        }
    }
}
