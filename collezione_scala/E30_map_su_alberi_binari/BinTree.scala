sealed abstract class BinTree {
    def map(f:Int=>Int):BinTree = {
		this match {
			case E() => E()
			case T(l, e, r) => T(l.map(f), f(e), r.map(f))
		}
	}
}

// albero non vuoto
case class T(l:BinTree, e:Int, r:BinTree) extends BinTree 

// albero vuoto
case class E() extends BinTree
