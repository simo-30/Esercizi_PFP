object e9 {
	def consecutivi[T](l:List[T]) = {
		val ret = for {
			i <-0 to l.size-2
		} yield (l(i), l(i+1))
		ret.toList
	}
}
