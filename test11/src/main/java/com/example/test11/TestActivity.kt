package com.example.test11

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test11.databinding.ActivityTestBinding
import com.example.test11.databinding.TestitemBinding

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datas = mutableListOf<String>()
        datas.add("메뉴1: 햄버거")
        datas.add("메뉴2: 돼지국밥")
        datas.add("메뉴3: 중국집")
        datas.add("메뉴4: 대독장")

//        val layoutManager2 = GridLayoutManager(this, 2,
//            GridLayoutManager.VERTICAL, false)

        binding.recyclerView2.layoutManager = LinearLayoutManager(this)
        // 배경 이미지 추가 , 로고 추가, 각 항목 디자인 변경
        binding.recyclerView2.addItemDecoration(MyDecoration(this))
        //binding.recyclerView2.layoutManager = layoutManager2
        binding.recyclerView2.adapter = MyAdapter(datas)
        //(binding.recyclerView2.adapter as MyAdapter).notifyDataSetChanged()
//        binding.recyclerView2.addItemDecoration(
//            DividerItemDecoration(
//                this,
//                LinearLayoutManager.VERTICAL
//            )
//        )
    }

    class MyViewHolder(val binding: TestitemBinding) : RecyclerView.ViewHolder(binding.root)

    class MyAdapter(val datas: MutableList<String>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun getItemCount(): Int {
            Log.d("lsy", "init datas size: ${datas.size}")
            return datas.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            MyViewHolder(TestitemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            Log.d("kkang", "onBindViewHolder : $position")
            val binding = (holder as MyViewHolder).binding
            //뷰에 데이터 출력
            binding.itemData2.text = datas[position]

            //뷰에 이벤트 추가
            binding.itemRoot2.setOnClickListener {
                Log.d("kkang", "item root click : $position")
            }
        }


    }
    class MyDecoration(val context: Context): RecyclerView.ItemDecoration() {
        override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDraw(c, parent, state)
            c.drawBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.cat), 0f,0f,null);
        }

        override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDrawOver(c, parent, state)
            // 이미지 중앙 배치하는 샘플 코드
            //뷰 사이즈 계산
            val width = parent.width
            val height = parent.height
            //이미지 사이즈 계산
            val dr: Drawable? = ResourcesCompat.getDrawable(context.getResources(), R.drawable.kbo, null)
            val drWidth = dr?.intrinsicWidth
            val drHeight = dr?.intrinsicHeight
            //이미지가 그려질 위치 계산
            val left = width / 2 - drWidth?.div(2) as Int
            val top = height / 2 - drHeight?.div(2) as Int
            c.drawBitmap(
                BitmapFactory.decodeResource(context.getResources(), R.drawable.kbo),
                left.toFloat(),
                top.toFloat(),
                null
            )

        }

        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)
            val index = parent.getChildAdapterPosition(view) + 1

            if (index % 3 == 0) //left, top, right, bottom
                outRect.set(10, 10, 10, 60)
            else
                outRect.set(10, 10, 10, 0)

            view.setBackgroundColor(Color.LTGRAY)
            ViewCompat.setElevation(view, 20.0f)

        }
    }
}