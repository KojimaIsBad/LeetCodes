package LC21;

public class 合并两个有序链表 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
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
}

class Solution {
    /**
     * 法一 不断取较小的头节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
            return null;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head;
        if(l1.val<l2.val){
            head = l1;
            l1 = l1.next;
        }else {
            head = l2;
            l2 = l2.next;
        }
        ListNode p = head;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next = l1;
                p = l1;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                p = l2;
                l2 = l2.next;
            }
        }
        if(l1!=null)
            p.next = l1;
        if(l2!=null)
            p.next = l2;

        return head;
    }

    /**
     * 法一改进，引入头节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next = l1;
                p = l1;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                p = l2;
                l2 = l2.next;
            }
        }
        if(l1!=null)
            p.next = l1;
        if(l2!=null)
            p.next = l2;

        return head.next;
    }

    /**
     * 法2 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}