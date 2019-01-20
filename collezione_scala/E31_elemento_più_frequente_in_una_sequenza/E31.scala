object E31 {
	def piùFrequente[T](l:Seq[T]):Option[(T,Int)] = {
		if (l.isEmpty) None
		else {
			val (x,y)=l.groupBy(identity).maxBy(_._2.size)
			Some((x,y.length))
		}
	} 
}
