import dao.DB;
import dao.Sql20UserDao;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import org.sql2o.Connection;

public class App {
    public static void main(String[] args) {
        Sql20UserDao userDao = new Sql20UserDao(DB.sql2o);
        Sql2oDepartmentDao departmentDao = new Sql2oDepartmentDao(DB.sql2o);
        Sql2oNewsDao newsDao = new Sql2oNewsDao(DB.sql2o);
        Connection conn = DB.sql2o.open();


    }
}
