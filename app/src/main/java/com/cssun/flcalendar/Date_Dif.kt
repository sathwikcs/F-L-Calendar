package com.cssun.flcalendar

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.*

class Date_Dif : AppCompatActivity() {
    private lateinit var startDatePicker: DatePicker
    private lateinit var endDatePicker: DatePicker
    private lateinit var calculateButton: Button

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_dif)

        startDatePicker = findViewById(R.id.start_date_picker)
        endDatePicker = findViewById(R.id.end_date_picker)
        calculateButton = findViewById(R.id.calculate_button)



        startDatePicker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            view.performHapticFeedback(HapticFeedbackConstants.CONFIRM)
        }

        endDatePicker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            view.performHapticFeedback(HapticFeedbackConstants.CONFIRM)
        }


        calculateButton.setOnClickListener {
            val startYear = startDatePicker.year
            val startMonth = startDatePicker.month
            val startDay = startDatePicker.dayOfMonth

            val endYear = endDatePicker.year
            val endMonth = endDatePicker.month
            val endDay = endDatePicker.dayOfMonth

            val startCalendar = Calendar.getInstance()
            startCalendar.set(startYear, startMonth, startDay)

            val endCalendar = Calendar.getInstance()
            endCalendar.set(endYear, endMonth, endDay)

            val diffInMillis = endCalendar.timeInMillis - startCalendar.timeInMillis
            val diffInDays = Math.abs(diffInMillis / (1000 * 60 * 60 * 24))

            val message = "The difference between the selected dates is $diffInDays days."
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}