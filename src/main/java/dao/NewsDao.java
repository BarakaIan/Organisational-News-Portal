package dao;

import models.News;

import java.util.List;

public interface NewsDao {
    //create
    void add(News news);
    //void addNewsToDepartment(News news, Department department);

    //read
    List<News> getAll();

    // find by ID
    News findById(int id);

    //update
    //void update(int id, String name, String bio);

    //delete
    void deleteById(int id);
    void clearAll();
}
