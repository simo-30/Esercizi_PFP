object e5Main extends App {
	println("Intervallo dato [5,10]")
	println("f1:x=>2*x")
	println("f2:x=>x/2")
	println("f3:x=>x*x")
	println("passo x=3.32")
	println(e5.funz(x=>2*x, x=>x/2, x=>x*x, 5, 10)(3.32))
	println("passo x=7.6")
	println(e5.funz(x=>2*x, x=>x/2, x=>x*x, 5, 10)(7.6))
	println("passo x=11.87")
	println(e5.funz(x=>2*x, x=>x/2, x=>x*x, 5, 10)(11.87))
}
