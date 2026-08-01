package university.entities;

import university.enums.TeacherPosition;

public class Teacher extends Person {

    private TeacherPosition position;

    public Teacher(int id,
                   String fullName,
                   String email,
                   TeacherPosition position) {

        super(id, fullName, email);
        this.position = position;
    }

    public TeacherPosition getPosition() {
        return position;
    }

    public void setPosition(TeacherPosition position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "\n========== TEACHER ==========" +
                "\nID: " + getId() +
                "\nПІБ: " + getFullName() +
                "\nEmail: " + getEmail() +
                "\nПосада: " + position +
                "\n=============================";
    }
}
