object ClimbingStairs extends App {
  def climbStairs(n: Int): Int = {
    val arr = Array(1, 2)
    if (n <= 2) {
      arr(n - 1)
    } else {
      for (_ <- 2 until n + 1) {
        val temp = arr(1)
        arr(1) = arr(0) + arr(1)
        arr(0) = temp
      }
      arr(0)
    }
  }

  def climbingStairs2(n: Int): Int = {
    import scala.annotation.tailrec
    @tailrec
    def solve(i: Int, first: Int, second: Int): Int = {
      if(i == 0) {
        first
      } else {
        solve(i - 1, second, first + second)
      }
    }

    if (n <= 2) {
      n
    } else {
      solve(n - 1, 1, 2)
    }
  }
}