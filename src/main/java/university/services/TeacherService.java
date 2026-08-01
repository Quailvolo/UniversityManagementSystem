package university.services;

import university.entities.Teacher;
import university.enums.TeacherPosition;

public class TeacherService {

    private final Teacher[] teachers = new Teacher[50];
    private int count = 0;

    public void addTeacher(Teacher teacher) {
        if (count >= teachers.length) {
            throw new IllegalArgumentException("Масив викладачів заповнений.");
        }
        teachers[count++] = teacher;
    }

    public void showAllTeachers() {
        if (count == 0) {
            System.out.println("Список викладачів порожній.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(teachers[i]);
        }
    }

    public Teacher findById(int id) {
        for (int i = 0; i < count; i++) {
            if (teachers[i].getId() == id) {
                return teachers[i];
            }
        }
        return null;
    }

    public void updateTeacher(int id, String fullName, String email, TeacherPosition position) {

        Teacher teacher = findById(id);

        if (teacher == null) {
            System.out.println("Викладача не знайдено.");
            return;
        }

        teacher.setFullName(fullName);
        teacher.setEmail(email);
        teacher.setPosition(position);

        System.out.println("Дані викладача оновлено.");
    }

    public void deleteTeacher(int id) {

        for (int i = 0; i < count; i++) {

            if (teachers[i].getId() == id) {

                for (int j = i; j < count - 1; j++) {
                    teachers[j] = teachers[j + 1];
                }

                teachers[--count] = null;

                System.out.println("Викладача видалено.");
                return;
            }
        }

        System.out.println("Викладача не знайдено.");
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public int getCount() {
        return count;
    }

}
