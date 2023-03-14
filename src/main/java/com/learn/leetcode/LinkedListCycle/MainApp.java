package com.learn.leetcode.LinkedListCycle;

import java.util.HashMap;
import java.util.Map;

/**
 * 141. Linked List Cycle
 */
public class MainApp {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head.hashCode())) {
                return true;
            }
            map.put(head.hashCode(), head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
