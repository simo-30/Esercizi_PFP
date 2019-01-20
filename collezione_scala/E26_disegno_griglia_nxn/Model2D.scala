import java.awt.Color

object Model2D {

  def getGrid(n:Int) = {

    val RED = new Color(0xFF0000) // in formato RGB (Red-Blue-Green) o anche Color.RED

    // completare costruzione di un modello 2D di una griglia con n linee verticali ed n linee orizzontali
    /*List(
        Line(0.0,0.5,1.0,0.5,RED), // linea rossa
        Line(0.5,0,0.5,1.0)        // linea colore default (nero)
    )*/
    
    val dist=1/n.toDouble
    println(dist)
    val l=for {
		i <-0 to n
	} yield Line(0.0, i*dist, 1.0, i*dist)
	val p=for {
		i <-0 to n
	} yield Line(i*dist, 0.0, i*dist, 1.0, RED)
	(l.toList):::(p.toList)
  }

  def main(args:Array[String]) {
    println("Displaying 20x20 grid...")
    Frame2D.display(Model2D.getGrid(20), 500, 500)
  }
}
