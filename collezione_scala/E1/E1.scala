object E1 {
	def applicaDueVolte(f:Int=>Int, x:Int) = f(f(x))
	//esercizio 2
	def applicaDueVolte2(f:Int=>Int)(x:Int) = f(f(x))
}
