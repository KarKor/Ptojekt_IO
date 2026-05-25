import com.umcsuser.current.db.TransferDB;
import com.umcsuser.current.models.Transfer;
import org.junit.*;

import java.util.ArrayList;

public class TransferDB_test {

    @Test
    public void testReadDB(){
        TransferDB db = new TransferDB();
        db.readDatabase("transfers.csv");
        ArrayList<Transfer> transfers = db.getTransfers();

        Assert.assertEquals("Warszawa", transfers.get(0).getStartLocation());
    }

    @Test
    public void testReadDB2(){
        TransferDB db = new TransferDB();
        db.readDatabase("transfers.csv");
        ArrayList<Transfer> transfers = db.getTransfers();

        Assert.assertEquals("Poznan", transfers.get(2).getEndLocation());
    }


}
