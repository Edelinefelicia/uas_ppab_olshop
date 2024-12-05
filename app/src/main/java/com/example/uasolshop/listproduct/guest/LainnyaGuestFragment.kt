package com.example.uasolshop.listproduct.guest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.uasolshop.R
import com.example.uasolshop.databinding.FragmentBesiGuestBinding
import com.example.uasolshop.databinding.FragmentLainnyaBinding
import com.example.uasolshop.databinding.FragmentLainnyaGuestBinding
import com.example.uasolshop.productAdapter.ProductAdapter
import com.example.uasolshop.productAdapter.ProductGuestAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LainnyaGuestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LainnyaGuestFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentLainnyaGuestBinding? =null
    private val binding get() = _binding!!
    private lateinit var productGuestAdapter: ProductGuestAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLainnyaGuestBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Adapter
        productGuestAdapter = ProductGuestAdapter()

        // Setup RecyclerView
        with(binding.recyclerViewtopproduct) {
            layoutManager = GridLayoutManager(context, 2) // Menggunakan GridLayoutManager
            adapter = productGuestAdapter
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LainnyaGuestFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LainnyaGuestFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}