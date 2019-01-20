import scala.language.implicitConversions

class MyString(s:String) {
	def rot(k:Int):String = {
		def f(c:Char) = {
			val m='Z' - 'A' +1
			if (c>='A' && c<='Z') {
				('A'+(k+c-'A')%m).toChar
			}
			else if (c>='a' && c<='z') {
				('a'+(k+c-'a')%m).toChar
			}
			else c
		}
		s.map(f)
	}
}

object E28 {
	implicit def String2MyString(s:String) = new MyString(s)
}
