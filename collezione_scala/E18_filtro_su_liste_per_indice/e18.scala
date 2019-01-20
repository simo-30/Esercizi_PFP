object e18 {
	def filterByIndex[T](l:List[T], f:Int=>Boolean) = {
		val ret = for {
			i <-0 to l.size-1
			if (f(i))
		} yield l(i)
		ret.toList
	}
}
