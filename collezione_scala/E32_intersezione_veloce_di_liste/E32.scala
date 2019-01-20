object E32 {
	def inter[T](a:List[T], b:List[T]):List[T] = {
		val as=a.toSet
		val bs=b.toSet
		as.filter(bs(_)).toList
	}
}
