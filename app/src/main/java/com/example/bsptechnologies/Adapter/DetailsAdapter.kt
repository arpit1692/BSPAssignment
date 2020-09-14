package com.example.coditasassignment.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.bsptechnologies.Models.MainResults

class DetailsAdapter(supportFragmentManager: FragmentManager, behaviorResumeOnlyCurrentFragment: Int,var body: MainResults
) : FragmentStatePagerAdapter(supportFragmentManager,behaviorResumeOnlyCurrentFragment) {



    override fun getItem(position: Int): Fragment {
        lateinit var fragment:Fragment
        when(position){
        }
        return fragment
    }

    override fun getCount(): Int {
        return 1
    }
}