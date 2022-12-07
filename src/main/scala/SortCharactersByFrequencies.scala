package com.varaprasad

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
object SortCharactersByFrequencies extends App {

  def frequencySort(s: String): String = {
    s.groupBy(x => x)
      .toList
      .sortBy(x => x._2.length)(Ordering.Int.reverse)
      .map(x => x._2)
      .mkString
  }
  val s = "tree"
  println(frequencySort(s))
}
