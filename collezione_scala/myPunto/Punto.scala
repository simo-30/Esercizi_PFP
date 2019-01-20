case class Punto (x:Double, y:Double) {
	override def toString = "(" + x + ";" + y + ")"
	
	def mod = Math.sqrt(x*x+y*y)
	
	def distanzaTra2Punti(other:Punto) = Math.abs(this.mod - other.mod)
	
	def +(other:Punto) = Punto(x+other.x, y+other.y)
}
