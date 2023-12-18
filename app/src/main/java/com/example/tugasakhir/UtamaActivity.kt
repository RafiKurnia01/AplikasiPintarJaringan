package com.example.tugasakhir

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout

class UtamaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utama)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        if (Build.VERSION.SDK_INT >= 21) {
            MainActivity.setWindowFlag(
                this,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                false
            )
            window.statusBarColor = Color.TRANSPARENT
        }

        var btnlogout : ImageView = findViewById(R.id.btnlogout)
        btnlogout.setOnClickListener {
            intent = Intent(this, LogoutActivity::class.java)
            startActivity(intent)
        }

        var btkategori1 : LinearLayout = findViewById(R.id.btkategori1)
        var btkategori2 : LinearLayout = findViewById(R.id.btkategori2)
        var btkategori3 : LinearLayout = findViewById(R.id.btkategori3)
        btkategori1.setOnClickListener {
            var intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        btkategori2.setOnClickListener {
            var intent = Intent(this, ListActivity1::class.java)
            startActivity(intent)
        }
        btkategori3.setOnClickListener {
            var intent = Intent(this, ListActivity2::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
            val activityWindow = activity.window
            val layoutParams = activityWindow.attributes
            if (on) {
                layoutParams.flags = layoutParams.flags or bits
            } else {
                layoutParams.flags = layoutParams.flags and bits.inv()
            }
            activityWindow.attributes = layoutParams
        }
    }
}