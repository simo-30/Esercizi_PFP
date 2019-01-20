object e12Main extends App {
	val l = List("Simone", "Trenta", "Roma", "programmazione", "Sabaudia", "ciao io sono Simone Trenta")
	val q = List()
	val m = e12.myMax(l)
	val n = e12.myMax(q)
	println("questa è la lista")
	println(l)
	println("la parola più lunga contiene " + m + " lettere")
	println(n)
}
