package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class randomizedTest {
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                assertEquals(B.size(), size);
                System.out.println("size: " + size);
            }
            else if (operationNumber == 2) {
                if (L.size() == 0) {
                    continue;
                }
                L.getLast();
                B.getLast();
                assertEquals(B.getLast(), L.getLast());
                assertEquals(B.removeLast(), L.removeLast());
            }
        }
    }
}
