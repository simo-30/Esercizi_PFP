object e17 {
	def sqrt(x:Double) = {
		val eps=0.001
		def abs(x:Double) = if (x<0) -x else x
		def itera(y:Double):Double = {
			if (abs(y-x/y) < eps) y
			else itera((y+x/y)/2)
		}
		itera(1)
	}
}
