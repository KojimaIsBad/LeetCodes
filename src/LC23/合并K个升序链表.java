package LC23;

import java.util.*;

public class 合并K个升序链表 {
}
/*
O(n)*O(L) = O(n*L)
 */

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
    public ListNode mergeKLists(ListNode[] lists) {
        int num = lists.length;
        int minIndex = 0;
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        boolean isFinished = false;
        while (!isFinished){
            isFinished = true;
            for(var i=0;i<num;i++){
                if(lists[i]!=null){
                    minIndex = lists[i].val<lists[minIndex].val ? i : minIndex;
                    tail.next = lists[minIndex];
                    lists[minIndex] = lists[minIndex].next;
                }
            }
            for(ListNode ln:lists)
                if(ln!=null)
                    isFinished = false;
        }

        return head;
    }

    /**
     * 奥秘法
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        var list = new ArrayList<Integer>();
        for(int i=0;i<lists.length;i++){
            while(lists[i]!=null){
                list.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        Collections.sort(list);
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for(var i=0;i<list.size();i++){
            tail.next = new ListNode(list.get(i));
            tail = tail.next;
        }
        return head.next;
    }

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
     * 顺序合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        ListNode ans =null  ;
        for(int i=0;i<lists.length;i++){
            ans = mergeTwoLists1(ans,lists[i]);
        }
        return ans;
    }

    /**
     * 顺序合并改进：分治法
     */
    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists1(l1, l2);
    }

    /**
     * 最优解 优先队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists5(ListNode[] lists) {
        /*
        优先队列中存储了每个链表中尚未被添加的第一个节点，每次取出val值最小的节点。
        相当于比较所有链表的头节点，取值最小的节点加入结果链表中。
         */
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }






}
