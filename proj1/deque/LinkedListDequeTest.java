package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

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
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);

		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();

		assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
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
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {
        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
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
        LinkedListDeque deque = new LinkedListDeque();
        assertTrue(deque.isEmpty());
    }

    @Test
    //测试addFirst()

    public void addFirstTest() {
        LinkedListDeque<Integer> deque = new LinkedListDeque();
        deque.addFirst(1);
        deque.addFirst(2);
        assertFalse(deque.isEmpty());
        assertEquals(2, deque.size());
        assertEquals(2, (long) deque.get(0));
    }

    @Test
    public void addLastTest() {
        LinkedListDeque<Integer> deque = new LinkedListDeque();
        deque.addLast(1);
        deque.addLast(2);
        assertFalse(deque.isEmpty());
        assertEquals(2, deque.size());
        assertEquals(1, (long) deque.get(0));
    }

    @Test
    //测试get（）[4, 1, 2, 3]
    public void getTest0() {
        LinkedListDeque<Integer> deque = new LinkedListDeque();
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
        LinkedListDeque<Integer> deque = new LinkedListDeque();
        for(int i = 0; i < 100; i++){
            deque.addLast(i);
        }
        assertEquals(100, deque.size());
        assertEquals(99, (long) deque.get(99));
    }

    @Test
    public void getRecursiveTest0() {
        LinkedListDeque<Integer> deque = new LinkedListDeque();

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(4);

        assertEquals(4, deque.size());
        assertEquals(3, (long) deque.getRecursive(3));
        assertEquals(2, (long) deque.getRecursive(2));
    }

    @Test
    public void getRecursiveTest1() {
        LinkedListDeque<Integer> deque = new LinkedListDeque();

        for(int i = 0; i < 100; i++){
            deque.addLast(i);
        }

        assertEquals(100, deque.size());
        assertEquals(99, (long) deque.getRecursive(99));
    }

    @Test
    //测试边界情况
    public void removeFirstTest0() {
        LinkedListDeque<Integer> deque = new LinkedListDeque();

        deque.addLast(1);
        deque.removeFirst();

        assertEquals(null, deque.removeFirst());

    }

    @Test
    public void removeFirstTest() {
        LinkedListDeque<Integer> deque = new LinkedListDeque();
        deque.addLast(5);
        deque.addLast(2);
        deque.addLast(3);

        assertEquals(5, (long)deque.removeFirst());
        assertEquals(2, deque.size());
    }

    @Test
    public void removeFirstTest2() {
        LinkedListDeque<Integer> deque = new LinkedListDeque();

        for(int i = 0; i < 100; i++){
            deque.addLast(i);
        }

        assertEquals(100, deque.size());
        assertEquals(0, (long) deque.removeFirst());
        assertEquals(99, deque.size());
    }

    @Test
    //测试边界情况
    public void removeLastTest0() {
        LinkedListDeque<Integer> deque = new LinkedListDeque();

        deque.addLast(1);
        deque.removeLast();

        assertEquals(null, deque.removeLast());

    }

    @Test
    public void removeLastTest1() {
        LinkedListDeque<Integer> deque = new LinkedListDeque();

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        assertEquals(3, (long)deque.removeLast());
        assertEquals(2, deque.size());
        assertEquals(2, (long) deque.removeLast());
        assertEquals(1, deque.size());

    }

    @Test
    public void removeLastTest2() {
        LinkedListDeque<Integer> deque = new LinkedListDeque();

        for(int i = 0; i < 100; i++){
            deque.addLast(i);
        }

        assertEquals(99, (long)deque.removeLast());
        assertEquals(99, deque.size());
        assertEquals(98, (long) deque.removeLast());
        assertEquals(98, deque.size());

    }

    @Test
    public void printDequeTest() {
        LinkedListDeque<String> deque = new LinkedListDeque();

        deque.addLast("seele");
        deque.addLast("HUA");
        deque.addLast("elysia");

        deque.printDeque();
    }

    @Test
    public void printDequeTest2() {
        LinkedListDeque<String> deque = new LinkedListDeque();

        deque.addLast("seele");
        deque.addLast("elysia");

        deque.printDeque();
    }

    @Test
    public void equalTest() {
        LinkedListDeque<String> deque1 = new LinkedListDeque();
        deque1.addLast("seele");
        deque1.addLast("elysia");

        LinkedListDeque<String> deque2 = new LinkedListDeque();
        deque2.addLast("seele");
        deque2.addLast("elysia");

        assertTrue(deque1.equals(deque2));
        deque1.removeFirst();
        assertFalse(deque1.equals(deque2));
    }

    @Test
    public void equalTest2() {
        LinkedListDeque<Integer> deque1 = new LinkedListDeque();
        deque1.addLast(1);
        deque1.addLast(2);

        LinkedListDeque<Integer> deque2 = new LinkedListDeque();
        deque2.addLast(1);
        deque2.addLast(2);

        assertTrue(deque1.equals(deque2));
        deque1.removeFirst();
        assertFalse(deque1.equals(deque2));

    }
}
