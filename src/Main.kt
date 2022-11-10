import kotlin.random.Random

class Item() {

    val id = Random.nextInt(1, 100)
    var peso = Random.nextInt(1, 10)
    var valor = Random.nextInt(10, 50)


}

class Mochila() {
    var pesoMaximo = 0
    var objetos = mutableListOf<Item>()

    //lenar el array objetos con objetos de la clase Item mientras el peso sea menos al peso maximo
    fun llenarMochila() {
        var cont = 0
        var pesoActual = 0
        while (pesoMaximo < 10) {
            objetos.add(Item())
            pesoMaximo += objetos.last().peso
            cont++
        }
    }

    fun mostrarMochila() {
        println("Peso maximo: $pesoMaximo")
        println("Objetos: ")
        objetos.forEach {
            println("Id:${it.id} Peso: ${it.peso} Valor: ${it.valor}")
        }
    }

    //coprobar que la mocila tiene el objeto
    fun tieneObjeto(id: Int): Boolean {
        objetos.forEach {
            if (it.id == id) {
                return true
            }
        }
        return false
    }


}

class Personaje() {
    var nombre: String = ""
    var estadoVital: String = ""
    var raza: String = ""
    var clase: String = ""
    var mochila = Mochila()

    //lista que contiene cuatro mapas de dos enteros
    var monedero: Map<String, Int> = mutableMapOf(
        "1" to 0,
        "5" to 0,
        "10" to 0,
        "25" to 0,
        "100" to 0
    )


    init {
        val posibilidadesEv = listOf<String>("Adolescente", "Adulto", "Anciano")
        val posibilidadesRa = listOf<String>("Elfo", "Humano", "Enano", "Goblin")
        val posibilidadesCl = listOf<String>("Mago", "Ladron", "Guerrero", "Berserker", "Mercader")
        val nombres = arrayOf("Jack", "John", "Jorge", "Juan", "Javier")


        nombre = nombres[Random.nextInt(0, 5)]


        var rI1 = Random.nextInt(posibilidadesEv.size)
        val estadoVR = posibilidadesEv[rI1]

        rI1 = Random.nextInt(posibilidadesRa.size)
        val razaR = posibilidadesRa[rI1]

        rI1 = Random.nextInt(posibilidadesCl.size)
        val claseR = posibilidadesCl[rI1]

        this.estadoVital = estadoVR
        this.raza = razaR
        this.clase = claseR
    }

    fun imprimir() {
        println("Nombre: " + this.nombre)
        println("Clase: " + this.clase)
        println("Raza: " + this.raza)
        println("Estado Vital: " + this.estadoVital)

    }

    fun comprobarMensaje(mensaje: String): String {
        var mensajeA: String = mensaje

//comletar la funcion con las comprobaciones de los mensajes.
        if (mensaje.equals(mensaje.uppercase()) && mensaje.contains("?")) {
            mensajeA = "preguntaGrito"
        } else {
            if (mensaje.equals(mensaje.uppercase())) {
                mensajeA = "grito"
            } else {
                if (mensaje.equals("¿Como estas?") || mensaje.equals("¿como estas?") || mensaje.equals("¿Cómo estás?") || mensaje.equals(
                        "¿cómo estás?"
                    )
                )
                    mensajeA = "¿como estas?"
                else
                    if (mensaje.equals(this.nombre))
                        mensajeA = "nombre"
                    else {
                        if (mensaje.equals("adiós") || mensaje.equals("Adiós") || mensaje.equals("adios") || mensaje.equals(
                                "Adios"
                            )
                        )
                            mensajeA = "adios"
                    }
            }
        }




        return mensajeA
    }

    fun cifrarCadenaCesar(cadena: String): String {

        var abecedario = "abcdefghijklmnñopqrstuvwxyz"
        var cadenaCifrada = ""
        val clave = 13
        cadena.forEach {
            if (it.isLetter()) {
                if (abecedario.indexOf(it) + clave < 27) {
                    cadenaCifrada += abecedario[abecedario.indexOf(it) + clave]
                } else {
                    if (abecedario.indexOf(it) + clave >= 27) {
                        cadenaCifrada += abecedario[(abecedario.indexOf(it) + clave) - 27]
                    }
                }
            }
        }
        return cadenaCifrada


    }

