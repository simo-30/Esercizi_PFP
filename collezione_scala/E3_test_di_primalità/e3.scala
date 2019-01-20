object e3 {
	def isPrimo(n:Int):Boolean = List.range(2, n).forall(n%_ != 0) 	
}
