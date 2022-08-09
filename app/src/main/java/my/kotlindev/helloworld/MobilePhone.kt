package my.kotlindev.helloworld

import java.lang.reflect.Constructor

class MobilePhone(osName: String, brand: String, model: String){
    init {
        println("The phone $model from $brand uses $osName as its Operating System")
    }

    var battery = 0
        set(value) {
            field = if(value in 0..100) value else throw  IllegalArgumentException()
        }

    constructor(osName: String, brand: String, model: String, battery: Int)
        :this(osName, brand, model){
        this.battery = battery
    }

    fun chargeButtery(charge: Int){
        println("The phone had $battery and was charged $charge% and have now ${battery + charge}")
    }
}

    fun main(args: Array<String>){
        MobilePhone("Android", "Samsung", "S21 FE", 30).chargeButtery(35)
    }
