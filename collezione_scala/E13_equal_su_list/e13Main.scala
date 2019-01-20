object e13Main extends App {
	val l = List(1,2,3,4,5)
	val p = List(1,2,3,4,5)
	val s = List(5,4,3,2,1)
	println("uguaglianza profonda fra 3 liste:")
	println(l + " == " + p + " : " + e13.myEquals(l, p))
	println(l + " == " + s + " : " + e13.myEquals(l, s))
}
