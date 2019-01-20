object AlberoMain extends App {
	val e = AlberoVuoto()
	val t1 = AlberoPieno(e, 5, e)
	val t2 = AlberoPieno(e, 10, t1)
	val t3 = AlberoPieno(t1, 3, t2)
	val t4 = AlberoPieno(t2, 20, t3)
	println(t4)
}
