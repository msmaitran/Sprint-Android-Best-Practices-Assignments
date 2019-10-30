package com.lambdaschool.androidcrashreportingmtt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ArithmeticException
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_crash_one.setOnClickListener {
            dropBreadcrumb("MainActivity", "crashOneListener",  "RuntimeException Crash")
            throw RuntimeException()
        }

        btn_crash_two.setOnClickListener {
            dropBreadcrumb("MainActivity", "crashTwoListener", "Exception Crash" )
            throw Exception()
        }

        btn_crash_three.setOnClickListener {
            dropBreadcrumb("MainActivity", "crashThreeListener", "IllegalArgumentException Crash")
            throw IllegalArgumentException()
        }

        btn_crash_four.setOnClickListener {
            dropBreadcrumb("MainActivity", "crashFourListener","ArithmeticException Crash")
            throw ArithmeticException()
        }
    }
}
