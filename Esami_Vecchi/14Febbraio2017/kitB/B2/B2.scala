import scala.language.implicitConversions

class MyList[T](l:List[T]) {
	def project(mask:List[Boolean]) = {
		val s=if (l.length<mask.size) l.size else mask.size
		val ret=for {
			i <- 0 to s-1
			if (mask(i))
		} yield l(i)
		ret.toList
	}
}

object MyList {
	implicit def list2MyList[T](l:List[T]) = new MyList(l)
}
