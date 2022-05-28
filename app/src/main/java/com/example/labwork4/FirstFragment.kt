package com.example.labwork4

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.labwork4.component.ItemOfRecyclerView
import com.example.labwork4.databinding.FragmentFirstBinding
import com.example.labwork4.dialog.NumberViewDialog
import com.example.labwork4.generator.RandomElementsAdapter
import kotlin.random.Random

class FirstFragment : Fragment(R.layout.fragment_first) {

    private val ITEMS_NUM = 8
    private val COLUMNS = 2

    private val list: MutableList<ItemOfRecyclerView> = mutableListOf()
    private lateinit var binding: FragmentFirstBinding
    private lateinit var recyclerViewAdapter:RandomElementsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val num: Int = requireArguments().getInt("position")
        binding.title.text = "Fragment $num"

        setRecyclerViewContent()
    }

    private fun setRecyclerViewContent() {
        recyclerViewAdapter = RandomElementsAdapter {
            val dialogFragment = NumberViewDialog(it)
            val fragmentManager = (activity as FragmentActivity).supportFragmentManager
            dialogFragment.show(fragmentManager,"my tag")
        }
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, COLUMNS)
            adapter = recyclerViewAdapter
        }

        recyclerViewAdapter.submitList(setupData())
    }

    private fun setupData(): List<ItemOfRecyclerView> {
        val items = mutableListOf<ItemOfRecyclerView>()
        for (i in 1..ITEMS_NUM) {
            items.add(
                ItemOfRecyclerView(
                    numericValue = Random.nextInt(99),
                    color = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
                )
            )
        }
        return items
    }

    companion object {
        fun newInstance(pos: Int): FirstFragment{
            val args = Bundle()
            args.putInt("position", pos)

            val fragment = FirstFragment()
            fragment.arguments = args
            return fragment
        }
    }
}