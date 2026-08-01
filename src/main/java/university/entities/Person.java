package university.entities;

import java.util.Objects;

public abstract class Person {

    protected int id;
    protected String fullName;
    protected String email;

    public Person(int id, String fullName, String email) {
        this.id = id;
        setFullName(fullName);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID повинен бути більше 0.");
        }
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("ПІБ не може бути порожнім.");
        }
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (email == null ||
                email.isBlank() ||
                !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

            throw new IllegalArgumentException("Неправильний формат email.");
        }

        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Person person = (Person) obj;

        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nПІБ: " + fullName +
                "\nEmail: " + email;
    }

}
