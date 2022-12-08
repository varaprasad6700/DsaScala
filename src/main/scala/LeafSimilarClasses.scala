package com.varaprasad

import helper.TreeNode

import scala.annotation.tailrec

object LeafSimilarClasses extends App {

  @tailrec
  def getLeaves(stack: List[TreeNode], leaves: List[Int] = List.empty): List[Int] = {
    stack match {
      case head :: tail =>
        (Option(head.left), Option(head.right)) match {
          case (Some(left), Some(right)) => getLeaves(List(left, right) ::: tail, leaves)
          case (None, Some(right)) => getLeaves(right :: tail, leaves)
          case (Some(left), None) => getLeaves(left :: tail, leaves)
          case (None, None) => getLeaves(tail, head.value :: leaves)
        }
      case Nil => leaves.reverse
    }
  }

  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
    if (root1 == null || root2 == null) {
       root1 == null && root2 == null
    } else {
      val leaves1: List[Int] = getLeaves(List(root1))
      val leaves2: List[Int] = getLeaves(List(root2))
      leaves1 == leaves2
    }
  }

}
