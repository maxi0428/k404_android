package com.example.test8_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import com.example.test8_2.databinding.ActivityMain2Binding



class MainActivity2 : AppCompatActivity() , CompoundButton.OnCheckedChangeListener {

    class MyEventHandler : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            Log.d("lsy", "체크박스 클릭")
        }
    }
    override  fun onCheckedChanged(buttonView: CompoundButton?, isChecked:Boolean){
        Log.d("lsy", "체크박스 클릭")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        var state: Int = 0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        // 3번째 sam 기법(single)
        binding.checkbox.setOnCheckedChangeListener {
                comButton, b ->
            if(state == 0) {
                binding.button.visibility = View.INVISIBLE
                state = 1
            }else {
                binding.button.visibility = View.VISIBLE
                state = 0
            }
        }

        binding.button.setOnLongClickListener {
                img ->
                if(state == 0) {
                    binding.img.visibility = View.INVISIBLE
                    state = 1
                }else {
                    binding.img.visibility = View.VISIBLE
                    state = 0
                }
            true
            }

        }


        // 두번째 방법
//        binding.checkbox.setOnCheckedChangeListener(this)


//        val test = MyEventHandler()
//        test.onCheckedChanged(binding.checkbox,p1 = true)

        // 첫번째 방법
//        binding.checkbox.setOnCheckedChangeListener(MyEventHandler())


    }


