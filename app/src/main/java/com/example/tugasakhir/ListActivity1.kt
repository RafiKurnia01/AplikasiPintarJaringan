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

class ListActivity1 : AppCompatActivity() {

    lateinit var bthome: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list1)

        bthome = findViewById(R.id.bthome)
        bthome.setOnClickListener {
            var intent = Intent(this, UtamaActivity::class.java)
            startActivity(intent)
        }
        val tarafi = findViewById<RecyclerView>(R.id.rvList)
        ApiConfig.getService().getApi2().enqueue(object : retrofit2.Callback<ResponseApi2>{
            override fun onResponse(call: Call<ResponseApi2>, response: Response<ResponseApi2>) {
                if (response.isSuccessful){
                    val responseApi = response.body()
                    val dataApi = responseApi?.data
                    val apiAdapter = ApiAdapter(dataApi)
                    tarafi.apply {
                        layoutManager = LinearLayoutManager(this@ListActivity1)
                        setHasFixedSize(true)
                        apiAdapter.notifyDataSetChanged()
                        adapter = apiAdapter
                    }
                }

            }

            override fun onFailure(call: Call<ResponseApi2>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })

    }

}