package com.example.coditasassignment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.c.kotlinmall.Retrofit.ApiInterface
import com.example.bsptechnologies.Models.MainResults
import com.example.bsptechnologies.R
import com.mindorks.placeholderview.SwipeDecor
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.SwipeViewBuilder
import com.technomatics.sthalmatrimony.TinderCard
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var apiInterface: ApiInterface? = null
    var mSwipeView: SwipePlaceHolderView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiInterface = RetrofitClient.getClient(this)!!.create(ApiInterface::class.java)
        findIds()
        getResults()
    }

    private fun findIds() {
        mSwipeView = findViewById(R.id.swipeView)
        mSwipeView?.getBuilder<SwipePlaceHolderView, SwipeViewBuilder<SwipePlaceHolderView>>()?.setDisplayViewCount(3)?.setSwipeDecor(
            SwipeDecor().setPaddingTop(20).setRelativeScale(0.01f)
                .setSwipeInMsgLayoutId(R.layout.swipe_in_view)
                .setSwipeOutMsgLayoutId(R.layout.swipe_out_view)
        )

    }
    private fun getResults() {
        apiInterface?.getResults()?.enqueue(object : Callback<MainResults>{
            override fun onFailure(call: Call<MainResults>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Error Occured",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<MainResults>, response: Response<MainResults>) {
                if (response.body() != null){
                    mSwipeView?.addView(TinderCard(this@MainActivity, response.body()!!.result, mSwipeView!!))
                }
            }
        })
    }


}
