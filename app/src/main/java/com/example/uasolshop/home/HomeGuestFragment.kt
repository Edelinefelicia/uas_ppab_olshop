package com.example.uasolshop.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.uasolshop.mainactivity.MainActivityGuest
import com.example.uasolshop.productAdapter.ProductGuestAdapter
import com.example.uasolshop.R
import com.example.uasolshop.carousel.CarouselAdapter
import com.example.uasolshop.databinding.FragmentHomeGuestBinding
import com.example.uasolshop.listproduct.guest.ListProdukGuestFragment
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeGuestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeGuestFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentHomeGuestBinding? = null
    private val binding get() = _binding!!
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var images: List<Int>
    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeGuestBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapterproduct = ProductGuestAdapter()
        with(binding){
            recyclerViewtopproduct.apply {
                adapter = adapterproduct
                layoutManager = GridLayoutManager(requireContext(), 2) // Grid 2 kolom
            }
            tvSeeAll.setOnClickListener {
                (activity as MainActivityGuest).setFragment(ListProdukGuestFragment(), keepNavOnHome = true)
            }
//            val action =
//                HomeAdminFragmentDirections.actionHomeAdminFragmentToListProdukFragment3()
//            tvSeeAll.setOnClickListener {
//                findNavController().navigate(action)
//            }
        }
        // Initialize image data
        images = listOf(
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo
        )

        // Set up ViewPager2 with adapter
        val adapter = CarouselAdapter(images)
        binding.viewPager.adapter = adapter

        // Attach TabLayout with ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()

        // Start Auto-Scroll
        startAutoScroll()
    }

    private fun startAutoScroll() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                currentPage = (currentPage + 1) % images.size
                binding.viewPager.currentItem = currentPage
                handler.postDelayed(this, 3000) // Delay 3 seconds
            }
        }, 3000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null) // Stop Auto-Scroll
        _binding = null
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeGuestFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                HomeGuestFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}