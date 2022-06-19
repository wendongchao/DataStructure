package structuretest.list;

import com.wdc.structure.list.DoublyLinkedList2;
import com.wdc.structure.list.DoublyNode2;
import junit.framework.TestCase;

/**
 * @author dongchao
 * @time 2022-05-22 19:28
 */
public class DoublyListTest extends TestCase {

    public DoublyLinkedList2<Integer> getDoublyParam() {
        DoublyLinkedList2<Integer> linkedList2 = new DoublyLinkedList2<>();

        DoublyNode2<Integer> none = new DoublyNode2<>(null);
        DoublyNode2<Integer> node1 = new DoublyNode2<>(1);
        DoublyNode2<Integer> node2 = new DoublyNode2<>(2);
        DoublyNode2<Integer> node3 = new DoublyNode2<>(3);
        DoublyNode2<Integer> node4 = new DoublyNode2<>(4);
        DoublyNode2<Integer> node5 = new DoublyNode2<>(5);
        DoublyNode2<Integer> node6 = new DoublyNode2<>(6);
        DoublyNode2<Integer> node7 = new DoublyNode2<>(7);
        DoublyNode2<Integer> node8 = new DoublyNode2<>(8);
        DoublyNode2<Integer> node9 = new DoublyNode2<>(9);
        DoublyNode2<Integer> node10 = new DoublyNode2<>(10);
        DoublyNode2<Integer> node11 = new DoublyNode2<>(11);
        DoublyNode2<Integer> node12 = new DoublyNode2<>(12);

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
