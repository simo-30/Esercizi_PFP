object Model2D {

  def getToroidalMandala(numPetals:Int) = {

    // completare costruzione di un modello 2D di un Mandala toroidale
    //List(Circle(0.5, 0.5, 0.5))
    //(0 to numPetals-1).map(i => Circle(0.5+math.cos(rad(i))*0.25, 0.5+math.sin(rad(i))*0.25, 0.25)).toList
    def rad(i:Int) = 2.0*math.Pi*i/numPetals
    val l = for {
		i <-0 to numPetals-1
		r=rad(i)
		x=0.5+math.cos(r)*0.25
		y=0.5+math.sin(r)*0.25
	} yield Circle(x,y,0.25)
	l.toList
  }

  def main(args:Array[String]) {
    println("Displaying Toroidal Mandala...")
    Frame2D.display(Model2D.getToroidalMandala(24), 500, 500)
  }
}
