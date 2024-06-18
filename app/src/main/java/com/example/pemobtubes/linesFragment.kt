package com.example.pemobtubes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.ArrayAdapter
import com.example.pemobtubes.databinding.FragmentLinesBinding

class linesFragment : Fragment(R.layout.fragment_lines) {

    private var _binding: FragmentLinesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var favoriteList: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLinesBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoriteList = listOf(
            "Alun Alun Kota Bandung",
            "Gedung Sate",
            "Trans Studio Bandung",
            "Jalan Braga",
            "Pasar Baru",
            "Gede Bage",
            "Cihampelas Walk",
            "Kiara Artha Park",
            "Bandung Zoo")
        adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,favoriteList)
        binding.favoriteList.adapter = adapter

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