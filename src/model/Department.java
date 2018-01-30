package model;

import holder.DepartmentsHolder;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dik81 on 23.01.18.
 */
public class Department {
    private Integer id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Map<Integer, User> userMap = new HashMap<>();

    public void addUser(User user) {
        user.setId(DepartmentsHolder.createId(userMap.keySet()));
        userMap.put(user.getId(), user);
    }

    public Collection<User> getUsers() { return userMap.values();   }
    public void removeUser(Integer id) { userMap.remove(id);   }

    public User getUserById(Integer id) { return userMap.get(id);  }

}
