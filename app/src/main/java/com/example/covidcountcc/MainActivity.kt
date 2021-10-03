package com.example.covidcountcc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.covidcountcc.retrofit.ApiService
import com.example.covidcountcc.retrofit.MainModel
import ng.max.slideview.SlideView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var txt_positif: TextView
    private lateinit var txt_meninggal: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    override fun onStart() {
        super.onStart()
        getData()

    }


    private fun getData(){
        ApiService.endPoint.getdata()
            .enqueue(object : Callback<List<MainModel>>{

                override fun onResponse(
                    call: Call<List<MainModel>>,
                    response: Response<List<MainModel>>
                ) {
                  if (response.isSuccessful){
                      val mainModel :List<MainModel> = response.body()!!
                      setResponse(mainModel)


                      mainModel.forEach {Log.e("MainActivity","sembuh ${it.sembuh}") }



                  }
                }

                override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                    Toast.makeText(applicationContext,"Failure",Toast.LENGTH_SHORT).show()
                }

            })
    }

     fun setResponse(mainModel: List<MainModel>){
         val response=mainModel[0]
         val txtsembuh:TextView = findViewById(R.id.txt_sembuh)
         val txt_meninggal:TextView = findViewById(R.id.txt_meninggal)
         val txt_positif:TextView = findViewById(R.id.txt_positif)

         txtsembuh.setText(response.sembuh)
         txt_meninggal.setText(response.meninggal)
         txt_positif.setText(response.positif)


    }
}


