import com.umcsuser.current.db.TrainDB;
import com.umcsuser.current.db.TransferDB;
import com.umcsuser.current.models.Train;
import com.umcsuser.current.models.Transfer;
import org.junit.*;

import java.util.ArrayList;

public class TrainDB_test {
    @Test
    public void testReadDB(){
        TrainDB db = new TrainDB();
        db.readDatabase("trains.csv");
        ArrayList<Train> trains = db.getTrains();

        Assert.assertEquals("3", trains.get(2).getID());
    }
}
