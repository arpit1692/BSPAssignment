package com.example.bsptechnologies.Adapter;

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.bsptechnologies.Models.Result

class MyPagerAdapter(
    var manager: FragmentManager,
    var result: MutableList<Result>
) : FragmentPagerAdapter(manager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var fragments:List<Fragment>? = null;

    override fun getItem(position: Int): Fragment {
        return fragments!!.get(position);
    }

    override fun getCount(): Int {
       return  result.size
    }
}