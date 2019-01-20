sealed abstract class BinTree {
    def sum:Int = this match {
		case T(l, e, r) => l.sum + e + r.sum
		case E() => 0
	}
}

// albero non vuoto
case class T(l:BinTree, e:Int, r:BinTree) extends BinTree 

// albero vuoto
case class E() extends BinTree
