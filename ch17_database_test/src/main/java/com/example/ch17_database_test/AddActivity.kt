package com.example.ch17_database_test

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.ch17_database_test.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId){
        R.id.menu_add_save ->{
            //add........................
            val inputData = binding.addEditView.text.toString()
            val inputData2 = binding.addEditView2.text.toString()
            val db = DBHelper(this).writableDatabase
            db.execSQL(
                "insert into user (name, age) values (?,?)",
                arrayOf<String>(inputData, inputData2)
            )
            db.close()
            //현재 입력 액티비티, 메인으로 돌아갈 때, name, age를 전달하는 부분
            val intent = intent
            intent.putExtra("name", inputData)
            intent.putExtra("age", inputData2)
            setResult(Activity.RESULT_OK, intent)
            finish()
            true
        }
        else -> true
    }
}