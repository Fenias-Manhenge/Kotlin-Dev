package my.kotlindev.helloworld

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChangeText = findViewById<Button>(R.id.btnXI)
        val  txtChangeT = findViewById<TextView>(R.id.txtHi)

        btnChangeText.setOnClickListener{
            txtChangeT.text = "We are Ximix"
        }
    }
}