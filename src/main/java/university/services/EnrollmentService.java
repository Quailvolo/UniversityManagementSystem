package university.services;

import university.entities.Course;
import university.entities.Enrollment;
import university.entities.Student;
import university.enums.Grade;
import university.util.GPAUtils;

public class EnrollmentService {

    private final Enrollment[] enrollments = new Enrollment[500];
    private int count = 0;

    public void enrollStudent(Student student, Course course, String semester) {

        if (count >= enrollments.length) {
            throw new IllegalArgumentException("Масив зарахувань заповнений.");
        }

        enrollments[count] = new Enrollment(count + 1, student, course, semester);
        count++;

        System.out.println("Студента успішно зараховано на курс.");
    }

    public Enrollment findById(int id) {

        for (int i = 0; i < count; i++) {
            if (enrollments[i].getId() == id) {
                return enrollments[i];
            }
        }

        return null;
    }

    public void setGrade(int enrollmentId, Grade grade) {

        Enrollment enrollment = findById(enrollmentId);

        if (enrollment == null) {
            System.out.println("Зарахування не знайдено.");
            return;
        }

        enrollment.setGrade(grade);
        System.out.println("Оцінку встановлено.");
    }

    public void markAsPaid(int enrollmentId) {

        Enrollment enrollment = findById(enrollmentId);

        if (enrollment == null) {
            System.out.println("Зарахування не знайдено.");
            return;
        }

        enrollment.setPaid(true);
        System.out.println("Оплату підтверджено.");
    }

    public void showStudentEnrollments(int studentId) {

        Enrollment[] studentEnrollments = new Enrollment[100];
        int studentCount = 0;

        for (int i = 0; i < count; i++) {

            if (enrollments[i].getStudent().getId() == studentId) {

                System.out.println(enrollments[i]);
                studentEnrollments[studentCount++] = enrollments[i];

            }

        }

        if (studentCount == 0) {
            System.out.println("У студента немає зарахувань.");
            return;
        }

        double gpa = GPAUtils.calculateGPA(studentEnrollments, studentCount);

        System.out.printf("GPA студента: %.2f%n", gpa);
    }

    public void printTranscript(int studentId) {

        System.out.println("\n========== TRANSCRIPT ==========");

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (enrollments[i].getStudent().getId() == studentId) {

                System.out.println("Course: " + enrollments[i].getCourse().getTitle());
                System.out.println("Grade: " + enrollments[i].getGrade());
                System.out.println("Semester: " + enrollments[i].getSemester());
                System.out.println("--------------------------");

                found = true;
            }

        }

        if (!found) {
            System.out.println("Транскрипт порожній.");
        }
    }

    public void showUnpaidEnrollments() {

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (!enrollments[i].isPaid()) {
                System.out.println(enrollments[i]);
                found = true;
            }

        }

        if (!found) {
            System.out.println("Усі курси оплачені.");
        }
    }

    public Enrollment[] getEnrollments() {
        return enrollments;
    }

    public int getCount() {
        return count;
    }
}
