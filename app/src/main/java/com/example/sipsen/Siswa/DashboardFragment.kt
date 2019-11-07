package com.example.sipsen.Siswa


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sipsen.R
import com.example.sipsen.room.AppDatabase

/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : Fragment() {
    private var db: AppDatabase? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        db= AppDatabase.getAppDataBase(view.context)

        Log.d("test", db?.userDao()?.getUser().toString())

        return view
    }

    companion object {
        fun newInstance(): DashboardFragment{
            val fragment = DashboardFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}
