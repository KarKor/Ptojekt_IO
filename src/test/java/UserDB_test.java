import com.umcsuser.current.db.UserDB;
import com.umcsuser.current.users.User;
import org.junit.*;

import java.util.ArrayList;

public class UserDB_test {

    @Test
    public void testReadDB(){
        UserDB db = new UserDB();
        db.readDatabase("users.csv");
        ArrayList<User> users = db.getUsers();

        Assert.assertEquals("marek", users.get(1).getLogin());
    }
}
