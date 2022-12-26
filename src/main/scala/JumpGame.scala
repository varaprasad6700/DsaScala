package com.varaprasad

/**
 * https://leetcode.com/problems/jump-game/description/
 */
object JumpGame extends App {
  def canJump(nums: Array[Int]): Boolean = {
        var dest = nums.length - 1
        for (i <- nums.length - 1 until -1 by -1) {
            if (i + nums(i) >= dest) {
                dest = i
            }
        }
        dest == 0
    }

}
