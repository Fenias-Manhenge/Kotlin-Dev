package my.kotlindev.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList

fun main(){

    var android: String = "Android Masterclass"

    var myFloat: Float = 13.37F

    val pi: Double = 3.14159265358979

    var myLong: Long = 18881234567

    var age = 18

    when(age){
        in 18..40 -> print("Jovem")
        in 40..60 -> print("Velho")
        in 60..100 -> print("idoso")
        else -> print("Ainda crianca")
    }
    println()

    var start = 100
    while (0 <= start){
        print("$start, ")
        start -= 2
    }

    for (i in 0.until(1000)){
            if (i > 900){
                print("It's over 900!!!")
                break
            }
    }

    var humidityLevel = 80
    var humidity = "humid"

    while (humidity == "humid"){
        humidityLevel -= 5
        println("humidity decreased")

        if (humidityLevel < 60){
            println("It's comfy now")
            humidity = "comfy"
        }
    }

    fun media(a: Int, b: Int): Int{
        return a*b
    }

    println(Operadores().soma(5.0, 5.0))
    println(media(2,2))


    var test : String? = "Junior Fenias"
    //test = null

    test?.let { print(it.uppercase()) }


    val numbers = ArrayList<Double>()
    numbers.addAll(listOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0))

    var soma = 0.0
    for (num in numbers) {
        soma += num
    }
    print("Media: ${soma/numbers.size}")
}

class Age: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.count_peaple)
    }
}