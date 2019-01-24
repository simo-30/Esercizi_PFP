object B3Main extends App {

    def f1(i:Int):String = i match {
        case 1 => "monday"
        case 2 => "tuesday"
        case 3 => "wednesday"
        case 4 => "thursday"
        case 5 => "friday"
        case 6 => "saturday"
        case 7 => "sunday"
        case _ => "error"
    }

    def f2(i:Int):String = i match {
        case 1 => "lunedì"
        case 2 => "martedì"
        case 3 => "mercoledì"
        case 4 => "giovedì"
        case 5 => "venerdì"
        case 6 => "sabato"
        case 7 => "domenica"
        case _ => "errore"
    }

    val m1:Int=>String = B3.max(f1,f2)
    val l1 = (1 to 8) map (x => m1(x))
    println(l1.toList +
        " [corretto: List(lunedì, martedì, mercoledì, " +
        "thursday, venerdì, saturday, domenica, errore)]")
}
