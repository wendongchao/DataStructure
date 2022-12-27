package structuretest.list;

import com.wdc.list.DoublyLinkedList2;
import com.wdc.list.DoublyNode2;
import junit.framework.TestCase;

/**
 * @author dongchao
 * @time 2022-05-22 19:28
 */
public class DoublyListTest extends TestCase {

    public DoublyLinkedList2<Integer> getDoublyParam() {
        DoublyLinkedList2<Integer> linkedList2 = new DoublyLinkedList2<Integer>();

        DoublyNode2<Integer> none = new DoublyNode2<Integer>(null);
        DoublyNode2<Integer> node1 = new DoublyNode2<Integer>(1);
        DoublyNode2<Integer> node2 = new DoublyNode2<Integer>(2);
        DoublyNode2<Integer> node3 = new DoublyNode2<Integer>(3);
        DoublyNode2<Integer> node4 = new DoublyNode2<Integer>(4);
        DoublyNode2<Integer> node5 = new DoublyNode2<Integer>(5);
        DoublyNode2<Integer> node6 = new DoublyNode2<Integer>(6);
        DoublyNode2<Integer> node7 = new DoublyNode2<Integer>(7);
        DoublyNode2<Integer> node8 = new DoublyNode2<Integer>(8);
        DoublyNode2<Integer> node9 = new DoublyNode2<Integer>(9);
        DoublyNode2<Integer> node10 = new DoublyNode2<Integer>(10);
        DoublyNode2<Integer> node11 = new DoublyNode2<Integer>(11);
        DoublyNode2<Integer> node12 = new DoublyNode2<Integer>(12);

        node3.setChild(node7);
        node8.setChild(node11);

        linkedList2.add(none);
        linkedList2.add(node1);
        linkedList2.add(node2);
        linkedList2.add(node3);
        linkedList2.add(node4);
        linkedList2.add(node5);
        linkedList2.add(node6);
        linkedList2.add(none);
        linkedList2.add(node7);
        linkedList2.add(node8);
        linkedList2.add(node9);
        linkedList2.add(node10);
        linkedList2.add(none);
        linkedList2.add(node11);
        linkedList2.add(node12);
        return linkedList2;
    }

    public void test01() {
        DoublyLinkedList2<Integer> linkedList2 = getDoublyParam();

        linkedList2.print();

//        DoublyNode2<Integer> head = linkedList2.getHead();
//        linkedList2.flatten(head);

    }
}
