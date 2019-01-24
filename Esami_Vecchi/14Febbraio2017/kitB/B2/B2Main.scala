import MyList._

object B2Main extends App {
    // test 1
    val l1 = List("uno", "due", "tre", "quattro", "cinque")
    val mask1 = List(true, true, false, true, false)
    val p1 = l1 project mask1
    println(p1 + " [corretto: List(uno, due, quattro)]")

    // test 2
    val l2 = (1 to 10).toList.map(_*3)
    val mask2 = (0 to 9).toList.map(_%2 == 0)
    val p2 = l2 project mask2
    println(p2 + " [corretto: List(3, 9, 15, 21, 27)]")

    // test 3
    val l3 = (1 to 10).toList
    val mask3 = (1 to 20).toList.map(_%3 == 0)
    val p3 = l3 project mask3
    println(p3 + " [corretto: List(3, 6, 9)]")
}
