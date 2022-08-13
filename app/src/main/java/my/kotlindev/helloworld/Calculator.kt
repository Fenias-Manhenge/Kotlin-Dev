package my.kotlindev.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Calculator: AppCompatActivity() {

    private var txtInput: TextView? = null
    private lateinit var txtRes: TextView
    private var lastNumber: Boolean = false
    private var dot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        txtInput = findViewById(R.id.txtOperations)
        txtRes = findViewById(R.id.txtResults)
    }

    fun onDigit(view: View){
        //txtInput?.text = ""
        txtInput?.append((view as Button).text)
        lastNumber = true
        dot = false
    }

    fun onClear(view: View){
        txtInput?.text = ""
        txtRes.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
        txtRes.alpha = 0.3F
        txtRes.text = "result"
    }

    fun onDecimal(view: View){
        if (lastNumber and !dot){
            txtInput?.append(".")
            lastNumber = false
            dot = true
        }
    }

    fun onOperator(view: View){
        txtInput?.text.let {
            if (lastNumber and !onOperatorAdded(it.toString())){
                txtInput?.append((view as Button).text)
                lastNumber = false
                dot = false
            }
        }
    }

    fun onOperatorAdded(value: String): Boolean{
        return if (value.contains("-")){
            false
        } else{
            value.contains("/") or value.contains("*") or value.contains("+")
                    || value.contains("-")
        }
    }

    fun onEqual(view: View){
        if (lastNumber){
            try {
                charOperator('-', txtRes)
                charOperator('+', txtRes)
                charOperator('*', txtRes)
                charOperator('/', txtRes)
            }catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    fun dotZero(output: String): String{
        var value = output
        if (output.contains(".0"))
            value = output.substring(0, output.length-2)

        return value
    }

    fun charOperator(char: Char, result: TextView){
        var text = txtInput?.text.toString()
        var prefix = ""

        if(text.startsWith(char)){
            prefix = "-"
            text = text.substring(1)
        }

        if (text.contains(char)){
            val split = text.split(char)
            var one = split[0]
            val two = split[1]

            if (prefix.isNotEmpty()) {
                one = prefix + one
            }

            txtRes.textAlignment = View.TEXT_ALIGNMENT_TEXT_END
            txtRes.alpha = 1F

            when(char){
                '-' -> result.text = dotZero ((one.toLong() - two.toLong()).toString())
                '+' -> result.text = dotZero ((one.toLong() + two.toLong()).toString())
                '*' -> result.text = dotZero ((one.toLong() * two.toLong()).toString())
                '/' -> result.text = dotZero ((one.toLong() / two.toLong()).toString())
                else-> print("oi")
            }
            txtInput?.text = ""
        }
    }
}