package com.example.covidcountcc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.covidcountcc.retrofit.ApiService
import com.example.covidcountcc.retrofit.MainModel
import ng.max.slideview.SlideView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                      setResponse(mainModel )
                  }
                }

                override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                    Toast.makeText(applicationContext,"Failure",Toast.LENGTH_SHORT).show()
                }

            })
    }

    private fun setResponse(mainModel: List<MainModel>){


    }
}