package com.learn.leetcode.RotateList;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 61. Rotate List
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

    public ListNode rotateRight(ListNode head, int k) {
        System.out.println("k: " + k);
        if (head == null) {
            return null;
        }
        Deque<Integer> queue = new LinkedList<>();
        ListNode curNode = head;
        while (curNode != null) {
            queue.addLast(curNode.val);
            curNode = curNode.next;
        }
        System.out.println(queue.getLast());
        System.out.println(queue.getFirst());

        if (k > 0) {
            int locationHead = k % queue.size();
            int newK = queue.size() - locationHead;
            for (int i = 1; i <= k; i++) {
                int temp = queue.getFirst();
                queue.removeFirst();
                System.out.println("temp: " + temp);
                queue.addLast(temp);
            }
        }
        System.out.println(queue.toString());

        ListNode headRes = new ListNode();
        ListNode varRun = headRes;
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            varRun.val = iterator.next();
            if (iterator.hasNext()) {
                varRun.next = new ListNode();
                varRun = varRun.next;
            } else {
                varRun.next = null;
            }
        }
        return headRes;

    }

    public static void main(String[] args) {

    }
}
