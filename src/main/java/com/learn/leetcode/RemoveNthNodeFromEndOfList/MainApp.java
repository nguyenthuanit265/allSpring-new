package com.learn.leetcode.RemoveNthNodeFromEndOfList;

/**
 * 19. Remove Nth Node From End of List
 */
public class MainApp {
    public class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }

        // Count node
        int lengthOfHead = getLengthOfHead(head);

        // if n == length of head -> remove first node
        if (n == lengthOfHead) {
            return head.next;
        }

        // get Nth from first
        int nFromFirst = lengthOfHead - n;

        // Iterator node before node be deleted
        ListNode iter = head;
        int run = 0;
        while (run < nFromFirst - 1) {
            iter = iter.next;
            run++;
        }

        iter.next = iter.next.next;

        return head;
    }

    private static int getLengthOfHead(ListNode head) {
        ListNode iter = head;
        int lengthOfHead = 0;
        while (iter != null) {
            iter = iter.next;
            lengthOfHead++;
        }
        return lengthOfHead;
    }

    public static void main(String[] args) {

    }
}
