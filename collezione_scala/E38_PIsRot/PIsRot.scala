import scala.language.implicitConversions

class MySeqPar[T](s:Seq[T]) {
    private def isRotInRange(m:Seq[T], min:Int, max:Int):Option[Int] = {
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

    def isRotPar(m:Seq[T]):Option[Int] = {
        def aux(min:Int, max:Int, t:Int):Option[Int] = {
            if (t < 2) isRotInRange(m, min, max)
            else if (min >= max) None
            else {
                val mid = (min+max)/2
                val (rl, rr) = Par.par { aux(min, mid, t/2) }
                                       { aux(mid, max, t/2) }
                if (rl == None) rr else rl
            }
        }
        aux(0, m.size, PIsRot.NUM_CORES)
    }
}

object PIsRot {
    lazy val NUM_CORES = Runtime.getRuntime().availableProcessors()
    implicit def seq2MySeqPar[T](l:Seq[T]) = new MySeqPar(l)
}
