object e21Main extends App {
	val seed=1
	val n=10
	println("Genero una lista di " + n + " numeri dal seme " + seed + " usando la funzione x=>x*2")
	println(e21.generateSeq(n, seed, x=>x*2))
}
