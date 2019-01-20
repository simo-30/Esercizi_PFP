object e15 {
	def minMax(l:List[Int]):(Int, Int) = {
		l match {
			case Nil => {
				println("Lista vuota :(")  //stampa un messaggio di errore per segnalare il passaggio di una lista vuota
				(0, 0)
			}
			case head::Nil => (head, head)
			case head :: tail =>
				val (recMin, recMax) = minMax(tail)
				(math.min(head, recMin), math.max(head, recMax))
		}
	}
}
