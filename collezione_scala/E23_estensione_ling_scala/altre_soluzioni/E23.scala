object E23 {
	def profila[T](body: => T):(T,Long) = {
		val start=System.nanoTime
		val v=body
		val end=System.nanoTime
		(v, end-start)
	}
}
