package university.services;

import university.entities.Student;
import university.enums.StudentStatus;

public class StudentService {

    private final Student[] students = new Student[100];
    private int count = 0;

    public void addStudent(Student student) {
        if (count >= students.length) {
            throw new IllegalArgumentException("Масив студентів заповнений.");
        }

        students[count++] = student;
    }

    public void showAllStudents() {

        if (count == 0) {
            System.out.println("Список студентів порожній.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }

    public Student findById(int id) {

        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }

        return null;
    }

    public void updateStudent(int id,
                              String fullName,
                              String email,
                              int studyYear,
                              StudentStatus status) {

        Student student = findById(id);

        if (student == null) {
            System.out.println("Студента не знайдено.");
            return;
        }

        student.setFullName(fullName);
        student.setEmail(email);
        student.setStudyYear(studyYear);
        student.setStatus(status);

        System.out.println("Студента оновлено.");
    }

    public void deleteStudent(int id) {

        for (int i = 0; i < count; i++) {

            if (students[i].getId() == id) {

                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[--count] = null;

                System.out.println("Студента видалено.");
                return;
            }
        }

        System.out.println("Студента не знайдено.");
    }

    public void changeStatus(int id, StudentStatus status) {

        Student student = findById(id);

        if (student != null) {
            student.setStatus(status);
            System.out.println("Статус змінено.");
        } else {
            System.out.println("Студента не знайдено.");
        }

    }

    public void filterByStatus(StudentStatus status) {

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (students[i].getStatus() == status) {
                System.out.println(students[i]);
                found = true;
            }

        }

        if (!found) {
            System.out.println("Нічого не знайдено.");
        }
    }

    public void filterByStudyYear(int year) {

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (students[i].getStudyYear() == year) {
                System.out.println(students[i]);
                found = true;
            }

        }

        if (!found) {
            System.out.println("Нічого не знайдено.");
        }
    }

    public void sortByName() {

        for (int i = 0; i < count - 1; i++) {

            for (int j = 0; j < count - i - 1; j++) {

                if (students[j].getFullName()
                        .compareToIgnoreCase(students[j + 1].getFullName()) > 0) {

                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;

                }
            }
        }

        System.out.println("Студентів відсортовано.");
    }

    public Student[] getStudents() {
        return students;
    }

    public int getCount() {
        return count;
    }

    public void searchStudents(String query) {

        boolean found = false;

        query = query.toLowerCase();

        for (int i = 0; i < count; i++) {

            if (students[i].getFullName().toLowerCase().contains(query)
                    || students[i].getEmail().toLowerCase().contains(query)) {

                System.out.println(students[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Студентів не знайдено.");
        }
    }

    public Student getStudentByIndex(int index) {

        if (index >= 0 && index < count) {
            return students[index];
        }

        return null;
    }

    public int getStudentCount() {
        return count;
    }

}
