object merge_main extends App {
	println("eseguo mergesort su lista di interi non ordinata:")
	val l = List(6,23,9,1,89,-2,7,10,-23)
	println(l)
	println("lista ordinata:")
	println(mergeSort.merge_sort(l)) 
}
