object E34 {
	def search[T <% Ordered[T]](v:Vector[T], e:T):Boolean = {
		if (v.size < 1) false
		else {
			val med=v(v.size/2)
			if (med==e) true
			else {
				val (min, magg)=v.splitAt(v.size/2)
				if (med<e) search(magg, e)
				else search(min, e)
			}
		}
	}
}
