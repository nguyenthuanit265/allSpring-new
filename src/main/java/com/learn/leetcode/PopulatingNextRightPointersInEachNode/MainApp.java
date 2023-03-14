package com.learn.leetcode.PopulatingNextRightPointersInEachNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 116. Populating Next Right Pointers in Each Node
 */
public class MainApp {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        Node curNode = root;
        traversal(curNode, 0, map);
        map.forEach((key, nodes) -> {
            if (nodes.size() < 2) {
                nodes.get(0).next = null;
            } else {
                for (int i = 0; i < nodes.size(); i++) {
                    if (i == nodes.size() - 1) {
                        nodes.get(i).next = null;
                    } else {
                        nodes.get(i).next = nodes.get(i + 1);
                    }
                }
            }

        });

        return root;
    }

    public void traversal(Node head, int level, Map<Integer, List<Node>> map) {
        Node curNode = head;
        if (curNode != null && curNode.left == null && curNode.right == null) {
            if (map.containsKey(level)) {
                map.get(level).add(curNode);
            } else {
                map.put(level, new ArrayList<>(List.of(curNode)));
            }
        }

        if (curNode.left != null || curNode.right != null) {
            if (map.containsKey(level)) {
                map.get(level).add(curNode);
            } else {
                map.put(level, new ArrayList<>(List.of(curNode)));
            }
        }

        if (curNode.left != null) {
            traversal(curNode.left, level + 1, map);
        }
        if (curNode.right != null) {
            traversal(curNode.right, level + 1, map);
        }
    }

    public static void main(String[] args) {
    }
}
