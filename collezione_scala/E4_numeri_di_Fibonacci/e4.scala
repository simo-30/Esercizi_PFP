object e4 {
	def fibo(n:Int):Int = if (n<3) 1 else fibo(n-2)+fibo(n-1)
	
	def fibo2(n:Int):Int = n match {
		case 1 => 1
		case 2 => 1
		case n => fibo2(n-1) + fibo2(n-2)
	}
	
	def fibo3(n:Int) = {
		def tailrec(n:Int, prev:Int, succ:Int):Int = n match {
			case 1 => prev
			case 2 => succ
			case n => tailrec(n-1, succ, prev+succ)
		}
		tailrec(n, 1, 1)
	}
}
