import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testFlik {
    
    /**
     * Test the correctness of the lib Flik.
     */
    @Test
    public void testLibFlik()
    {
        int a = 1;
        int b = 2;
        int c = 2;
        
        assertTrue(Flik.isSameNumber(c, b));
        assertFalse(Flik.isSameNumber(a, b));


        int e = 128;
        int f = 128;
        int g = 127;
        
        assertTrue(Flik.isSameNumber(e, f));
        assertFalse(Flik.isSameNumber(f, g));
    }
}
