package com.soneralci.countrykotlinlist.service

import com.soneralci.countrykotlinlist.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    //GET-POST-DELETE

    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    //BASE_URL ->https://raw.githubusercontent.com/
    //ext -> atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries(): Single<List<Country>>
}