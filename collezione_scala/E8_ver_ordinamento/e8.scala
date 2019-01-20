object e8 {
	def isSorted(l:List[Int]):Boolean = {
		l match {
			case Nil => true
			case head::Nil => true
			case head::tail => head<=tail(0) && isSorted(tail)
		}
	}
}
