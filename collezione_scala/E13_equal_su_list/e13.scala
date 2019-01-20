object e13 {
	
	def myEquals(l:List[Int], p:List[Int]):Boolean = {
		(l,p) match {
			case (Nil, Nil) => true
			case (Nil, _) => false
			case (_, Nil) => false
			case (h1::t1, h2::t2) => h1==h2 & myEquals(t1, t2)
		}
	}
}
