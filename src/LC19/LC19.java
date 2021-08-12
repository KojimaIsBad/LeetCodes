package LC19;

import java.util.List;

public class LC19 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//        ListNode e = new ListNode(5);
        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
        ListNode head = new Solution().removeNthFromEnd1(a, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

//Definition for singly-linked list.
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
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        if (n == len)
            return head.next;
        ListNode q = head;
        for (var i = 0; i < len - n - 1; i++) {
            q = q.next;
        }
        if (q.next != null)
            q.next = q.next.next;
        else
            q.next = null;
        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode p = head, q = head;
        for (int i = 0; i < n+1; i++) {
            if(q!=null)
                q = q.next;
            else
                return p.next;
        }
        while (q!=null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }
}