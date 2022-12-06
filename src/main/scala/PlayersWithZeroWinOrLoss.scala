package com.varaprasad

import scala.annotation.tailrec
import scala.collection.immutable.TreeSet

/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/
 */
object PlayersWithZeroWinOrLoss extends App {
  val inp: Array[Array[Int]] = Array(Array(1, 3), Array(2, 3), Array(3, 6), Array(5, 6), Array(5, 7), Array(4, 5), Array(4, 8), Array(4, 9), Array(10, 4), Array(10, 9))

  def findWinners(matches: Array[Array[Int]]): List[List[Int]] = {
    @tailrec
    def solve(rem: Array[Array[Int]], won: TreeSet[Int], lostOnce: TreeSet[Int], lostMore: TreeSet[Int]): List[List[Int]] = {
      rem.headOption match {
        case Some(head) =>
          if (lostOnce(head(1))) {
            solve(rem.tail, won | Set(head(0)), lostOnce, lostMore | Set(head(1)))
          } else {
            solve(rem.tail, won | Set(head(0)), lostOnce | Set(head(1)), lostMore)
          }
        case None => List(won.diff(lostOnce).toList, lostOnce.diff(lostMore).toList)
      }

    }

    solve(matches, TreeSet.empty, TreeSet.empty, TreeSet.empty)
  }
  println(findWinners(inp))
}
