package com.example.sipsen.Siswa


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sipsen.R
import com.example.sipsen.room.AppDatabase
import kotlinx.android.synthetic.main.fragment_akun_siswa.*
import kotlinx.android.synthetic.main.fragment_akun_siswa.view.*

/**
 * A simple [Fragment] subclass.
 */
class AkunSiswaFragment : Fragment() {
    private var db: AppDatabase? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_akun_siswa, container, false)
        db= AppDatabase.getAppDataBase(view.context)
        view.btnLogoutSiswa.setOnClickListener{
            val user = db?.userDao()?.getUser()
            db?.userDao()?.deleteUser(user!!)

            startActivity(Intent(view.context, LoginActivity::class.java))
            activity?.finish()
        }

        return view
    }


}
