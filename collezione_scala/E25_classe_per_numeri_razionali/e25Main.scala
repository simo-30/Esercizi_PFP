object e25Main extends App {
	val r1 = Rational(2, 7)
	val r2 = Rational(8, 6)
	val r3 = Rational(4, 14)
	println(r1+r2)  // stampa 34/21
	println(r1-r2)  // stampa -22/21
	println(r1*r2)  // stampa 8/21
	println(r1/r2)  // stampa 3/14
	println(r1==r3) // stampa true
	println(r1!=r2) // stampa true
	println(r1<r2)  // stampa true
	println(r2<r1)  // stampa false
}
