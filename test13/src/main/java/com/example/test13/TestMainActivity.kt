package com.example.test13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.test13.databinding.ActivityDetailBinding
import com.example.test13.databinding.ActivityTestMainBinding

class TestMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_main)


        val binding = ActivityTestMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //메인 액티비티에서 넘어온 값을, 값을 가지고 오는 부분.
        val data1 = intent.getStringExtra("id")
        val data2 = intent.getStringExtra("pw")

        binding.rid.text = "id: $data1, pw: $data2"

        }
    }
