package com.nel.libalgorithm.avl;

/**
 * Description :
 * CreateTime : 2018/5/21 17:20
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class AVLTree {

    AVLNode root;

    private AVLNode singleRotateLeft(AVLNode x) {
        AVLNode w = x.leftNode;
        x.leftNode = w.rightNode;
        w.rightNode = x;
        x.height = Math.max(x.leftNode.height, x.rightNode.height) + 1;
        w.height = Math.max(w.leftNode.height, x.height) + 1;
        return w;
    }

    private AVLNode singleRotateRight(AVLNode w) {
        AVLNode x = w.rightNode;
        w.rightNode = x.leftNode;
        x.rightNode = w;
        w.height = Math.max(w.leftNode.height, w.rightNode.height) + 1;
        x.height = Math.max(x.rightNode.height, w.height) + 1;
        return x;
    }

    private AVLNode doubleRotateWithLeft(AVLNode x) {
        x.leftNode = singleRotateRight(x.leftNode);
        return singleRotateLeft(x);
    }

    private AVLNode doubleRotateWithRight(AVLNode x) {
        x.rightNode = singleRotateLeft(x.rightNode);
        return singleRotateRight(x);
    }

    private AVLNode insert(int data, AVLNode p) {
        if (p == null) {
            p = new AVLNode(data);
        } else if (data < p.value) {
            p.leftNode = insert(data, p.leftNode);
            if (p.leftNode.height - p.rightNode.height == 2) {
                if (data < p.leftNode.value) {
                    //进行LL旋转
                    p = singleRotateLeft(p);
                } else {
                    //进行左右旋转
                    p = doubleRotateWithLeft(p);
                }
            }
        } else if (data > p.value) {
            p.rightNode = insert(data, p.rightNode);
            if (p.rightNode.height - p.leftNode.height == 2) {
                if (data > p.rightNode.value) {
                    p = singleRotateRight(p);
                } else {
                    p = doubleRotateWithRight(p);
                }
            }
        } else {
            //已经有相同的节点了，不做任何处理
        }

        p.height = Math.max(p.leftNode.height, p.rightNode.height) + 1;
        return p;
    }

    public void remove(int data) {
        this.root = remove(data, root);
    }

    private AVLNode remove(int data, AVLNode p) {
        if (p == null) {
            return null;
        }

        if (data < p.value) {
            //从左子树查找需要删除的元素
            p.leftNode = remove(data, p.leftNode);

            //判断需要那种旋转
            if (p.rightNode.height - p.leftNode.height == 2) {
                AVLNode curr = p.rightNode;
                if (curr.leftNode.height > curr.rightNode.height) {
                    //LL
                    p = singleRotateLeft(p);
                } else {
                    //LR
                    p = doubleRotateWithLeft(p);
                }
            }
        } else if (data > p.value) {
            //从右子树查找需要删除的元素
            p.rightNode = remove(data, p.rightNode);

            //判断需要那种旋转
            if (p.leftNode.height - p.rightNode.height == 2) {
                AVLNode curr = p.leftNode;
                if (curr.leftNode.height > curr.rightNode.height) {
                    //RR
                    p = doubleRotateWithRight(p);
                } else {
                    //RL
                    p = singleRotateRight(p);
                }
            }

        } else if (p.rightNode != null && p.leftNode != null) {
            //已找到需要删除的元素,并且要删除的结点拥有两个子节点

            //寻找替换结点
            p.value = findMin(p.rightNode).value;

            //移除用于替换的结点
            p.rightNode = remove(p.value, p.rightNode);

            p.height = Math.max(p.leftNode.height, p.rightNode.height) + 1;

            if (p.rightNode.height - p.leftNode.height == 2) {
                if (p.rightNode.leftNode.height > p.rightNode.rightNode.height) {
                    p = doubleRotateWithRight(p);
                } else {
                    p = singleRotateRight(p);
                }
            } else if (p.leftNode.height - p.rightNode.height == 2) {
                if (p.leftNode.leftNode.height > p.leftNode.rightNode.height) {
                    p = singleRotateLeft(p);
                } else {
                    p = doubleRotateWithRight(p);
                }
            }

        } else {
            //只有一个孩子结点或者只是叶子结点的情况
            p = (p.leftNode != null) ? p.leftNode : p.rightNode;
        }

        //更新高度值
        if (p != null) {
            p.height = Math.max(p.rightNode.height, p.leftNode.height) + 1;
        }
        return p;
    }

    private AVLNode findMin(AVLNode x) {
        return x;
    }
}
