package com.yugutou.charpter8_tree_hot_problems;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

public class Practice {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = binaryTree.buildLowestCommonAncestor();

        binaryTree.preOrder(delSon(binaryTree.root));;
    }

    /**
     * 删除叶子节点
     *
     * @param root
     */
    public static TreeNode delSon(TreeNode root) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            return null;
        }

        root.left = delSon(root.left);
        root.right = delSon(root.right);

        return root;
    }
}
