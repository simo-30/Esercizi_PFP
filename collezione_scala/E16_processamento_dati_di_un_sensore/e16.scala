object e16 {
	def mediaVeicoli(l:List[Int]):Double = {
		def media(g:List[Int]):Double = {
			g.reduce(_+_).toDouble/(g.length)
		}
		val pass=l.span(_ != -1)._1
		media(pass)	
	}
}
