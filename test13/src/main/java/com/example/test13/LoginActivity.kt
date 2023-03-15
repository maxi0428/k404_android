package com.example.test13

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test13.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.login.setOnClickListener {
            val input: String = binding.id.getText().toString()
            val input2: String = binding.pw.getText().toString()
            val intent: Intent = Intent(this, TestMainActivity::class.java)
            // 데이터를 같이 전달.
            intent.putExtra("id", input )
            intent.putExtra("pw", input2)
            startActivity(intent)
        }
    }
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        val id1 = savedInstanceState.getString("id")
//        val pw1 = savedInstanceState.getString("pw")
//
//        binding.id.hint = "$id1"
//        binding.pw.hint = "$pw1"
//
//    }

}