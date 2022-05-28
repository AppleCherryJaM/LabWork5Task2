package com.example.labwork4

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.labwork4.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = MyAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, pos ->
            tab.text = "Page $pos"
        }.attach()
    }

    class MyAdapter(activity : AppCompatActivity) : FragmentStateAdapter(activity) {

        private val list = arrayListOf(
            FirstFragment.newInstance(0),
            FirstFragment.newInstance(1),
            FirstFragment.newInstance(2),
            FirstFragment.newInstance(3)
        )

        override fun getItemCount(): Int = 4

        override fun createFragment(pos: Int) = list[pos]

    }
}