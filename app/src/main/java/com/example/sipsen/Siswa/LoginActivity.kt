package com.example.sipsen.Siswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.sipsen.Api.ApiMain
import com.example.sipsen.LoginGuruActivity
import com.example.sipsen.LoginWaliActivity
import com.example.sipsen.MainActivity
import com.example.sipsen.R
import com.example.sipsen.Response.Respone
import com.example.sipsen.room.AppDatabase
import com.example.sipsen.room.User
import com.example.sipsen.room.UserDAO
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private var db: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        db= AppDatabase.getAppDataBase(this)

        btnLoginSiswa.setOnClickListener{
            val nis = etNis.text.toString()
            val password = etPassword.text.toString()

            val call = ApiMain().services.login(nis, password)
            call.enqueue(object : Callback<Respone>{
                override fun onFailure(call: Call<Respone>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Respone>, response: Response<Respone>) {
                    if (response.isSuccessful){
                        if(response.body()?.value == 1){
                            val user = User(1, nis, password, "1")
                            db?.userDao()?.insertUser(user)
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            finish()
                        }else{
                            Toast.makeText(this@LoginActivity, response.body()?.value.toString(), Toast.LENGTH_LONG).show()
                        }
                    }
                }

            })

        }

        btnIntentLoginGuru.setOnClickListener{
            startActivity(Intent(this, LoginGuruActivity::class.java))
        }

        btnIntentLoginWali.setOnClickListener{
            startActivity(Intent(this, LoginWaliActivity::class.java))
        }
    }


}
