object e12 {
	//questa soluzione non accetta liste vuote
	def myMaxAux(l:List[String]) = l.map(_.size).reduce((x,y) => if (x>y) x else y)

	//uso la soluzione di prima con pattern matching
	def myMax(l:List[String]) = {
		l match {
			case Nil => 0
			case _ => myMaxAux(l)
		}
	}
}
