package com.example.ch17_database_test

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//데이터베이스 만드는 역할
class DBHelper(context: Context): SQLiteOpenHelper(context, "testdb2", null, 1) {
    //테이블 만드는 과정.
    // 해당 디비의 내용은 파일로 저장
    // data->data->패키지명->databases
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table user (" +
                "_id integer primary key autoincrement," +
                "name not null,"+
                "age not null)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}
//
//class DBHelper(context: Context): SQLiteOpenHelper(context, "testdb", null, 1) {
//    override fun onCreate(p0: SQLiteDatabase?) {
//        p0?.execSQL("create table TODO_TB (" +
//                "_id integer primary key autoincrement," +
//                "todo not null)")
//    }
//
//    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
//
//    }
//}