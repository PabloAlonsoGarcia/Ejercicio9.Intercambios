import kotlin.random.Random

class Item() {

    var peso = Random.nextInt(1, 10)
    var valor = Random.nextInt(10, 50)


    override fun toString(): String {
        return "Item(w=$peso, v=$valor)"
    }


}

class Mochila(){
    var pesoMaximo = 0
    var objetos = mutableListOf<Item>()

}

class Personaje() {
    var nombre: String = ""
    var estadoVital: String = ""
    var raza: String = ""
    var clase: String =""
    var mochila = Mochila()

    fun llenarMochila(){
        //Repetir mientras el peso de los objetos de la mochila sea menor al peso maximo
        

    }



    init {
        val posibilidadesEv = listOf<String>("Adolescente","Adulto","Anciano")
        val posibilidadesRa = listOf<String>("Elfo","Humano","Enano","Goblin")
        val posibilidadesCl = listOf<String>("Mago","Ladron","Guerrero","Berserker","Mercader")
        val nombres = arrayOf("Jack","John","Jorge","Juan","Javier")


        nombre = nombres[Random.nextInt(0,5)]




        var rI1 = Random.nextInt(posibilidadesEv.size)
        val estadoVR = posibilidadesEv[rI1]

        rI1 = Random.nextInt(posibilidadesRa.size)
        val razaR = posibilidadesRa[rI1]

        rI1 = Random.nextInt(posibilidadesCl.size)
        val claseR = posibilidadesCl[rI1]

        this.estadoVital=estadoVR
        this.raza=razaR
        this.clase=claseR
    }
    fun imprimir(){
        println("Nombre: " +  this.nombre)
        println("Clase: "+ this.clase)
        println("Raza: "+ this.raza)
        println("Estado Vital: "+ this.estadoVital)

    }

    fun comprobarMensaje(mensaje:String): String{
        var mensajeA:String = mensaje

//comletar la funcion con las comprobaciones de los mensajes.
        if(mensaje.equals(mensaje.uppercase()) && mensaje.contains("?")){
            mensajeA="preguntaGrito"
        }else{
            if(mensaje.equals(mensaje.uppercase())){
                mensajeA="grito"}
            else{
                if(mensaje.equals("¿Como estas?") || mensaje.equals("¿como estas?") || mensaje.equals("¿Cómo estás?") ||mensaje.equals("¿cómo estás?") )
                    mensajeA="¿como estas?"
                else
                    if(mensaje.equals(this.nombre))
                        mensajeA="nombre"
                    else{
                        if(mensaje.equals("adiós") || mensaje.equals("Adiós") || mensaje.equals("adios") || mensaje.equals("Adios"))
                            mensajeA="adios"
                    }
            }
        }




        return mensajeA
    }
    fun cifrarCadenaCesar(cadena: String): String{

        var abecedario="abcdefghijklmnñopqrstuvwxyz"
        var cadenaCifrada = ""
        val clave = 13
        cadena.forEach {
            if(it.isLetter()){
                if(abecedario.indexOf(it)+clave<27){
                    cadenaCifrada += abecedario[abecedario.indexOf(it)+clave]
                }else{
                    if (abecedario.indexOf(it)+clave>=27){
                        cadenaCifrada += abecedario[(abecedario.indexOf(it)+clave)-27]
                    }
                }
            }
        }
        return cadenaCifrada



    }


