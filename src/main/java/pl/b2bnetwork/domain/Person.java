package pl.b2bnetwork.domain;

import java.util.Objects;

public class Person {

    private String login;
    private long id;

    public Person() {
    }

    public Person(String login, long id) {
        this.login = login;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(login, person.login);
    }

    @Override
    public int hashCode() {

        return Objects.hash(login, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", id=" + id +
                '}';
    }
}
