object quick_main extends App {
	println("ordinamento tramite quicksort di una lista non ordinata:")
	val l=List(10, -32, 0, 3, 56, 2, 6, 4, 9, 32, 20, 11, 1)
	println(l)
	println("lista ordinata:")
	println(quickSort.qsort(l))
}
