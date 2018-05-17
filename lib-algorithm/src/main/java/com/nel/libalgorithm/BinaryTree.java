package com.nel.libalgorithm;

/**
 * Description :https://blog.csdn.net/fengrunche/article/details/52305748
 * CreateTime : 2018/5/17 18:32
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class BinaryTree implements BinaryTreeAbs {
    private Node root;

    BinaryTree(int value) {
        root = new Node(value);
        root.leftChild = null;
        root.rightChild = null;
    }

    @Override
    public Node findKey(int value) {
        Node current = root;
        if (current == null) {
            return null;
        }
        while (true) {
            if (value == current.value) {
                return current;
            } else if (value < current.value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
    }

    @Override
    public String insert(int value) {
        Node node = new Node(value);
        Node current = root;
        if (root == null) {
            root = node;
            return "insert root node";
        }
        while (true) {
            if (value == current.value) {
                return "save value in binary tree";
            } else if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    return "insert left";
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    return "insert right";
                }
                current = current.rightChild;
            }
        }
    }

    @Override
    public void inOrderTraverse() {

    }

    @Override
    public void inOrderByStack() {

    }

    @Override
    public void preOrderTraverse() {

    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void postOrderTraverse() {

    }

    @Override
    public void postOrderByStack() {

    }

    @Override
    public int getMinValue() {
        return 0;
    }

    @Override
    public boolean delete(int value) {
        return false;
    }
}
