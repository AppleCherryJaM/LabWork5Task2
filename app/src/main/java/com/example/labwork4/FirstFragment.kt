package com.example.labwork4

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.labwork4.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

     private lateinit var binding: FragmentFirstBinding

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
        binding.imageView.setOnClickListener{
            binding.imageView.setImageResource(requireArguments().getInt("src"))
        }
    }

    companion object {
        fun newInstance(pos: Int, src: Int): FirstFragment{
            val args = Bundle()
            args.putInt("position", pos)
            args.putInt("src", src)

            val fragment = FirstFragment()
            fragment.arguments = args
            return fragment
        }
    }
}