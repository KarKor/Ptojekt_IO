import com.umcsuser.current.tools.Randomizer;
import org.junit.*;

public class Randomier_test {

    @Test
    public void testRange(){
        Randomizer randomizer = new Randomizer();
        int result=randomizer.randomize(30, 60);

        Assert.assertTrue((result>=30 && result<=60));
    }
}
