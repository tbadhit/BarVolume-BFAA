package com.tbadhit.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.tbadhit.barvolume.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    Before use View Binding
//    private lateinit var edtWidth: EditText
//    private lateinit var edtHeight: EditText
//    private lateinit var edtLength: EditText
//    private lateinit var btnCalculate: Button
//    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

//  Use View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.tvResult.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Before use View Binding
//        edtWidth = findViewById(R.id.edt_width)
//        edtHeight = findViewById(R.id.edt_height)
//        edtLength = findViewById(R.id.edt_length)
//        btnCalculate = findViewById(R.id.btn_calculate)
//        tvResult = findViewById(R.id.tv_result)

        binding.btnCalculate.setOnClickListener {
            val inputLength = binding.edtLength.text.toString().trim()
            val inputWidth = binding.edtWidth.text.toString().trim()
            val inputHeight = binding.edtHeight.text.toString().trim()

            var isEmptyFields = false

            if (inputLength.isEmpty()) {
                isEmptyFields = true
                binding.edtLength.error = "Please enter field"
            }

            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                binding.edtWidth.error = "Please enter field"
            }

            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                binding.edtHeight.error = "Please enter field"
            }

            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                binding.tvResult.text = volume.toString()
            }
        }

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            binding.tvResult.text = result
        }
    }
}