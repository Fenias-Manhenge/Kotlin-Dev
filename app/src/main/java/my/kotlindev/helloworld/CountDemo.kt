package my.kotlindev.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.time.Duration

class CountDemo:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.count_peaple)

        var count = 0
        val btnCounting = findViewById<Button>(R.id.btnCount)

        btnCounting.setOnClickListener{
            btnCounting.text = "Counting"
            count = count + 1
            findViewById<TextView>(R.id.txtNumber).text = count.toString()
        }
        Toast.makeText(this, "Hi, Bustamont", Toast.LENGTH_LONG).show()
    }
}