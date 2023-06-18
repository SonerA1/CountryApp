package com.soneralci.countrykotlinlist.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.soneralci.countrykotlinlist.R
import com.soneralci.countrykotlinlist.databinding.ItemCountryBinding
import com.soneralci.countrykotlinlist.model.Country
import com.soneralci.countrykotlinlist.view.FeedFragmentDirections


class CountryAdapter(val countryList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener {

    class CountryViewHolder(var binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemCountryBinding>(
            inflater,
            R.layout.item_country,
            parent,
            false
        )
        return CountryViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return countryList.size

    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.binding.country = countryList[position]
        holder.binding.listener = this
        holder.binding.root.tag = holder.binding
        holder.binding.root.setOnClickListener {
            onCountryClicked(it)
        }
        /*
        holder.binding.name.text = countryList.get(position).countryName
        holder.binding.region.text = countryList.get(position).countryRegion

        holder.binding.root.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryList[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }

        holder.binding.imageView.downloadFromUrl(countryList[position].imageUrl, placeHolderProgressBar(holder.binding.root.context))

    }
 */
    }

    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View) {
        val binding = v.tag as? ItemCountryBinding ?: return
        val uuid = binding.country?.uuid ?: return
        val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)
        Navigation.findNavController(v).navigate(action)
    }

}
