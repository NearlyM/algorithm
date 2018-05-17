package com.nel.libalgorithm;

/**
 * Description :
 * CreateTime : 2018/5/17 18:24
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public interface BinaryTreeAbs {
    Node findKey(int value);   //查找
    String insert(int value);  //插入
    void inOrderTraverse();    //中序遍历递归操作
    void inOrderByStack();     //中序遍历非递归操作
    void preOrderTraverse();  //前序遍历
    void preOrderByStack();   //前序遍历非递归操作
    void postOrderTraverse(); //后序遍历
    void postOrderByStack();  //后序遍历非递归操作
    int getMinValue(); //得到最小(大)值
    boolean delete(int value); //删除
}
