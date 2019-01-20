object e18Main extends App {
	val l=List("simone", "trenta", 1, 5, "tre", 5.76, (8,"ciao"))
	println("Questa è la lista su cui filtrare")
	println(l)
	println("La filtriamo per indici pari")
	println(e18.filterByIndex(l, _%2==0))
}
