object B3 {
	def max(f1:Int=>String, f2:Int=>String):Int=>String = {
		x => {
			val y1=f1(x)
			val y2=f2(x)
			if (y1.length>y2.length) y1 else y2
		}
	}
}
