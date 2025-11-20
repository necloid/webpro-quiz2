import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.taskman.config.DBUtil;

public class DBTest {
    public static void main(String[] args) {
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1")) {

            if (rs.next()) {
                System.out.println("DB connection OK! Result = " + rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
