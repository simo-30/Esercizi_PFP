object PuntoMain extends App {
	val p = Punto(4.7, 3.7)
	val q = Punto(2.6, 2.9)
	println("Punto P " + p)
	println("La distanza dal centro del punto P è di: " + p.mod)
	println("Punto Q " + q)
	println("La distanza tra il punto P ed il punto Q è")
	println(p.distanzaTra2Punti(q))
	println("La somma tra i punti P e Q è")
	println(p+q)
}
