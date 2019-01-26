object A2 {
	
	def query1(l:List[Studente]) = {
		val etaMedia = l.map(_.età).sum.toDouble/l.size
		l.filter(s => s.età < etaMedia && s.esami.size>=3)
	}
	
	def query2(l:List[Studente]) = {
		l.map(_.esami).flatten.groupBy(identity).filter(t=>t._2.size>2).map(_._1).toList
	}
}
