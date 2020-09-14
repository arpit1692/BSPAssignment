package com.technomatics.sthalmatrimony

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.c.kotlinmall.Retrofit.ApiInterface
import com.example.bsptechnologies.Models.MainResults
import com.example.bsptechnologies.Models.Result
import com.example.bsptechnologies.R
import com.example.coditasassignment.Adapter.DetailsAdapter
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.mindorks.placeholderview.annotations.swipe.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Layout(R.layout.card_view)
class TinderCard(
    private val mContext: Context,
    data: List<Result>,
    mSwipeView: SwipePlaceHolderView
) {
    var apiInterface: ApiInterface? = null
    var adapter:DetailsAdapter? = null
    var count = 0;
    @View(R.id.profileImageView)
    private val profileImageView: ImageView? = null

    private val mProfile: List<Result> = data
    private val mSwipeView: SwipePlaceHolderView = mSwipeView

    @Resolve
    private fun onResolved() {
        Glide.with(mContext).load(mProfile[count].image).into(profileImageView!!);
    }

    @SwipeOut
    private fun onSwipedOut() {
        Log.d("EVENT", "onSwipedOut")
        getNextResults()
    }

    @SwipeCancelState
    private fun onSwipeCancelState() {
        Log.d("EVENT", "onSwipeCancelState")
    }

    @SwipeIn
    private fun onSwipeIn() {
        Log.d("EVENT", "onSwipedIn")
        getPreviousResults();
    }

    @SwipeInState
    private fun onSwipeInState() {
        Log.d("EVENT", "onSwipeInState")
    }

    @SwipeOutState
    private fun onSwipeOutState() {
        Log.d("EVENT", "onSwipeOutState")
    }

    private fun getNextResults() {
        Glide.with(mContext).load(mProfile[count++].image).into(profileImageView!!);
//        apiInterface = RetrofitClient.getClient(mContext)!!.create(ApiInterface::class.java)
//        apiInterface?.getResults()?.enqueue(object : Callback<MainResults> {
//            override fun onFailure(call: Call<MainResults>, t: Throwable) {
//                Toast.makeText(mContext,"Error Occured", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(call: Call<MainResults>, response: Response<MainResults>) {
//                if (response.body() != null){
//                    mSwipeView?.addView(TinderCard(mContext, response.body()!!.result, mSwipeView!!))
//                }
//            }
//        })
    }

    private fun getPreviousResults() {
        Glide.with(mContext).load(mProfile[count--].image).into(profileImageView!!);
//        apiInterface = RetrofitClient.getClient(mContext)!!.create(ApiInterface::class.java)
//        apiInterface?.getResults()?.enqueue(object : Callback<MainResults> {
//            override fun onFailure(call: Call<MainResults>, t: Throwable) {
//                Toast.makeText(mContext,"Error Occured", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(call: Call<MainResults>, response: Response<MainResults>) {
//                if (response.body() != null){
//                    mSwipeView?.addView(TinderCard(mContext, response.body()!!.result, mSwipeView!!))
//                }
//            }
//        })
    }


}