package my.kotlindev.helloworld

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class AgeDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.age_layout)

        findViewById<Button>(R.id.btnSelectDate).setOnClickListener {
            myDatetime()
            Toast.makeText(this, "It's Working", Toast.LENGTH_LONG).show()
        }
    }

    @SuppressLint("SetTextI18n")
     private fun myDatetime(){
        val myCalendar = Calendar.getInstance()
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val month = myCalendar.get(Calendar.MONTH)
        val year = myCalendar.get(Calendar.YEAR)

        findViewById<TextView>(R.id.currentDate).text = "$day/$month/$year"

        val maxDate = DatePickerDialog(this, {
                _, myYear, myMonth, myDay ->
            Toast.makeText(this, "DatePicker work", Toast.LENGTH_LONG).show()

            val selectedDate = "$myDay/${myMonth+1}/$myYear"

            findViewById<TextView>(R.id.showSelectedDate).text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val selectedDateToMinutes = sdf.parse(selectedDate)!!.time / 60000

            val sysCurrentDate = sdf.parse(sdf.format(System.currentTimeMillis()))!!.time / 60000

            val  differenceMinutes = sysCurrentDate - selectedDateToMinutes

            findViewById<TextView>(R.id.ageMinutes).text = "$differenceMinutes"
        }, year, month, day)

        maxDate.datePicker.maxDate = Date().time - 86400000
        maxDate.show()
    }
}