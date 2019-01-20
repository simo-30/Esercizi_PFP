object quickSort {
	//algoritmo di ordinamento quicksort
	def qsort(l:List[Int]):List[Int] = {
		if (l.size < 2 ) l
		else {
			val (a,b) = l.tail.partition(_<l.head) //divido la lista in due usando come pivot la testa
			qsort(a) ::: List(l.head) ::: qsort(b)
		}
	} 
}
