object e16Main extends App {
	val l=List(2,5,10,9,21,23,2,6,-1,2,4,3,-87)
	val g=List(23,6,1,0,34,2,8,-8,-7,43)
	println("La prima lista dal sensore è")
	println(l)
	println("di cui la media dei veicoli passati è")
	println(e16.mediaVeicoli(l))
	println("La seconda lista dal sensore è")
	println(g)
	println("di cui la media dei veicoli passati è")
	println(e16.mediaVeicoli(g))
}
