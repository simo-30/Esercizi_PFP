object e11 {
	def union[T](a:List[T], b:List[T]):List[T] = {
		(a,b) match {
			case (Nil, Nil) => Nil
			case (h1::t1, Nil) if (union(t1, b).contains(h1)==false) => h1::union(t1,b)
		}
	}
}
