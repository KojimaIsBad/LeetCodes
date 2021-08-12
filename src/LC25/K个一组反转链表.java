package LC25;

import java.util.*;

public class K个一组反转链表 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode res = new Solution().reverseKGroup01(a,3);
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
    public ListNode reverseKGroup00(ListNode head, int k) {
        Queue<ListNode>[] queues = new Queue[k];
        for(int i=0;i<k;i++)
            queues[i] = new LinkedList<>();
        int count = 0;
        ListNode[] listNodes= new ListNode[k];
        //节点全部入队
        while (head!=null){
            listNodes[count%k] = head;
            head = head.next;
            count++;
            if(count!=0&&count%k==0){
                for(var i=0;i<k;i++)
                    queues[i%k].offer(listNodes[i]);
                listNodes= new ListNode[k];
            }
        }
        ListNode res = new ListNode(-1);
        ListNode p = res;
        boolean isFinished = false;
        while (!isFinished){
            int flag = 0;
            for(int i=0;i<k;i++){
                if(!queues[k-1-i].isEmpty()){
                    p.next = queues[k-1-i].poll();
                    p = p.next;
                    flag++;
                }
            }
            if(flag==0)
                isFinished = true;
        }
        if(count%k!=0){
            for(var i=0;i<count%k;i++){
                p.next = listNodes[i];
                p = p.next;
            }
        }
        p.next = null;
        return res.next;
    }

    public ListNode reverseKGroup01(ListNode head, int k) {
        int count = 0;
        ListNode[] listNodes= new ListNode[k];
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (head!=null){
            listNodes[count%k] = head;
            head = head.next;
            count++;
            if(count!=0&&count%k==0){
                for(int i=0;i<k;i++){
                    p.next = listNodes[k-1-i];
                    p=p.next;
                }
                listNodes= new ListNode[k];
            }
        }
        if(count%k!=0){
            for(var i=0;i<count%k;i++){
                p.next = listNodes[i];
                p=p.next;
            }
        }
        p.next = null;
        return dummy.next;
    }

    /**
     * 递归方法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroupRe(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode[] nodes = new ListNode[k];
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            if (p != null) {
                nodes[i] = p;
                p = p.next;
            } else return head;
        }
        nodes[0].next = reverseKGroupRe(nodes[k - 1].next, k);
        for (int i = k - 1; i > 0; i--) {
            nodes[i].next = nodes[i - 1];
        }
        return nodes[k - 1];
    }

    /**
     * 迭代法
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroupIt(ListNode head, int k) {
        ListNode[] nodes = new ListNode[k];
        ListNode dummy = new ListNode(0, head), p = dummy;
        while (p.next != null) {
            ListNode q = p.next;
            for (int i = 0; i < k; i++) {
                if (q != null) {
                    nodes[i] = q;
                    q = q.next;
                } else
                    return dummy.next;
            }

            nodes[0].next = nodes[k - 1].next;
            p.next = nodes[k - 1];
            for (int i = k - 1; i > 0; i--) {
                nodes[i].next = nodes[i - 1];
            }
            p = nodes[0];
        }

        return dummy.next;
    }

//    public ListNode reverseKGroup02(ListNode head, int k) {
//        int cp = 0;
//        ListNode dummy = new ListNode(-1);
//        ListNode tail = dummy;
//        while (head!=null){
//            ListNode temp = head.next;
//            ListNode right = head;
//            head.next = null;
//
//        }
//    }
}