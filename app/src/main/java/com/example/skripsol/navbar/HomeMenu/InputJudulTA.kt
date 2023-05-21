package com.example.skripsol.navbar.HomeMenu



import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.skripsol.FunctionHelper.Get
import com.example.skripsol.R

import com.google.android.material.textfield.TextInputLayout


class InputJudulTA : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_judul_ta_screen)

        val textInputJudulTA: TextInputLayout = findViewById(R.id.InputLayout_input_judul_ta)
        val editTextJudulTA: EditText = findViewById(R.id.EditText_input_judul_ta)

        val inputLayoutAbstrakTA: TextInputLayout = findViewById(R.id.InputLayout_abstrak_ta)
        val editTextAbstrakTA: EditText = findViewById(R.id.EditText_abstrak_ta)

        setupDropDownPilihDosenPembimbing()







//       Scroll Function On Text
        scrollAbleEdittext(editTextAbstrakTA)
        findViewById<ImageView>(R.id.btn_back_input_judul_ta).setOnClickListener {
            Get.back(this)
        }

    }


    private fun scrollAbleEdittext(editText: EditText) {
        editText.setOnTouchListener(OnTouchListener { v, event ->
            if (editText.hasFocus()) {
                v.parent.requestDisallowInterceptTouchEvent(true)
                when (event.action and MotionEvent.ACTION_MASK) {
                    MotionEvent.ACTION_SCROLL -> {
                        v.parent.requestDisallowInterceptTouchEvent(false)
                        return@OnTouchListener true
                    }
                }
            }
            false
        })
    }

    private fun setupDropDownPilihDosenPembimbing(autoCompleteTextView: AutoCompleteTextView) {
        val items = listOf(
            "Ery Julev Setiawan",
            "Aji Seto",
            "Ratih Ayuninghemi",
            "Hermawan",
            "I Gede Wiryawan"
        )
        autoCompleteTextView.setDropDownBackgroundDrawable(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.filter_spinner_dropdown_bg,
                null
            )
        )
        val adapter = ArrayAdapter(this, R.layout.input_judul_ta_list_item, items)

        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, position, id ->
                val itemSelected = adapterView.getItemAtPosition(position)
                Toast.makeText(this, "Item $itemSelected", Toast.LENGTH_SHORT).show()
            }
    }

    private fun setupDropDownPilihDosenPembimbing() {
        val pilihDosenPembimbing1: AutoCompleteTextView = findViewById(R.id.pilih_dosen_pembimbing1)
        val pilihDosenPembimbing2: AutoCompleteTextView = findViewById(R.id.pilih_dosen_pembimbing2)
        val pilihDosenPembimbing3: AutoCompleteTextView = findViewById(R.id.pilih_dosen_pembimbing3)

        setupDropDownPilihDosenPembimbing(pilihDosenPembimbing1)
        setupDropDownPilihDosenPembimbing(pilihDosenPembimbing2)
        setupDropDownPilihDosenPembimbing(pilihDosenPembimbing3)
    }





}