package com.example.tugasakhir

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.WindowManager
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.util.*
import android.view.Window

class ListActivity : AppCompatActivity() {

    private lateinit var recycleview : RecyclerView
    private lateinit var komponenList : ArrayList<Komponen>
    private lateinit var komponenadapter : komponenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        assert(supportActionBar != null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        recycleview = findViewById(R.id.rvList)
        recycleview.setHasFixedSize(true)
        recycleview.layoutManager = LinearLayoutManager(this)

        komponenList = ArrayList()

        komponenList.add(Komponen(R.drawable.router, "Router"))
        komponenList.add(Komponen(R.drawable.hub, "Hub"))

        komponenadapter = komponenAdapter(komponenList)
        recycleview.adapter = komponenadapter
    }

    companion object{
        fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
            val win: Window = activity.window
            val winParams: WindowManager.LayoutParams = win.attributes
            if (on) {
                winParams.flags = winParams.flags or bits
            } else {
                winParams.flags = winParams.flags and bits.inv()
            }
            win.attributes = winParams
        }
    }

}