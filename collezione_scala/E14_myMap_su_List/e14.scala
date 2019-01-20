object e14 {
	def myMap(l:List[Int], f:Int=>Int):List[Int] = {
		l match {
			case Nil => l
			case h::t => f(h)::myMap(t, f)
		}
	}
}
