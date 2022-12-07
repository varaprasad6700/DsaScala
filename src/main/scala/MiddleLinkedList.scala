package com.varaprasad

import helper.ListNode

import scala.annotation.tailrec

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
object MiddleLinkedList extends App {

  def middleNode(head: ListNode): ListNode = {
    var slow = head
    var fast = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
    }
    slow
  }

  def middleNodeTail(head: ListNode): ListNode = {
    @tailrec
    def solve(slow: ListNode, fast: ListNode): ListNode = {
      if (fast == null || fast.next == null)
        slow
      else {
        solve(slow.next, fast.next.next)
      }
    }

    solve(head, head)
  }

}
