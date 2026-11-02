package com.example.ethiopiasalarycalculator

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.gross_salary_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- TAB LOGIC ---

        // 1. Find the Tab TextViews
        val tabNet = findViewById<TextView>(R.id.tabNet)
        val tabGross = findViewById<TextView>(R.id.tabGross)
        val tabOvertime = findViewById<TextView>(R.id.tabOvertime)

        // 2. Find the sections you want to show/hide
        // Make sure these IDs exist in your XML!
        val grossInputContainer = findViewById<View>(R.id.grossInputContainer)
        val lblGrossSalary = findViewById<View>(R.id.lblGrossSalary)

        // Note: If you have a container for Overtime inputs, add its ID here:
        // val overtimeContainer = findViewById<View>(R.id.overtimeInputContainer)

        // 3. Set up Click Listeners
        tabGross.setOnClickListener {
            // Show Gross, Hide others
            grossInputContainer.visibility = View.VISIBLE
            lblGrossSalary.visibility = View.VISIBLE

            // Change Colors
            tabGross.setTextColor(Color.WHITE)
            tabGross.setBackgroundResource(R.drawable.bg_tab_selected)

            tabNet.setTextColor(Color.parseColor("#AAAAAA"))
            tabNet.setBackgroundResource(0)

            tabOvertime.setTextColor(Color.parseColor("#AAAAAA"))
            tabOvertime.setBackgroundResource(0)
        }

        tabNet.setOnClickListener {
            // Show Net, Hide others (You will need to create a Net layout section)
            grossInputContainer.visibility = View.GONE
            lblGrossSalary.visibility = View.GONE

            // Change Colors
            tabNet.setTextColor(Color.WHITE)
            tabNet.setBackgroundResource(R.drawable.bg_tab_selected)

            tabGross.setTextColor(Color.parseColor("#AAAAAA"))
            tabGross.setBackgroundResource(0)

            tabOvertime.setTextColor(Color.parseColor("#AAAAAA"))
            tabOvertime.setBackgroundResource(0)
        }

        tabOvertime.setOnClickListener {
            // Show Overtime, Hide others
            grossInputContainer.visibility = View.GONE
            lblGrossSalary.visibility = View.GONE

            // Change Colors
            tabOvertime.setTextColor(Color.WHITE)
            tabOvertime.setBackgroundResource(R.drawable.bg_tab_selected)

            tabNet.setTextColor(Color.parseColor("#AAAAAA"))
            tabNet.setBackgroundResource(0)

            tabGross.setTextColor(Color.parseColor("#AAAAAA"))
            tabGross.setBackgroundResource(0)
        }
    }
}