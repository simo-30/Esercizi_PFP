object A3 {
	def test[T](l:List[T], p:List[T]) = {
		l.intersect(p).size==0
	}
}
