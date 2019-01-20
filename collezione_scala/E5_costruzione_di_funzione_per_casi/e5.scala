object e5 {
	def funz(f1:Double=>Double, f2:Double=>Double, f3:Double=>Double, a:Double, b:Double)(x:Double) = {
		x match {
			case x if (x<a) => f1(x)
			case x if (x>b) => f3(x)
			case _ => f2(x)
		}
	}
}
