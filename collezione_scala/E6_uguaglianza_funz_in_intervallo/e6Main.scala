object e6Main extends App {
	val a=3
	val b=10
	
	println("l'intervallo è ["+a+";"+b+"]")
	println("le funzioni testate sono")
	println("funz1 = x=>x*2")
	println("funz2 = x=>x+x")
	println("funz3 = x=>x+3")
	println("test ricorsivo funz1 vs funz2: " + e6.equalInRange(x=>x*2, x=>x+x, a, b))
	println("test ricorsivo funz1 vs funz3: " + e6.equalInRange(x=>x*2, x=>x+3, a, b))
	println("test ricorsivo funz2 vs funz3: " + e6.equalInRange(x=>x+x, x=>x+3, a, b))
	println("test funz1 vs funz2: " + e6.equalInRange2(x=>x*2, x=>x+x, a, b))
	println("test funz1 vs funz3: " + e6.equalInRange2(x=>x*2, x=>x+3, a, b))
	println("test funz2 vs funz3: " + e6.equalInRange2(x=>x+x, x=>x+3, a, b))
}
