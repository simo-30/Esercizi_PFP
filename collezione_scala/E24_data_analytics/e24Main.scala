object e24Main extends App {
	case class Studente(nome:String, val età:Int, esami:List[String])
	val q = List(
                 Studente("Marco",   23, List("PFP","SC")), 
                 Studente("Laura",   19, List("SC", "FI1", "PFP")), 
                 Studente("Stefano", 23, List("SC", "FI1")), 
                 Studente("Marco",   25, List("SC", "FI1", "FI2")), 
                 Studente("Paola",   22, List("SC", "PFP"))
            )
    
    def q1(l:List[Studente], eMin:Int, eMax:Int, esame:String):List[Studente] = {
		l match {
			case Nil => Nil
			case h::t => if (h.età>=eMin && h.età<=eMax && h.esami.contains(esame)) h::q1(t,eMin,eMax,esame) else q1(t,eMin,eMax,esame) 
		}
	}
	
	def q2(l:List[Studente], e:Int, numEsami:Int):List[Studente] = {
		l match {
			case Nil => Nil
			case h::t => if (h.età<e && h.esami.size>=numEsami) h::q2(t, e, numEsami) else q2(t, e, numEsami)
		}
	}

	val query1 = q1(q,20,24,"PFP")
	// estrarre tutti gli studenti con età compresa tra 20 e 24 anni (inclusi) che hanno sostenuto l'esame di "PFP"
	// stampare i dati degli studenti in query1
	println(query1)

	val query2 = q2(q, 24, 2)
	println(query2)
	// estrarre tutti gli studenti con età strettamente inferiore a 24 anni che hanno sostenuto almeno due esami
	// stampare i dati degli studenti in query2

}
