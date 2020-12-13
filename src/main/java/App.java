import com.google.gson.Gson;
import dao.DB;
import dao.Sql20UserDao;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import exceptions.ApiException;
import org.sql2o.Connection;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.after;
import static spark.Spark.exception;

public class App {
    public static void main(String[] args) {
        Sql20UserDao userDao = new Sql20UserDao(DB.sql2o);
        Sql2oDepartmentDao departmentDao = new Sql2oDepartmentDao(DB.sql2o);
        Sql2oNewsDao newsDao = new Sql2oNewsDao(DB.sql2o);
        Connection conn = DB.sql2o.open();
        Gson gson = new Gson();

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