    fun comunicacion() {
        var respuesta: String = ""
        var mensaje: String = ""
        var cadena: String = ""
        val abecedario = "abcdefghijklmnñopqrstuvwxyz"

        println("¿Hablamos con el un rato?")
        respuesta = readln()

        if (respuesta == "si" || respuesta == "Si")
            println("Dale hablemos con el, cuando te canses dile adios y ya")

        while (respuesta == "si" || respuesta == "Si") {

            mensaje = readln()
            mensaje = comprobarMensaje(mensaje)

            when (this.raza) {
                "Elfo" -> when (this.estadoVital) {
                    //Respuestas a los distintos mensajes (mensajes controlados en fun comprobarMensaje)
                    "Adolescente" -> when (mensaje) {
                        "¿como estas?" -> {
                            cadena = "De lujo"
                            println(cifrarCadenaCesar(cadena))

                        }

                        "grito" -> {
                            cadena = "Eh relajate"
                            println(cifrarCadenaCesar(cadena))

                        }

                        "preguntaGrito" -> {
                            cadena = "Tranqui se lo que hago"
                            println(cifrarCadenaCesar(cadena))

                        }

                        "nombre" -> {
                            cadena = "¿Que pasa?"
                            println(cifrarCadenaCesar(cadena))

                        }

                        "adios" -> {
                            cadena = "Adios"
                            println(cifrarCadenaCesar(cadena))
                            respuesta = "no"
                        }

                        else -> {

                            cadena = "Yo que se"
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

                "Goblin" -> when (this.estadoVital) {
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

                else -> {
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


fun calculoJusto(Item: Item, Personaje: Personaje) {
    var precio = Item.valor

    var cociente = 0

    cociente = precio / 100

    if (cociente > 0) {
        println("De 100 te doy " + cociente)
        precio -= cociente * 100
        Personaje.monedero["100"]!! + cociente

    }

    cociente = precio / 50
    if (cociente > 0) {
        println("De 50 te doy " + cociente)
        precio -= cociente * 50
        Personaje.monedero["50"]!! + cociente
    }
    cociente = precio / 25
    if (cociente > 0) {
        println("De 25 te doy " + cociente)
        precio -= cociente * 25
        Personaje.monedero["25"]!! + cociente
    }
    cociente = precio / 10
    if (cociente > 0) {
        println("De 10 te doy " + cociente)
        precio -= cociente * 10
        Personaje.monedero["10"]!! + cociente
    }
    cociente = precio / 5
    if (cociente > 0) {
        println("De 5 te doy " + cociente)
        precio -= cociente * 5
        Personaje.monedero["5"]!! + cociente

    }
    cociente = precio / 1
    if (cociente > 0) {
        println("De 1 te doy " + cociente)
        precio -= cociente * 1
        Personaje.monedero["1"]!! + cociente
    }


}


fun main() {
    var cantidad: Int = 0
    var respuesta = mutableListOf<Item>()
    var aux: Int = 0



    println("Personaje 1: ")
    val personaje1 = Personaje()
    //imprime el nombre y la clase del personaje
    personaje1.imprimir()

    println("--------------------")

    println("Personaje 2: ")
    val personaje2 = Personaje()
    personaje2.clase = "Mercader"
    personaje2.imprimir()
    println("--------------------")

    println("Hora de comerciar.")
    println("Estos son los objetos que ofrece " + personaje1.nombre + ":")
    println()

    personaje1.mochila.llenarMochila()
    //imprime los objetos que tiene el personaje
    personaje1.mochila.mostrarMochila()

    println()
    println("Ahora te toca decidir que objetos deseas intercambiar:")
    println("Introduce el numero de objetos que deseas:")
    cantidad = readLine()!!.toInt()

    while (cantidad > personaje1.mochila.objetos.size) {
        println("No puedes intercambiar mas objetos de los que tienes")
        println("Introduce el numero de objetos que deseas:")
        cantidad = readLine()!!.toInt()
    }


    for (i in 1..cantidad) {
        println("Introduce la ID del objeto $i:")
        aux = readln().toInt()
        while (personaje1.mochila.tieneObjeto(aux) == false) {
            println("No tienes ese objeto")
            println("Introduce la ID del objeto $i:")
            aux = readln().toInt()

        }
        personaje1.mochila.objetos.forEach {
            if (it.id == aux) {
                respuesta.add(it)
            }
        }

    }
    respuesta.forEach {
        println("Has elegido el objeto " + it.id)
        val ind = personaje1.mochila.objetos.indexOf(it)
        calculoJusto(personaje1.mochila.objetos[ind], personaje1)

    }
    println("Tu monedero queda asi")
    println(personaje1.monedero)

}















