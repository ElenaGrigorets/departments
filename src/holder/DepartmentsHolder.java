package holder;

import model.Department;

import java.util.*;

/**
 * Created by dik81 on 23.01.18.
 */
public class DepartmentsHolder {
    private static Map <Integer, Department> departmentMap = new HashMap<>();

//    public static Collection<Department> getDepartments () {
//        return departmentMap.values();
//    }

//    public static void addDepartment (Department department) {
//     department.setId(createId(departmentMap.keySet()));
//     departmentMap.put(department.getId(), department);
//    }

    public static Integer createId(Set<Integer> set) {
        int maxKey = 0;
        for (Integer key : set) {
            if (key > maxKey) {
                maxKey = key;
            }
        }
        int id = maxKey + 1;
        return id;
    }

//    public static void removeDepartment(Integer id) {
//        departmentMap.remove(id);
//    }
//
//    public static Department getDepartmentByIdOldMethod (Integer id){
//        return departmentMap.get(id);
//    }
}
