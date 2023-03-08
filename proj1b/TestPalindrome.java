import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    private static int MAX_TEST_CASE = 16; 

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    // Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        String[] testCases = new String[MAX_TEST_CASE];
        Boolean[] testActual = new Boolean[MAX_TEST_CASE];
        testCases[0] = "A";     testActual[0] = true;
        testCases[1] = "";      testActual[1] = true;
        testCases[2] = "Aa";    testActual[2] = false;
        testCases[3] = "AaA";   testActual[3] = true;
        testCases[4] = "AA";        testActual[4] = true;
        testCases[5] = "racecar";   testActual[5] = true;
        testCases[6] = "noon";  testActual[6] = true;
        testCases[7] = "horse"; testActual[7] = false;
        testCases[8] = "cat";   testActual[8] = false;
        for (int i = 0; i <= 8; ++i) {
            if (testActual[i]) {
                assertTrue(palindrome.isPalindrome(testCases[i]));
            } else {
                assertFalse(palindrome.isPalindrome(testCases[i]));
            }
        }
        System.out.println("Pass equalChars test.");
    }


    @Test
    public void testIsOffByOnePalindrome() {
        CharacterComparator cc = new OffByOne();
        String[] testCases = new String[MAX_TEST_CASE];
        Boolean[] testActual = new Boolean[MAX_TEST_CASE];
        testCases[0] = "flake";  testActual[0] = true;
        testCases[1] = "";      testActual[1] = true;
        testCases[2] = "aba";   testActual[2] = false;
        testCases[3] = "A";     testActual[3] = true;
        for (int i = 0; i <= 3; ++i) {
            if (testActual[i]) {
                assertTrue(palindrome.isPalindrome(testCases[i], cc));
            } else {
                assertFalse(palindrome.isPalindrome(testCases[i], cc));
            }
        }
        System.out.println("Pass equalChars test.");
    }

    @Test
    public void testIsOffByNPalindrome() {
        CharacterComparator cc = new OffByN(5);
        String[] testCases = new String[MAX_TEST_CASE];
        Boolean[] testActual = new Boolean[MAX_TEST_CASE];
        testCases[0] = "fuaza";  testActual[0] = true;
        testCases[1] = "";      testActual[1] = true;
        testCases[2] = "aba";   testActual[2] = false;
        testCases[3] = "A";     testActual[3] = true;
        for (int i = 0; i <= 3; ++i) {
            if (testActual[i]) {
                assertTrue(palindrome.isPalindrome(testCases[i], cc));
            } else {
                assertFalse(palindrome.isPalindrome(testCases[i], cc));
            }
        }
        System.out.println("Pass equalChars test.");
    }
}
