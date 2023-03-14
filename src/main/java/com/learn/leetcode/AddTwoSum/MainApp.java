package com.learn.leetcode.AddTwoSum;

/**
 * 2. Add Two Numbers
 */
public class MainApp {
    public static class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headResponse = new ListNode(0);
        ListNode curr = headResponse;
        int carry = 0;
        while (l1 != null || l2 != null) {

            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (carry > 0) {
                sum += carry;
                carry = 0;
            }

            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = curr.next;

            if (sum > 9) {
                carry = 1;
            }

        }
        if (carry > 0) {
            ListNode node = new ListNode(carry % 10);
            curr.next = node;
            curr = curr.next;
        }

        return headResponse;
    }

    public static void main(String[] args) {

    }
}
