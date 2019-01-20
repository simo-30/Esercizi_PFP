import scala.language.implicitConversions

class MySeq[T](s:Seq[T]) {
	def isRot(m:Seq[T]) = {
		def aux(n:Int, l:Int):Option[Int] = {
			if (n>=l) None
			else {
				val (a, b) = m.splitAt(n)
				if ((b ++ a) == s) Some(n)
				else aux(n+1, l)
			}
		}
		aux(0, s.length)
	}	
}

object IsRot {
	implicit def convert[T](s:Seq[T]) = new MySeq(s)
}
