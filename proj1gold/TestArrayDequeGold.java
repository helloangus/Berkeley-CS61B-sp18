import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    
    private int iteration = 100;
    private int numOfData = 10;

    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

        String log = "";
        for (int j = 0; j < iteration; ++j) {
            // A single test
            // Add data
            for (int i = 0; i < numOfData; ++i) {
                int options = StdRandom.uniform(2);
                Integer addNumber = StdRandom.uniform(1000);
                switch (options) {
                    case 0:
                        log = log + "addFirst(" + addNumber + ")\n";
                        sad.addFirst(addNumber);
                        ads.addFirst(addNumber);
                        break;
                    case 1:
                    log = log + "addLast(" + addNumber + ")\n";
                        sad.addLast(addNumber);
                        ads.addLast(addNumber);
                        break;
                    default:

                }
            }

            // Remove data
            for (int i = 0; i < numOfData; ++i) {
                int options = StdRandom.uniform(2);
                Integer sadData = 0;
                Integer adsData = 0;
                switch (options) {
                    case 0:
                        log = log + "removeFirst()\n";
                        sadData = sad.removeFirst();
                        adsData = ads.removeFirst();
                        break;
                    case 1:
                        log = log + "removeLast()\n";
                        sadData = sad.removeLast();
                        adsData = ads.removeLast();
                        break;
                    default:

                }
                assertEquals(log, sadData, adsData);
            }    
        }   
    }
}
