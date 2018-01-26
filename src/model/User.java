package model;

/**
 * Created by dik81 on 23.01.18.
 */
public class User {
    private String name;
    private int age;
    private Integer id;

    public User(String name, Integer age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
