import IsRot._
import PIsRot._

object PIsRotMain extends App {
    val l1:Seq[Char] = "Hello world"
    val m1:Seq[Char] = "orldHello w"
    val r1:Option[Int] = l1.isRotPar(m1)
    val c1 = Some(4)
    println("Test 1: " + r1 + " (corretto: " + c1 + ")")

    val l2:Seq[Int] = List(0,1,2,3,4,5,6,7,8,9)
    val m2:Seq[Int] = List(3,4,5,6,7,8,9,0,1,2)
    val r2:Option[Int] = l2.isRotPar(m2)
    val c2 = Some(7)
    println("Test 2: " + r2 + " (corretto: " + c2 + ")")

    val l3:Seq[String] = List("one", "two")
    val m3:Seq[String] = List("Two", "one")
    val r3:Option[Int] = l3.isRotPar(m3)
    val c3 = None
    println("Test 3: " + r3 + " (corretto: " + c3 + ")")

    val l4:Seq[Boolean] = List(true, false, false)
    val m4:Seq[Boolean] = List(true, false, false)
    val r4:Option[Int] = l4.isRotPar(m4)
    val c4 = Some(0)
    println("Test 4: " + r4 + " (corretto: " + c4 + ")")

    val l5:Seq[Boolean] = List(true, false, false)
    val m5:Seq[Boolean] = List(true)
    val r5:Option[Int] = l5.isRotPar(m5)
    val c5 = None
    println("Test 5: " + r5 + " (corretto: " + c5 + ")")

    val l6:Seq[Short] = List(1,2,1,2)
    val m6:Seq[Short] = List(2,1,2,1)
    val r6:Option[Int] = l6.isRotPar(m6)
    val c6 = Some(1)
    println("Test 6: " + r6 + " (corretto: " + c6 + ")")

    val n = 20000
    val l = (0 to n).toVector
    val (a,b) = l splitAt 2*l.size/3
    val m = b ++ a
    println("Versione sequenziale...")
    val (v, t)   = Prof.profila { l.isRot(m) }
    println("Versione parallela...")
    val (vp, tp) = Prof.profila { l.isRotPar(m) }
    println("Test 7: " + vp + " (corretto: " + v + " - tempo seq: "+t*1E-9+" sec - tempo par: "+tp*1E-9+" sec)")
}
