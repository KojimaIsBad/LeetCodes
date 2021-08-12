package LC24;

import java.awt.color.ICC_ColorSpace;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class 交换链表中的节点 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode res = new Solution().swapPairs(a);
        while (res != null) {
            System.out.println(res);
            res = res.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        return String.valueOf(this.val);
    }
}

class Solution {
    /**
     * 尝试迭代法。失败
     * @param head
     * @return
     */
    public ListNode swapPairs0(ListNode head) {
        int cp = 0;
        if (head == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        boolean first = true;
        while (cur != null && pre != null) {
            if (cp % 2 == 0) {
                //执行交换
                pre.next = cur.next;
                cur.next = pre;
                if(first){
                    head = cur;
                    first = false;
                }
                pre = pre.next;
                cur = pre;


            } else {
                cur = cur.next;
            }
            cp++;
        }
        return head;
    }

    /**
     * LeetCode官方的迭代法
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        //虚拟头节点
        dummyHead.next = head;
        //暂存交换后的第二个节点
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }


    public ListNode swapPairsWithLoop(ListNode head) {
        if(head==null||head.next==null)
            return head;
        //记录右边节点
        ListNode newFirst = head.next;
        //左边节点指向右边交换完毕的部分
        head.next = swapPairsWithLoop(newFirst.next);
        //让右边指向左边，完成交换
        newFirst.next = head;
        return newFirst;
    }

    /**
     * 使用队列辅助
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        Queue<ListNode> odd = new ArrayDeque<>();
        Queue<ListNode> dou = new ArrayDeque<>();
        int cp = 0;
        while (head!=null){
            if(cp%2==0)
                dou.add(head);
            else
                odd.add(head);
            head = head.next;
            cp++;
        }
        ListNode res = new ListNode(-1);
        ListNode p = res;
        while (!odd.isEmpty()&&!dou.isEmpty()){
            p.next = odd.poll();
            p = p.next;
            p.next = dou.poll();
            p = p.next;
        }
        while (!odd.isEmpty()){
            p.next = odd.poll();
            p = p.next;
        }
        while (!dou.isEmpty()){
            p.next = dou.poll();
            p = p.next;
        }
        p.next = null;
        return res.next;
    }
}