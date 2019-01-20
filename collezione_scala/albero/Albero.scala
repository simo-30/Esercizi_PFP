sealed abstract class Albero {
	def numNodi:Int = this match {
		case AlberoVuoto() => 0
		case AlberoPieno(dx, _, sx) => 1 + dx.numNodi + sx.numNodi
	}
	
	override def toString:String = this match {
		case AlberoVuoto() => "."
		case AlberoPieno(l,q,r) => "("+l.toString+" "+q+" "+r.toString+")"
	}
}

case class AlberoVuoto() extends Albero
case class AlberoPieno(dx:Albero, t:Int, sx:Albero) extends Albero
