import org.junit.Assert;
import org.junit.Test;

public class TestDecideLaunch {

    @Test
    public void testCalculatePUM() {
        Decide.CMV[0] = true;
        Decide.CMV[1] = true;
        Decide.CMV[2] = false;
        Decide.CMV[3] = true;
        Decide.CMV[4] = true;
        Decide.CMV[5] = false;
        Decide.CMV[6] = false;
        Decide.CMV[7] = true;
        Decide.CMV[8] = false;
        Decide.CMV[9] = true;
        Decide.CMV[10] = true;
        Decide.CMV[11] = false;
        Decide.CMV[12] = false;
        Decide.CMV[13] = false;
        Decide.CMV[14] = false;

        boolean[][] PUM = {{true,true,true,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,false,false,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,false,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true},
                           {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true}};

        boolean[][] result = Decide.calculatePUM();

        Assert.assertArrayEquals(PUM, result);
    }
}
