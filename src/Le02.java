public class Le02 {
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
    //初始解法：需要将res逆序得到结果
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;

        ListNode res = null;
        int up = 0;

        while (list1 !=null && list2 !=null){
            int ans = list1.val + list2.val+up;
            int val = ans % 10;
            up = ans / 10;
            ListNode curNode = new ListNode(val);
            curNode.next = res;
            res = curNode;
            list1 = list1.next;
            list2 = list2.next;
        }

        while (list1!=null){
            int ans = list1.val + up;
            int val = ans % 10;
            list1.val = val;
            up = ans / 10;
            ListNode p = list1.next;
            list1.next = res;
            res = list1;
            list1 = p;
        }

        while (list2!=null){
            int ans = list2.val + up;
            int val = ans % 10;
            list2.val = val;
            up = ans / 10;
            ListNode p = list2.next;
            list2.next = res;
            res = list2;
            list2 = p;
        }

        //处理剩余的进位
        if(up!=0){
            ListNode etc = new ListNode(up);
            etc.next = res;
            res = etc;
        }

        //逆序化
        ListNode reverseList = null;
        while (res!=null){
            ListNode p = res.next;
            res.next = reverseList;
            reverseList = res;
            res = p;
        }

        return reverseList;

    }

    // v2 直接得到逆序的和
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        //反转l1
        ListNode list1 = l1;
        ListNode list2 = l2;

        ListNode res = null;
        ListNode head = null;
        int up = 0;

        while (list1 !=null && list2 !=null){
            int ans = list1.val + list2.val+up;
            int val = ans % 10;
            up = ans / 10;
            ListNode curNode = new ListNode(val);
            if(head == null)
                head = res = curNode;
            else {
                res.next = curNode;
                res = res.next;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        while (list1!=null){
            int ans = list1.val + up;
            int val = ans % 10;
            up = ans / 10;
            ListNode curNode = new ListNode(val);
            res.next = curNode;
            res = res.next;
            list1 = list1.next;
        }

        while (list2!=null){
            int ans = list2.val + up;
            int val = ans % 10;
            up = ans / 10;
            ListNode curNode = new ListNode(val);
            res.next = curNode;
            res = res.next;
            list2 = list2.next;
        }
        //处理剩余的进位
        if(up!=0){
            ListNode etc = new ListNode(up);
            res.next = etc;
        }

        return head;
    }

    //v3 将两个链表对齐，缺少的节点视为0，使得代码简洁
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int up = 0; //进位
        while (l1!=null||l2!=null){
            int x = (l1!=null)? l1.val : 0;
            int y = (l2!=null)? l2.val : 0;
            int val = (x + y + up) % 10;
            if (head==null){
                head = tail = new ListNode(val);
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
            up = val / 10;
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }
        if(up>0){
            tail.next = new ListNode(up);
        }
        return head;
    }
}

