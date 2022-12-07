package com.varaprasad

import helper.ListNode

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 */
object OddEvenLinkedList {
  def oddEvenList(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      head
    } else {
      var odd = head
      var even = head.next
      val oddHead = odd
      val evenHead = even
      while (even != null && even.next != null && odd != null && odd.next != null) {
        odd.next = odd.next.next
        odd = odd.next
        even.next = even.next.next
        even = even.next
      }
      odd.next = evenHead
      oddHead
    }
  }

}
