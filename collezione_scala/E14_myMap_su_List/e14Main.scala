object e14Main extends App {
	val l = List(1,2,3,4,5,6,7,8,9,10)
	println("Applico myMap sulla lista:")
	println(l)
	val p = e14.myMap(l, _*3)
	println("Risultato della myMap:")
	println(p)
}
