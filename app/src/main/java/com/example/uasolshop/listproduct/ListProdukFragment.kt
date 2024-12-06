package com.example.uasolshop.listproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.uasolshop.home.HomeAdminFragment
import com.example.uasolshop.R
import com.example.uasolshop.crud.TambahDataFragment
import com.example.uasolshop.databinding.FragmentListProdukBinding
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListProdukFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListProdukFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentListProdukBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentListProdukBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tambahProduk.setOnClickListener {
//                navController.navigate(R.id.action_listProdukFragment3_to_tambahDataFragment2)
                val tambahDataFragment = TambahDataFragment()

                // Lakukan fragment transaction
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, tambahDataFragment) // Ganti dengan fragment container ID yang sesuai
                    .addToBackStack(null) // Tambahkan ke backstack agar bisa kembali
                    .commit()
            }

//            tambahProduk.setOnClickListener {
//
//                // Perform FragmentTransaction to navigate to second fragment
//                val secondFragment = TambahDataFragment() // Create the fragment you want to show
//                val transaction = parentFragmentManager.beginTransaction()
//                transaction.replace(R.id.nav_host_fragmen, secondFragment) // Replace current fragment with new one
//                transaction.addToBackStack(null) // Optionally, add to back stack if you want to use back button
//                transaction.commit() // Commit the transaction
//            }
            // Handle back button click
            back.setOnClickListener {
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, HomeAdminFragment()) // Replace fragment
                transaction.commit()
//                findNavController().navigateUp()
//                if (requireActivity().supportFragmentManager.backStackEntryCount > 0) {
//                    requireActivity().onBackPressed() // Use onBackPressedDispatcher
//                } else {
//                    // Optionally handle when no backstack entry exists
//                    Toast.makeText(requireContext(), "No previous fragment to go back to", Toast.LENGTH_SHORT).show()
//                }
            }

            // Initialize TabLayout and ViewPager
            val pagerAdapter = PagerAdapter(this@ListProdukFragment, parentFragmentManager) // Replace with actual FragmentPagerAdapter
            viewPager.adapter = pagerAdapter

            // Set up TabLayout with ViewPager
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "Semua"
                        tab.setIcon(R.drawable.baseline_grid_view_24) // Set icon for "Semua"
                    }
                    1 -> {
                        tab.text = "Semen"
                        tab.setIcon(R.drawable.cement__1_) // Set icon for "Semen"
                    }
                    2 -> {
                        tab.text = "Besi"
                        tab.setIcon(R.drawable.beam) // Set icon for "Besi"
                    }
                    3 -> {
                        tab.text = "Lainnya"
                        tab.setIcon(R.drawable.baseline_more_horiz_24) // Set icon for "Lainnya"
                    }
                }
            }.attach()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListProdukFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListProdukFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}