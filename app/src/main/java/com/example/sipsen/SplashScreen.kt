package com.example.sipsen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.room.Room
import com.example.sipsen.Siswa.LoginActivity
import com.example.sipsen.room.AppDatabase
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    private var db: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        db= AppDatabase.getAppDataBase(this)

        avi.setIndicator("BallClipRotateMultipleIndicator")

        val rn: Runnable
        if(db?.userDao()?.getUser() == null){
            rn = Runnable {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }else{
            rn = Runnable {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        val handler: Handler = Handler()
        handler.postDelayed(rn, 2000)

    }
}
