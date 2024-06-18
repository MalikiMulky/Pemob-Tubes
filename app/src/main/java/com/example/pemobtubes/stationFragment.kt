package com.example.pemobtubes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.ArrayAdapter
import com.example.pemobtubes.databinding.FragmentStationBinding

class stationFragment : Fragment(R.layout.fragment_station) {

    private var _binding: FragmentStationBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var station: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStationBinding.inflate(inflater, container,false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        station = listOf(
            "Gunung Batu - Stasiun Hall(Feeder)",
            "Summarecon - Cibeureum",
            "Cibiru - Cibeureum",
            "Cicaheum - Sarijadi",
            "Terminal Antapani - Terminal Leuwi Panjang",
            "Terminal Antapani - Stasiun Hall",
            "Baleendah - BEC",
            "Leuwi Panjang - UNPAD Dipatiukur",
            "Cileunyi  - Sumedang")
        adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,station)
        binding.userList.adapter = adapter

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}