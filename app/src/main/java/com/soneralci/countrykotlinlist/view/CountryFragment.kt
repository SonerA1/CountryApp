package com.soneralci.countrykotlinlist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.soneralci.countrykotlinlist.view.CountryFragmentArgs
import com.soneralci.countrykotlinlist.R
import com.soneralci.countrykotlinlist.databinding.FragmentCountryBinding
import com.soneralci.countrykotlinlist.databinding.FragmentFeedBinding
import com.soneralci.countrykotlinlist.utility.downloadFromUrl
import com.soneralci.countrykotlinlist.utility.placeHolderProgressBar
import com.soneralci.countrykotlinlist.viewmodel.CountryViewModel


class CountryFragment : Fragment(R.layout.fragment_country) {

    private var _binding: FragmentCountryBinding? = null
    private val binding get() = _binding!!
    private lateinit var dataBinding: FragmentCountryBinding

    private lateinit var viewModel: CountryViewModel
    private var countryUuid = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_country, container, false)
        _binding = FragmentCountryBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUuid
        }
        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuid)



        observeLiveData()
    }

    private fun observeLiveData() {

        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {
                dataBinding.selectedCountry = country

                /*
                 binding.countryName.text = country.countryName
                 binding.countryCapital.text = country.countryCapital
                 binding.countryCurrency.text = country.countryCurrency
                 binding.countryLanguage.text = country.countryLanguage
                 binding.countryRegion.text = country.countryRegion
                 context?.let {
                     binding.countryImage.downloadFromUrl(country.imageUrl, placeHolderProgressBar(it))
                 }
                 */
            }
        })

    }


}