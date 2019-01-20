import scala.language.implicitConversions

/*
class IsRot[T](s:Seq[T]) {
	def isRot(m:Seq[T]) = {
		def aux(n:Int, size:Int):Option[Int] = {
			if (n>=size) None
			else if (m == s.drop(size-n) ++ s.dropRight(n)) Some(n)
			else aux(n+1, size)
		}
		if (s==m) Some(0)
		else aux(1, s.length)
	}
}
*/

//versione alternativa
class IsRot[T](s:Seq[T]) {
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
	implicit def convert[T](s:Seq[T]) = new IsRot(s)
}
