package university.entities;

import university.enums.StudentStatus;

public class Student extends Person {

    private int studyYear;
    private StudentStatus status;

    public Student(int id,
                   String fullName,
                   String email,
                   int studyYear,
                   StudentStatus status) {

        super(id, fullName, email);
        setStudyYear(studyYear);
        this.status = status;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {

        if (studyYear < 1) {
            throw new IllegalArgumentException("Рік навчання повинен бути більше 0.");
        }

        this.studyYear = studyYear;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n========== STUDENT ==========" +
                "\nID: " + getId() +
                "\nПІБ: " + getFullName() +
                "\nEmail: " + getEmail() +
                "\nРік навчання: " + studyYear +
                "\nСтатус: " + status +
                "\n=============================";
    }

}
