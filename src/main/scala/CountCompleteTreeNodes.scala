package com.varaprasad

import helper.TreeNode

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
object CountCompleteTreeNodes extends App {
  def countNodes(root: TreeNode): Int = {
    if (root == null) 0 else 1 + countNodes(root.left) + countNodes(root.right)
  }

}
