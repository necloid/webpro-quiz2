import com.taskman.dao.*;
import com.taskman.model.*;

public class DAOTest {
    public static void main(String[] args) {
        TaskDAO dao = new TaskDAOImpl();

        System.out.println("All tasks:");
        for (Task t : dao.getAll()) {
            System.out.println(t.getTitle());
        }
    }
}
