package com.example.test8_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import com.example.test8_2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d("lsy",
                    "Touch down event x: ${event.x}, rawX: ${event.rawX}")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("lsy",
                    "Touch up event x: ${event.x}, rawX: ${event.rawX}")
            }
        }

        return super.onTouchEvent(event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
//            KeyEvent.KEYCODE_BACK -> Log.d("lsy", "BACK Button을 눌렀네요")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("lsy", "Volume Up 키를 눌렀네요")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("lsy", "Volume Down 키를 눌렀네요")
            KeyEvent.KEYCODE_0 -> Log.d("lsy", "0번 키를 눌렀네요")
            KeyEvent.KEYCODE_HOME -> Log.d("lsy", "Home 키를 눌렀네요")
            KeyEvent.KEYCODE_MOVE_HOME -> Log.d("lsy", "Home 키를 눌렀네요")
            KeyEvent.KEYCODE_A -> Log.d("lsy", "A 키를 눌렀네요")
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {
        Log.d("lsy", "Back키를 눌렀네요")
    }
}