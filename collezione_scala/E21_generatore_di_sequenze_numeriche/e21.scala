object e21 {
	def generateSeq(n:Int, seed:Int, f:Int=>Int):List[Int] = {
		if (n==0) Nil
		else seed :: generateSeq(n-1, f(seed), f)
	}
}
