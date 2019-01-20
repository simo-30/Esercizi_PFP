case class Rational(num:Int, den:Int) {
	
	def mcd(x:Int, y:Int):Int = if (y==0) x else mcd(y, x%y)
	
	override def toString = num+"/"+den
	
	/*
	def apply(n:Int, d:Int) = {
		val m=mcd(n, d)
		val r=Rational(n/m, d/m)
	}
	*/
	
	def value():Double = num.toDouble/den.toDouble
	
	def +(r:Rational) = {
		//def mcd(x:Int, y:Int):Int = if (y==0) x else mcd(y, x%y)
		val d=den*r.den
		val n=num*r.den+r.num*den
		val m=mcd(n,d)
		Rational(n/m, d/m)
	}
	
	def -(r:Rational) = {
		val d=den*r.den
		val n=num*r.den-r.num*den
		val m=mcd(n,d)
		Rational(n/m, d/m)
	}
	
	def *(r:Rational) = {
		val n=num*r.num
		val d=den*r.den
		val m=mcd(n,d)
		Rational(n/m, d/m)
	}
	
	def /(r:Rational) = {
		val n=num*r.den
		val d=den*r.num
		val m=mcd(n,d)
		Rational(n/m, d/m)
	}
	
	def ==(r:Rational) = value==r.value
	def !=(r:Rational) = value!=r.value
	def <(r:Rational) = value<r.value
	def >(r:Rational) = value>r.value
}

/*
object Rational {
	def apply(n:Int, d:Int) = {
		def mcd(x:Int, y:Int):Int = if (y==0) x else mcd(y, x%y)
		val m=mcd(n, d)
		val r=new Rational(n/m, d/m)
	}
}
*/
