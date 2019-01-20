import scala.language.implicitConversions

class MyList[T](l:List[T]) {
	def myReduce(f:(T,T)=>T):Option[T] = {
		l match {
			case Nil => None
			case h::Nil => Some(h)
			case h::t => {
				def aux(q:List[T], acc:T):T = {
					if (q.isEmpty) acc
					else aux(q.tail, f(acc, q.head))
				}
				Some(aux(t, h))
			}
		}
	}
}

object MyRed {
	implicit def list2MyList[T](l:List[T]) = new MyList(l)
}