    fun comunicacion(){
        var respuesta:String =""
        var mensaje:String=""
        var cadena: String=""
        val abecedario= "abcdefghijklmnñopqrstuvwxyz"

        println("¿Hablamos con el un rato?")
        respuesta= readln()

        if(respuesta=="si" || respuesta=="Si")
            println("Dale hablemos con el, cuando te canses dile adios y ya")

        while(respuesta=="si" || respuesta=="Si") {

            mensaje = readln()
            mensaje = comprobarMensaje(mensaje)

            when(this.raza){
                "Elfo"-> when (this.estadoVital) {
                    //Respuestas a los distintos mensajes (mensajes controlados en fun comprobarMensaje)
                    "Adolescente" -> when (mensaje) {
                        "¿como estas?" -> {
                            cadena="De lujo"
                            println(cifrarCadenaCesar(cadena))

                        }
                        "grito" -> {
                            cadena="Eh relajate"
                            println(cifrarCadenaCesar(cadena))

                        }
                        "preguntaGrito" ->{
                            cadena="Tranqui se lo que hago"
                            println(cifrarCadenaCesar(cadena))

                        }
                        "nombre" -> {
                            cadena="¿Que pasa?"
                            println(cifrarCadenaCesar(cadena))

                        }
                        "adios" -> {
                            cadena="Adios"
                            println(cifrarCadenaCesar(cadena))
                            respuesta = "no"
                        }

                        else -> {

                            cadena="Yo que se"
                            println(cifrarCadenaCesar(cadena))
                        }
                    }

                    "Adulto" -> when (mensaje) {
                        "¿como estas?" -> println("En la flor de la vida, pero me empieza a doler la espalda")
                        "grito" -> println("No me levantes la voz mequetrefe")
                        "preguntaGrito" -> println("Estoy buscando la mejor solución")
                        "nombre" -> println("¿Necesitas algo?")
                        "adios" -> {
                            println("Adios")
                            respuesta = "no"
                        }

                        else -> {
                            println("No sé de qué me estás hablando")
                        }


                    }

                    "Anciano" -> when (mensaje) {
                        "¿como estas?" -> println("No me puedo mover")
                        "grito" -> println("Háblame más alto que no te escucho")
                        "preguntaGrito" -> println("Que no te escucho!")
                        "nombre" -> println("Las 5 de la tarde")
                        "adios" -> {
                            println("Adios")
                            respuesta = "no"
                        }

                        else -> {
                            println("En mis tiempos esto no pasaba")
                        }


                    }


                }
                "Goblin"-> when (this.estadoVital) {
                    //Respuestas a los distintos mensajes (mensajes controlados en fun comprobarMensaje)
                    "Adolescente" -> when (mensaje) {
                        "¿como estas?" -> println("De lujo")
                        "grito" -> println("Eh relajate")
                        "preguntaGrito" -> println("Tranqui se lo que hago")
                        "nombre" -> println("¿Que pasa?")
                        "adios" -> {
                            println("Adios")
                            respuesta = "no"
                        }

                        else -> {
                            println("Yo que se")
                        }
                    }

                    "Adulto" -> when (mensaje) {
                        "¿como estas?" -> println("En la flor de la vida, pero me empieza a doler la espalda")
                        "grito" -> println("No me levantes la voz mequetrefe")
                        "preguntaGrito" -> println("Estoy buscando la mejor solución")
                        "nombre" -> println("¿Necesitas algo?")
                        "adios" -> {
                            println("Adios")
                            respuesta = "no"
                        }

                        else -> {
                            println("No sé de qué me estás hablando")
                        }


                    }

                    "Anciano" -> when (mensaje) {
                        "¿como estas?" -> println("No me puedo mover")
                        "grito" -> println("Háblame más alto que no te escucho")
                        "preguntaGrito" -> println("Que no te escucho!")
                        "nombre" -> println("Las 5 de la tarde")
                        "adios" -> {
                            println("Adios")
                            respuesta = "no"
                        }

                        else -> {
                            println("En mis tiempos esto no pasaba")
                        }


                    }


                }
                else-> {
                    when (this.estadoVital) {
                        //Respuestas a los distintos mensajes (mensajes controlados en fun comprobarMensaje)
                        "Adolescente" -> when (mensaje) {
                            "¿como estas?" -> println("De lujo")
                            "grito" -> println("Eh relajate")
                            "preguntaGrito" -> println("Tranqui se lo que hago")
                            "nombre" -> println("¿Que pasa?")
                            "adios" -> {
                                println("Adios")
                                respuesta = "no"
                            }

                            else -> {
                                println("Yo que se")
                            }
                        }

                        "Adulto" -> when (mensaje) {
                            "¿como estas?" -> println("En la flor de la vida, pero me empieza a doler la espalda")
                            "grito" -> println("No me levantes la voz mequetrefe")
                            "preguntaGrito" -> println("Estoy buscando la mejor solución")
                            "nombre" -> println("¿Necesitas algo?")
                            "adios" -> {
                                println("Adios")
                                respuesta = "no"
                            }

                            else -> {
                                println("No sé de qué me estás hablando")
                            }


                        }

                        "Anciano" -> when (mensaje) {
                            "¿como estas?" -> println("No me puedo mover")
                            "grito" -> println("Háblame más alto que no te escucho")
                            "preguntaGrito" -> println("Que no te escucho!")
                            "nombre" -> println("Las 5 de la tarde")
                            "adios" -> {
                                println("Adios")
                                respuesta = "no"
                            }

                            else -> {
                                println("En mis tiempos esto no pasaba")
                            }


                        }


                    }
                }
            }

        }

    }
}

fun main() {
    println("Personaje 1: ")
    val personaje1 = Personaje()
    //imprime el nombre y la clase del personaje
    personaje1.imprimir()

    println("--------------------")

    println("Personaje 2: ")
    val personaje2=Personaje()
    personaje2.clase="Mercader"
    personaje2.imprimir()

    println("Hora de comerciar")
    personaje1.llenarMochila()
    personaje1.mochila.objetos.forEach { println(it) }






}


