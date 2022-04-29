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

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = MyAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, pos ->
            tab.text = "Page $pos"
        }.attach()
    }

    class MyAdapter(activity : AppCompatActivity) : FragmentStateAdapter(activity) {

        private val list = arrayListOf(
            FirstFragment.newInstance(0, R.drawable.ic_home),
            FirstFragment.newInstance(1, R.drawable.ic_account),
            FirstFragment.newInstance(2, R.drawable.ic_list),
            FirstFragment.newInstance(3, com.google.android.material.R.drawable.ic_clock_black_24dp)
        )

        override fun getItemCount(): Int = 4

        override fun createFragment(pos: Int) = list[pos]

    }
/*        binding.bottomNavigationView.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.item_home -> FirstFragment.newInstance("Home")
                R.id.item_list -> FirstFragment.newInstance("List")
                R.id.item_acc -> FirstFragment.newInstance("Account")
            }
            true
        }
        binding.bottomNavigationView.selectedItemId = R.id.item_home
    }

    private fun setCurrentFragment (string: String) {
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerView, FirstFragment.newInstance(string))
        }
    }*/
}