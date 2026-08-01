package university.services;

import university.entities.Course;
import university.entities.Teacher;

public class CourseService {

    private final Course[] courses = new Course[100];
    private int count = 0;

    public void addCourse(Course course) {

        if (count >= courses.length) {
            throw new IllegalArgumentException("Масив курсів заповнений.");
        }

        courses[count++] = course;
    }

    public void showAllCourses() {

        if (count == 0) {
            System.out.println("Список курсів порожній.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(courses[i]);
        }
    }

    public Course findById(int id) {

        for (int i = 0; i < count; i++) {

            if (courses[i].getId() == id) {
                return courses[i];
            }

        }

        return null;
    }

    public void updateCourse(int id, String title, int credits, Teacher teacher) {

        Course course = findById(id);

        if (course == null) {
            System.out.println("Курс не знайдено.");
            return;
        }

        course.setTitle(title);
        course.setCredits(credits);
        course.setTeacher(teacher);

        System.out.println("Курс оновлено.");
    }

    public void deleteCourse(int id) {

        for (int i = 0; i < count; i++) {

            if (courses[i].getId() == id) {

                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }

                courses[--count] = null;

                System.out.println("Курс видалено.");
                return;
            }

        }

        System.out.println("Курс не знайдено.");
    }

    public void filterByTeacher(int teacherId) {

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (courses[i].getTeacher() != null &&
                    courses[i].getTeacher().getId() == teacherId) {

                System.out.println(courses[i]);
                found = true;

            }

        }

        if (!found) {
            System.out.println("Курси не знайдені.");
        }
    }

    public void filterByCredits(int credits) {

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (courses[i].getCredits() == credits) {

                System.out.println(courses[i]);
                found = true;

            }

        }

        if (!found) {
            System.out.println("Курси не знайдені.");
        }
    }

    public Course[] getCourses() {
        return courses;
    }

    public int getCount() {
        return count;
    }

}
