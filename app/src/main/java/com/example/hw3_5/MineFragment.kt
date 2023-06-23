package com.example.hw3_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw3_5.databinding.FragmentMineBinding


class MineFragment : Fragment() {
    private lateinit var binding: FragmentMineBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMineBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btMath.setOnClickListener {
                if ((tvResult.text.toString()).toInt() < 10 && btMath.text == "+1") {
                    tvResult.text = ((tvResult.text.toString()).toInt().inc()).toString()
                } else {
                    btMath.text = "-1"
                    tvResult.text = ((tvResult.text.toString()).toInt().dec()).toString()
                    if ((tvResult.text.toString()).toInt() == 0) {
                        var result = tvResult.text.toString()
                        var bundle = Bundle()
                        bundle.putString("result", result)
                        val blancFragment = BlankFragment()
                        blancFragment.arguments = bundle
                        requireActivity().supportFragmentManager.beginTransaction()
                            .replace(R.id.contener, blancFragment).addToBackStack(null).commit()
                    }
                }
            }
        }
    }
}