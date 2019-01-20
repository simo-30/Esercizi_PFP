object e10 {
	def removeDuplicates[T](l:List[T]):List[T] = {
		aux(l, List[T]())
	}
	
	def aux[T](start:List[T], stop:List[T]):List[T] = {
		start match {
			case Nil => stop
			case h::t if (stop.contains(h)) => aux(t, stop)
			case h::t => (h::stop) :: aux(t, h::stop)
		}
		stop.reverse
	}
}
