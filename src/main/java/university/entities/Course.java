package university.entities;

public class Course {

    private int id;
    private String title;
    private int credits;
    private Teacher teacher;

    public Course(int id, String title, int credits, Teacher teacher) {
        this.id = id;
        setTitle(title);
        setCredits(credits);
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Назва курсу не може бути порожньою.");
        }
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (credits < 1) {
            throw new IllegalArgumentException("Кількість кредитів повинна бути більше 0.");
        }
        this.credits = credits;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "\n========== Course ==========\n" +
                "ID: " + id +
                "\nTitle: " + title +
                "\nCredits: " + credits +
                "\nTeacher: " + (teacher != null ? teacher.getFullName() : "Not assigned") +
                "\n============================";
    }
}