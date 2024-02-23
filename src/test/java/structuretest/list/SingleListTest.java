package structuretest.list;

import com.wdc.list.SingleLinkedList;
import com.wdc.list.single.SingleList;
import junit.framework.TestCase;

/**
 * 链表测试
 * @author dongchao
 * @time 2022-05-15 20:07
 */
public class SingleListTest extends TestCase {

    /**
     * 奇偶链表
     */
    public void test01() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.oddEvenList();
    }

    public void test02() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);
        list.isPalindrome();
    }

    public void test03() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        System.out.println(list.size());
    }

    public void test04() {
        SingleList list = new SingleList();
        System.out.println(list.size());
        list.print();
    }
}
