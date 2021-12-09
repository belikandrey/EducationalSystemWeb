package by.itoverone.entity;

import java.util.Objects;

public class Teacher {
    private int id;
    private String name;
    private String subjectName;
    private int age;

    public Teacher(int id, String name, String subjectName, int age) {
        this.id = id;
        this.name = name;
        this.subjectName = subjectName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && age == teacher.age && Objects.equals(name, teacher.name) && Objects.equals(subjectName, teacher.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subjectName, age);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", age=" + age +
                '}';
    }
}
