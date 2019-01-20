/*
 * per risolvere questo esercizio implemento due soluzioni:
 * 1) ricorsiva con utilizzo di pattern matching
 * 2) utilizzo di funzioni su List
 */

object e6 {
	def minMagg(x:Int, y:Int):(Int, Int) = {
		//ritorna una tupla di Int dove il primo è il minore dei 2, ed il secondo è il maggiore
		if (x<y) (x, y)
		else (y, x)
	}
	
	def equalInRange(f:Int=>Int, g:Int=>Int, a:Int, b:Int):Boolean = {
		//versione ricorsiva
		(a, b) match {
			case (a, b) if (a>b) => f(b)==g(b)
			case (a, b) => f(a)==g(a) && equalInRange(f,g,a+1,b) 
		}
	}
	
	def equalInRange2(f:Int=>Int, g:Int=>Int, a:Int, b:Int) = {
		//versione con utilizzo di funzioni su List
		val (min, max)=minMagg(a,b)
		val l=List.range(min, max+1).map(f(_))
		val q=List.range(min, max+1).map(g(_))
		l==q
	}
}
