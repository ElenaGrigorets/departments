package model;

/**
 * Created by dik81 on 23.01.18.
 */
public class User {
    private String name;
    private int age;
    private Integer id;
    private Integer departmentId;

    public User(String name, Integer age, Integer departmentId) {
        this.name = name;
        this.age = age;
        this.departmentId = departmentId;

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

    public Integer getDepartmentId() {return departmentId; }

    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

}
