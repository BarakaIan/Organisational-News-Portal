package dao;

import models.Department;

import java.util.List;

public interface DepartmentDao {
    //create
    void add(Department department);
    //void addUserToDepartment(User user, Department department);

    //read
    List<Department> getAll();

    // find by ID
    Department findById(int id);

    //update
    void update(int id, String name, String bio);

    //delete
    void deleteById(int id);
    void clearAll();
}
