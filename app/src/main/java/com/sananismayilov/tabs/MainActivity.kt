package com.sananismayilov.tabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.tabs.TabLayoutMediator
import com.sananismayilov.tabs.adapter.AdaptertoTabLayout
import com.sananismayilov.tabs.databinding.ActivityMainBinding
import com.sananismayilov.tabs.fragments.FirstFragment
import com.sananismayilov.tabs.fragments.SecondFragment
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    public lateinit var binding: ActivityMainBinding
    lateinit var arrayListTitle: ArrayList<String>
    lateinit var arrayListFragment: ArrayList<Fragment>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //tabLayout tittle
        arrayListTitle = ArrayList<String>()
        arrayListTitle.add("1")
        arrayListTitle.add("2")

        //tabLayout fragments
        arrayListFragment = ArrayList<Fragment>()
        arrayListFragment.add(FirstFragment())
        arrayListFragment.add(SecondFragment())

        //adapter initialize
        val adaptertoTabLayout = AdaptertoTabLayout(this, arrayListFragment)
        binding.pager.adapter = adaptertoTabLayout


        TabLayoutMediator(binding.tab, binding.pager) { tab, position ->
            tab.setText(arrayListTitle.get(position))
        }.attach()


    }
}