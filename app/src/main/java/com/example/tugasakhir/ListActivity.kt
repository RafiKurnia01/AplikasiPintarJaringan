package com.example.tugasakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasakhir.API.ApiConfig
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ListActivity : AppCompatActivity() {

    lateinit var bthome: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        bthome = findViewById(R.id.bthome)
        bthome.setOnClickListener {
            var intent = Intent(this, UtamaActivity::class.java)
            startActivity(intent)
        }
        val tarafi = findViewById<RecyclerView>(R.id.rvList)
        ApiConfig.getService().getApi().enqueue(object : retrofit2.Callback<ResponseApi>{
            override fun onResponse(call: Call<ResponseApi>, response: Response<ResponseApi>) {
                if (response.isSuccessful){
                    val responseApi = response.body()
                    val dataApi = responseApi?.data
                    val apiAdapter = ApiAdapter(dataApi)
                    tarafi.apply {
                        layoutManager = LinearLayoutManager(this@ListActivity)
                        setHasFixedSize(true)
                        apiAdapter.notifyDataSetChanged()
                        adapter = apiAdapter
                    }
                }

            }

            override fun onFailure(call: Call<ResponseApi>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })

    }

}