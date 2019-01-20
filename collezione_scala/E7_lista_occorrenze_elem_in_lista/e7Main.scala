object e7Main extends App {
	val l=List("simone", 3, 4.5, "trenta", 3, ("simone", 4), "simone2", 3.7)
	val x=3
	val y="simone"
	val z="ciao"
	println("la lista è")
	println(l)
	println("i valori da cercare sono " + x + " & "+ y + " & " + z)
	println("la prima lista degli indici è")
	println(e7.findIndices(l, x))
	println("la seconda lista degli indici è")
	println(e7.findIndices(l, y))
	println("la terza lista degli indici è")
	println(e7.findIndices(l, z))
}
