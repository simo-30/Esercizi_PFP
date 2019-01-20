object E33 {
	def isPrime(n:Int):Boolean = !List.range(2, (Math.sqrt(n)).toInt+1).exists(n%_==0)
	
	def findNextPrime(prev:Int):Int = {
		assert(prev%2==1)
		if (isPrime(prev+2)) prev+2
		else findNextPrime(prev+2)
	}
	
	def nextPrime(n:Int):Stream[Int] = {
		val succ=findNextPrime(n)
		succ #:: nextPrime(succ)
	}
	
	lazy val primes = 2 #:: 3 #:: nextPrime(3) 
}
