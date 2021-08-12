package LC206;

public class 反转链表 {
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
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode temp = head, p=head, newHead = null;
        while (p!=null){
            temp = p.next;
            p.next = newHead;
            newHead = p;
            p = temp;
        }
        return newHead;
    }

    /**
     * 递归反转
     * @param head
     * @return
     */
    public ListNode reverseListIt(ListNode head){
        if(head==null||head.next==null)
            return head;
        //把其后的节点反转，指向该节点
        ListNode newHead = reverseListIt(head.next);
        //为什么这里不是head.next?
        /*
            假设n1->n2->...->nk->nk+1<-nk+2<-...<-nm已经反转完毕
            此时要让nk+1指向nk
            等价于让[nk.next](即nk+1).next指向nk
         */
        //
        newHead.next.next = head;
        head.next = null;
        return newHead;
    }
}