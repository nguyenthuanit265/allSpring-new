package com.learn.leetcode.Case2487RemoveNodesFromLinkedList;

import java.util.Arrays;
import java.util.List;

/**
 * 2487. Remove Nodes From Linked List
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

    //1,4,3,2,5,2
    public static ListNode partition(ListNode head, int x) {
        ListNode runningNode = head;
        ListNode prevNodePartition = head;
        ListNode nodePartition = null;
        boolean hasFoundPartition = false;

        while (runningNode != null) {

            if (runningNode.val == x && !hasFoundPartition) {
                nodePartition = runningNode;
                hasFoundPartition = true;
                runningNode = runningNode.next;
                continue;
            }

            if (hasFoundPartition) {
                nodePartition.next = runningNode.next;
                prevNodePartition.next = runningNode;
            }

            if (!hasFoundPartition) {
                prevNodePartition = runningNode;
            }
            runningNode = runningNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
//        list.removeIf(item -> item == 3);
        list.add(7);
        System.out.println(list);

        ListNode node6 = new ListNode(2, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(4, node3);

        ListNode head = new ListNode(1, node2);

        partition(head, 3);
    }
}
