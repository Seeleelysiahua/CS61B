package randomizedtest;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    //[4, 5, 6]
    @Test
    public void testBuggyAList1() {
        AListNoResizing<Integer> aList = new AListNoResizing<Integer>();
        BuggyAList<Integer> bList = new BuggyAList<Integer>();
        for (int i = 4; i < 7; i ++){
            aList.addLast(i);
            bList.addLast(i);
        }
        int size = aList.size();
        while (size > 0){
            for (int n = 0; n < aList.size(); n ++){
                assertEquals(aList.size(), bList.size());
                assertEquals(aList.get(n), bList.get(n));
            }
            aList.removeLast();
            bList.removeLast();
            size --;
        }
    }


    //验证test1不是偶然
    @Test
    public void testBuggyAList2() {
        AListNoResizing<Integer> aList = new AListNoResizing<Integer>();
        BuggyAList<Integer> bList = new BuggyAList<Integer>();
        for (int i = 14; i < 17; i ++){
            aList.addLast(i + 2);
            bList.addLast(i + 2);
        }
        int size = aList.size();
        while (size > 0){
            for (int n = 0; n < aList.size(); n ++){
                assertEquals(aList.size(), bList.size());
                assertEquals(aList.get(n), bList.get(n));
            }
            aList.removeLast();
            bList.removeLast();
            size --;
        }
    }

    //验证[21, 2, 7, 19, 9，10]
    @Test
    public void testBuggyAList3() {
        AListNoResizing<Integer> aList = new AListNoResizing<Integer>();
        BuggyAList<Integer> bList = new BuggyAList<Integer>();
        aList.addLast(21);
        aList.addLast(2);
        aList.addLast(7);
        aList.addLast(19);
        aList.addLast(9);
        aList.addLast(10);
        bList.addLast(21);
        bList.addLast(2);
        bList.addLast(7);
        bList.addLast(19);
        bList.addLast(9);
        bList.addLast(10);
        int size = aList.size();
        while (size > 0){
            for (int n = 0; n < aList.size(); n ++){
                assertEquals(aList.size(), bList.size());
                assertEquals(aList.get(n), bList.get(n));
            }
            aList.removeLast();
            bList.removeLast();
            size --;
        }
    }

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }


    //验证getLast功能, [2, 4, 10, 28]
    @Test
    public void testGetLast() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();
        int[] array = new int[]{2, 4, 10, 28};
        for (int i = 0; i < array.length; i++){
            correct.addLast(array[i]);
            broken.addLast(array[i]);
        }
        assertEquals(correct.getLast(), broken.getLast());
    }

    //验证get功能， [23, 312, 902, 123, 89]
    @Test
    public void testGet() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();
        int[] array = new int[]{23, 312, 902, 123, 89};
        for (int i = 0; i < array.length; i++){
            correct.addLast(array[i]);
            broken.addLast(array[i]);
        }
        assertEquals(correct.get(0), broken.get(0));
        assertEquals(correct.get(1), broken.get(1));
        assertEquals(correct.get(2), broken.get(2));
        assertEquals(correct.get(3), broken.get(3));
        assertEquals(correct.get(4), broken.get(4));
    }

    //验证不同类型, double
    @Test
    public void testDoubleMove() {
        AListNoResizing<Double> correct = new AListNoResizing<>();
        BuggyAList<Double> broken = new BuggyAList<>();

        correct.addLast(5.1);
        correct.addLast(10.1);
        correct.addLast(15.1);

        broken.addLast(5.1);
        broken.addLast(10.1);
        broken.addLast(15.1);

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void testDoubleGetLast() {
        AListNoResizing<Double> correct = new AListNoResizing<>();
        BuggyAList<Double> broken = new BuggyAList<>();

        correct.addLast(5.1);
        correct.addLast(10.1);
        correct.addLast(15.1);

        broken.addLast(5.1);
        broken.addLast(10.1);
        broken.addLast(15.1);

        assertEquals(correct.getLast(), broken.getLast());
    }

    @Test
    //验证不同类型,String
    public void testStringMove() {
        AListNoResizing<String> correct = new AListNoResizing<>();
        BuggyAList<String> broken = new BuggyAList<>();

        correct.addLast("Seele");
        correct.addLast("HUA");
        correct.addLast("Elysia");

        broken.addLast("Seele");
        broken.addLast("HUA");
        broken.addLast("Elysia");

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void testStringGetLast() {
        AListNoResizing<String> correct = new AListNoResizing<>();
        BuggyAList<String> broken = new BuggyAList<>();

        correct.addLast("Seele");
        correct.addLast("HUA");
        correct.addLast("Elysia");

        broken.addLast("Seele");
        broken.addLast("HUA");
        broken.addLast("Elysia");

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    //初步排除类型导致的bug
    //对大型list进行测试

    @Test
    public void testBigList() {
        AListNoResizing<Integer> aList = new AListNoResizing<Integer>();
        BuggyAList<Integer> bList = new BuggyAList<Integer>();
        for (int i = 0; i < 1000; i ++){
            aList.addLast(i);
            bList.addLast(i);
        }
        int size = aList.size();
        while (size > 0){
            for (int n = 0; n < aList.size(); n ++){
                assertEquals(aList.size(), bList.size());
                assertEquals(aList.get(n), bList.get(n));
            }
            aList.removeLast();
            bList.removeLast();
            size --;
        }
    }

    @Test
    public void testBigList2() {
        AListNoResizing<Integer> aList = new AListNoResizing<Integer>();
        BuggyAList<Integer> bList = new BuggyAList<Integer>();
        for (int i = 0; i < 100; i ++){
            aList.addLast(i);
            bList.addLast(i);
        }
        int size = aList.size();
        while (size > 0){
            for (int n = 0; n < aList.size(); n ++){
                assertEquals(aList.size(), bList.size());
                assertEquals(aList.get(n), bList.get(n));
            }
            aList.removeLast();
            bList.removeLast();
            size --;
        }
    }

    @Test
    public void testBigList3() {
        AListNoResizing<Integer> aList = new AListNoResizing<Integer>();
        BuggyAList<Integer> bList = new BuggyAList<Integer>();
        for (int i = 0; i < 10; i ++){
            aList.addLast(i);
            bList.addLast(i);
        }
        int size = aList.size();
        while (size > 0){
            for (int n = 0; n < aList.size(); n ++){
                assertEquals(aList.size(), bList.size());
                assertEquals(aList.get(n), bList.get(n));
            }
            aList.removeLast();
            bList.removeLast();
            size --;
        }
    }

    @Test
    public void testBigList4() {
        AListNoResizing<Integer> aList = new AListNoResizing<Integer>();
        BuggyAList<Integer> bList = new BuggyAList<Integer>();
        for (int i = 0; i < 50; i ++){
            aList.addLast(i);
            bList.addLast(i);
        }
        int size = aList.size();
        while (size > 0){
            for (int n = 0; n < aList.size(); n ++){
                assertEquals(aList.size(), bList.size());
                assertEquals(aList.get(n), bList.get(n));
            }
            aList.removeLast();
            bList.removeLast();
            size --;
        }
    }

    @Test
    public void testBigList5() {
        AListNoResizing<Integer> aList = new AListNoResizing<Integer>();
        BuggyAList<Integer> bList = new BuggyAList<Integer>();
        for (int i = 0; i < 20; i ++){
            aList.addLast(i);
            bList.addLast(i);
        }
        int size = aList.size();
        while (size > 0){
            for (int n = 0; n < aList.size(); n ++){
                assertEquals(aList.size(), bList.size());
                assertEquals(aList.get(n), bList.get(n));
            }
            aList.removeLast();
            bList.removeLast();
            size --;
        }
    }

    @Test
    public void testBigList6() {
        AListNoResizing<Integer> aList = new AListNoResizing<Integer>();
        BuggyAList<Integer> bList = new BuggyAList<Integer>();
        for (int i = 0; i < 10; i ++){
            aList.addLast(i);
            bList.addLast(i);
        }
        int size = aList.size();
        while (size > 0){
            for (int n = 0; n < aList.size(); n ++){
                assertEquals(aList.size(), bList.size());
                assertEquals(aList.get(n), bList.get(n));
            }
            aList.removeLast();
            bList.removeLast();
            size --;
        }
    }

    @Test
    public void testBigList7() {
        AListNoResizing<Integer> aList = new AListNoResizing<Integer>();
        BuggyAList<Integer> bList = new BuggyAList<Integer>();
        for (int i = 0; i < 20; i ++){
            aList.addLast(i);
            bList.addLast(i);
        }
        int size = aList.size();
        while (size > 0){
            aList.removeLast();
            bList.removeLast();
            size --;
        }
    }
}
