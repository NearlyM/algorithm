package com.nel.libalgorithm.avl;

/**
 * Description :
 * CreateTime : 2018/5/21 17:13
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class AVLNode {
    int value;
    int height;

    AVLNode leftNode;
    AVLNode rightNode;

    AVLNode(int value) {
        this(null, null, value);
    }

    AVLNode(AVLNode leftNode, AVLNode rightNode, int value) {
        this(leftNode, rightNode, value, 0);
    }

    AVLNode(AVLNode leftNode, AVLNode rightNode, int value, int height) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.height = height;
    }
}
