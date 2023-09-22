import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class CheckMySQLJDBCDriver {
    public static void main(String[] args) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            System.out.println("Driver class: " + driver.getClass().getName());
        }
    }
}
