object A3Main extends App {

    // parte I: definizione della gerarchia e conversione a stringa di exp
    val e:Exp = And(Or(X(), Y()), Not(Y()))
    println(e + " [corretto: and(or(x,y),not(y))")

    // parte II: valutazione di espressioni booleane
    for ( x <- List(true, false); y <- List(true, false) ) {
        val b:Boolean = e(x,y)
        println("e("+x+","+y+")="+b+" [corretto: "+((x||y) && !y)+"]")
    }

    // parte III: relazione se e solo se (<=>)
    val e1:Exp = And(Or(X(), Y()), Not(Y()))
    val e2:Exp = Not(Or(And(Not(X()), Not(Y())),Y()))
    val e3:Exp = And(Or(X(), Not(X())),Or(Y(), Not(Y())))
    println("e1 <=> e2: "+(e1 <=> e2)+" [corretto: true]")
    println("e1 <=> e3: "+(e1 <=> e3)+" [corretto: false]")
    println("True() <=> e3: "+(True() <=> e3)+" [corretto: true]")
    println("True() <=> False(): "+(True() <=> False())+" [corretto: false]")
}


sealed abstract class Exp {
	
	def apply(x:Boolean, y:Boolean):Boolean = {
		this match {
			case And(a,b) => a(x,y) && b(x,y)
			case Or(a,b) => a(x,y) || b(x,y)
			case Not(a) => !a(x,y)
			case X() => x
			case Y() => y
			case True() => true
			case False() => false
		}
	}
	
	override def toString:String = {
		this match {
			case And(a,b) => "and("+a.toString+","+b.toString+")"
			case Or(a,b) => "or("+a.toString+","+b.toString+")"
			case Not(a) => "not("+a.toString+")"
			case X() => "x"
			case Y() => "y"
			case True() => "true"
			case False() => "false"
		}
	}
	
	def <=>(b:Exp) = {
		this(true,true) == b(true,true) &&
		this(true,false) == b(true,false) &&
		this(false,true) == b(false,true) &&
		this(false,false) == b(false,false)
	}
}

case class And(a:Exp, b:Exp) extends Exp
case class Or(a:Exp, b:Exp) extends Exp
case class Not(a:Exp) extends Exp
case class X() extends Exp
case class Y() extends Exp
case class True() extends Exp
case class False() extends Exp
