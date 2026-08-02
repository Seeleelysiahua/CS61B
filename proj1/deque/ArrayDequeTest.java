package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import org.junit.Assert;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ArrayDequeTest {
    public void addIsEmptySizeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);

        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();

        assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {
        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        ArrayDeque<Double> lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }


    @Test
    //测试isempty()
    public void isemptyTest() {
        ArrayDeque deque = new ArrayDeque();
        assertTrue(deque.isEmpty());
    }

    @Test
    //测试addFirst()

    public void addFirstTest() {
        ArrayDeque<Integer> deque = new ArrayDeque();
        deque.addFirst(1);
        deque.addFirst(2);
        assertFalse(deque.isEmpty());
        assertEquals(2, deque.size());
        assertEquals(2, (long) deque.get(0));
    }

    @Test
    public void addLastTest() {
        ArrayDeque<Integer> deque = new ArrayDeque();
        deque.addLast(1);
        deque.addLast(2);
        assertFalse(deque.isEmpty());
        assertEquals(2, deque.size());
        assertEquals(1, (long) deque.get(0));
    }

    @Test
    //测试get（）[4, 1, 2, 3]
    public void getTest0() {
        ArrayDeque<Integer> deque = new ArrayDeque();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(4);

        assertEquals(4, deque.size());
        assertEquals(3, (long) deque.get(3));
        assertEquals(2, (long) deque.get(2));
    }

    @Test
    public void getTest1() {
        ArrayDeque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < 100; i++) {
            deque.addLast(i);
        }
        assertEquals(100, deque.size());
        assertEquals(99, (long) deque.get(99));
    }

    @Test
    public void getRecursiveTest0() {
        ArrayDeque<Integer> deque = new ArrayDeque();

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(4);

        assertEquals(4, deque.size());
    }

    @Test
    public void getRecursiveTest1() {
        ArrayDeque<Integer> deque = new ArrayDeque();

        for (int i = 0; i < 100; i++) {
            deque.addLast(i);
        }

        assertEquals(100, deque.size());
    }

    @Test
    //测试边界情况
    public void removeFirstTest0() {
        ArrayDeque<Integer> deque = new ArrayDeque();

        deque.addLast(1);
        deque.removeFirst();

        assertEquals(null, deque.removeFirst());

    }

    @Test
    public void removeFirstTest() {
        ArrayDeque<Integer> deque = new ArrayDeque();
        deque.addLast(5);
        deque.addLast(2);
        deque.addLast(3);

        assertEquals(5, (long) deque.removeFirst());
        assertEquals(2, deque.size());
    }

    @Test
    public void removeFirstTest2() {
        ArrayDeque<Integer> deque = new ArrayDeque();

        for (int i = 0; i < 100; i++) {
            deque.addLast(i);
        }

        assertEquals(100, deque.size());
        assertEquals(0, (long) deque.removeFirst());
        assertEquals(99, deque.size());
    }

    @Test
    //测试边界情况
    public void removeLastTest0() {
        ArrayDeque<Integer> deque = new ArrayDeque();

        deque.addLast(1);
        deque.removeLast();

        assertEquals(null, deque.removeLast());

    }

    @Test
    public void removeLastTest1() {
        ArrayDeque<Integer> deque = new ArrayDeque();

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        assertEquals(3, (long) deque.removeLast());
        assertEquals(2, deque.size());
        assertEquals(2, (long) deque.removeLast());
        assertEquals(1, deque.size());

    }

    @Test
    public void removeLastTest2() {
        ArrayDeque<Integer> deque = new ArrayDeque();

        for (int i = 0; i < 100; i++) {
            deque.addLast(i);
        }

        assertEquals(99, (long) deque.removeLast());
        assertEquals(99, deque.size());
        assertEquals(98, (long) deque.removeLast());
        assertEquals(98, deque.size());

    }

    @Test
    public void printDequeTest() {
        ArrayDeque<String> deque = new ArrayDeque();

        deque.addLast("seele");
        deque.addLast("HUA");
        deque.addLast("elysia");

        deque.printDeque();
    }

    @Test
    public void printDequeTest2() {
        ArrayDeque<String> deque = new ArrayDeque();

        deque.addLast("seele");
        deque.addLast("elysia");

        deque.printDeque();
    }

    @Test
    public void equalTest() {
        ArrayDeque<String> deque1 = new ArrayDeque();
        deque1.addLast("seele");
        deque1.addLast("elysia");

        ArrayDeque<String> deque2 = new ArrayDeque();
        deque2.addLast("seele");
        deque2.addLast("elysia");

        assertTrue(deque1.equals(deque2));
        deque1.removeFirst();
        assertFalse(deque1.equals(deque2));
    }

    @Test
    public void equalTest2() {
        ArrayDeque<Integer> deque1 = new ArrayDeque();
        deque1.addLast(1);
        deque1.addLast(2);

        ArrayDeque<Integer> deque2 = new ArrayDeque();
        deque2.addLast(1);
        deque2.addLast(2);

        assertTrue(deque1.equals(deque2));
        deque1.removeFirst();
        assertFalse(deque1.equals(deque2));

    }

    @Test
    //随机测试
    public void randomizedTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            }
            else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            }
            else if (operationNumber == 2) {
                if (L.size() == 0) {
                    continue;
                }
                int rmVal = L.removeFirst();
                System.out.println("removeFirst(" + rmVal + ")");
            }
        }
    }

    @Test
    public void IteratorTest0() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);

        Iterator<Integer> iterator = deque.iterator();
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() == 1);
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() == 2);
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() == 3);
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() == 4);
        assertFalse(iterator.hasNext());

    }

    @Test
    public void IteratorTest1() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);

        Iterator<Integer> iterator = deque.iterator();
        for(Integer i : deque){
            assertTrue(iterator.next() == i);
        }
    }
}
