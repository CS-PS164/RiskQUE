package com.bangkit.riskque.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.riskque.adapter.DplkListAdapter
import com.bangkit.riskque.adapter.LoadingStateAdapter
import com.bangkit.riskque.data.local.SettingPreferences
import com.bangkit.riskque.data.local.dataStore
import com.bangkit.riskque.databinding.FragmentHomeBinding
import com.bangkit.riskque.model.Dplk
import com.bangkit.riskque.ui.main.MainActivity
import com.bangkit.riskque.ui.setting.SettingViewModel
import com.bangkit.riskque.ui.setting.SettingViewModelFactory
import kotlin.math.log

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by activityViewModels {
        ViewModelFactory(requireActivity())
    }
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvDplk.layoutManager = LinearLayoutManager(requireContext())

        val pref = SettingPreferences.getInstance((activity as MainActivity).dataStore)
        val settingViewModel = ViewModelProvider(
            requireActivity(), SettingViewModelFactory(pref)
        )[SettingViewModel::class.java]

        generateData("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJ1c2VyLTNucFV4Q29hRlVwWEgxUjgiLCJpYXQiOjE2ODY4MTU2NDh9.vEq-vykCE85gcbYYsj0gdBSiCBQHvMKUfGY6hDPyct0")
    }

    private fun generateData(token: String) {
        val adapter = DplkListAdapter()
        binding.rvDplk.adapter = adapter.withLoadStateFooter(footer = LoadingStateAdapter {
            adapter.retry()
        })

        adapter.onItemClick = {
            /*
            val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
            intentDetail.putExtra(Constants.EXTRA_STORY, it)
            startActivity(intentDetail)

             */
        }
        homeViewModel.getListDplk(token).observe(requireActivity()) {
            val dataDummy: PagingData<Dplk>
            adapter.submitData(lifecycle, it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}