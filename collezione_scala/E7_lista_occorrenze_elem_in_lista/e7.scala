object e7 {
	def findIndices[T](l:List[T], x:T) = {
		val ret = for {
			i <-0 to l.size-1
			if (l(i) == x)
		} yield i
		ret.toList
	} 
}
