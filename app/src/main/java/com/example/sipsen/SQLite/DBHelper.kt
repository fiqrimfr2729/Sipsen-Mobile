package com.example.sipsen.SQLite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DBHelper(context: Context) :
        SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION){
    override fun onCreate(p0: SQLiteDatabase?) {
        var sql = "CREATE TABLE `tb_siswa` (\n" +
                "  `id` int PRIMARY KEY,\n" +
                "  `NIS` varchar(50),\n" +
                "  `NISN` varchar(50),\n" +
                "  `nama` varchar(50),\n" +
                "  `jk` varchar(15),\n" +
                "  `id_kelas` int(11),\n" +
                "  `tgl_lahir` date,\n" +
                "  `no_hp` varchar(15),\n" +
                "  `email` varchar(50),\n" +
                "  `alamat` varchar(50),\n" +
                "  `nama_ayah` varchar(50),\n" +
                "  `nama_ibu` varchar(50),\n" +
                "  `id_wali` int(11),\n" +
                "  `id_fp` varchar(5),\n" +
                "  `password` varchar(255)\n" +
                ")"
        p0?.execSQL(sql)

//        sql = "CREATE TABLE `tb_guru` (\n" +
//                "  `NUPTK` varchar(50) NOT NULL,\n" +
//                "  `nama` varchar(50) NOT NULL,\n" +
//                "  `alamat` varchar(50) NOT NULL,\n" +
//                "  `no_hp` varchar(50) NOT NULL,\n" +
//                "  `email` varchar(100) NOT NULL,\n" +
//                "  `jk` varchar(5) NOT NULL,\n" +
//                "  `status_bk` varchar(5) NOT NULL,\n" +
//                "  `password` varchar(255) NOT NULL\n" +
//                ")"
//        p0?.execSQL(sql)


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    companion object {
        private val DB_NAME = "UsersDB"
        private val DB_VERSION = 1;
        private val TABLE_NAME = "users"
        private val ID = "id"
        private val FIRST_NAME = "FirstName"
        private val LAST_NAME = "LastName"
    }

}