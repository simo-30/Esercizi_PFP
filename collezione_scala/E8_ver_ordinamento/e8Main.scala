object e8Main extends App {
	val l=List(1,2,3,4,4,6,9)
	val q=List(10,4,2,8,9,34,100)
	println("le due liste da testare sono")
	println("lista1 = " + l)
	println("lista2 = " + q)
	println("la lista1 è ordinata: " + e8.isSorted(l))
	println("la lista2 è ordinata: " + e8.isSorted(q))
}
