object E_Main extends App {
	val y = E1.applicaDueVolte(x=>x+1, 10)
	println(y) // stampa 12
	
	val incrementaDueVolte = E1.applicaDueVolte2(x=>x+1) _
	val z = incrementaDueVolte(10)
	println(z) // stampa 12

}
