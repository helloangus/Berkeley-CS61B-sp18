import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN = new OffByN(5);
    private static int MAX_TEST_CASE = 16;

    // Your tests go here.
    @Test
    public void testEqualChars() {
        char[] testCasesA = new char[MAX_TEST_CASE];
        char[] testCasesB = new char[MAX_TEST_CASE];
        boolean[] testActual = new boolean[MAX_TEST_CASE];

        testCasesA[0] = 'a';    testCasesB[0] = 'b';   testActual[0] = false;
        testCasesA[1] = 'a';    testCasesB[1] = 'f';   testActual[1] = true;
        testCasesA[2] = 'u';    testCasesB[2] = 'z';   testActual[2] = true;
        testCasesA[3] = 'z';    testCasesB[3] = 'u';   testActual[3] = true;
        testCasesA[4] = 'a';    testCasesB[4] = 'B';   testActual[4] = false;
        testCasesA[5] = 'a';    testCasesB[5] = 'c';   testActual[5] = false;
        testCasesA[6] = 'a';    testCasesB[6] = 'a';   testActual[6] = false;
        testCasesA[7] = '&';    testCasesB[7] = '%';   testActual[7] = false;

        for (int i = 0; i < 8; ++i) {
            if (testActual[i]) {
                assertTrue(offByN.equalChars(testCasesA[i], testCasesB[i]));
            } else {
                assertFalse(offByN.equalChars(testCasesA[i], testCasesB[i]));
            }
        }

        System.out.println("Pass equalChars test.");
    }
}
