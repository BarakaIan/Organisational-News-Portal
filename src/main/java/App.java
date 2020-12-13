import com.google.gson.Gson;
import dao.DB;
import dao.Sql20UserDao;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import exceptions.ApiException;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql20UserDao userDao = new Sql20UserDao(DB.sql2o);
        Sql2oDepartmentDao departmentDao = new Sql2oDepartmentDao(DB.sql2o);
        Sql2oNewsDao newsDao = new Sql2oNewsDao(DB.sql2o);
        Connection conn = DB.sql2o.open();
        Gson gson = new Gson();

        post("/departments/new","application/json",(req,res)->{
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });

        post("/users/new","application/json",(req,res)->{
            User user = gson.fromJson(req.body(), User.class);
            userDao.add(user);
            res.status(201);
            res.type("application/json");
            return gson.toJson(user);
        });

        post("/news/post","application/json",(req,res)->{
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            res.type("application/json");
            return gson.toJson(news);
        });

        get("/users", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(userDao.getAll());//send it back to be displayed
        });

        get("/departments", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(departmentDao.getAll());//send it back to be displayed
        });

        get("/departments/:id", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));

            Department departmentToFind = departmentDao.findById(departmentId);

            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }

            return gson.toJson(departmentToFind);
        });

        //FILTERS
        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(err.getStatusCode()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });

        after((req, res) ->{
            res.type("application/json");
        });
    }
}
