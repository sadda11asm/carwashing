package com.example.carwashing.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carwashing.vo.CarWash
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

class MainViewModel : ViewModel() {

    private val mainScope = CoroutineScope(Dispatchers.Main)
    private var insideScope = CoroutineScope(Dispatchers.Main)


    override fun onCleared() {
        super.onCleared()
        mainScope.coroutineContext.cancel()
        insideScope.coroutineContext.cancel()
    }

    val carWashList = MutableLiveData<List<CarWash>>()


    fun setCarWashes() {
        carWashList.value = listOf(
            CarWash(
                "Johns Wash", 1, "Кабанбай батыр 53, Астана"
                , 5.0f, 51.142067, 71.421842
            ), CarWash(
                "Car Wash", 2, "Кабанбай батыр 23, Астана"
                , 4.0f, 51.151115, 71.388013
            ), CarWash(
                "Calypso", 3, "Кабанбай батыр 232, Астана"
                , 3.0f, 51.155410, 71.436438
            ), CarWash(
                "Столичная", 4, "Кабанбай батыр 12, Астана"
                , 4.5f, 51.160247, 71.461346
            ), CarWash(
                "Good Wash", 5, "Кабанбай батыр 54, Астана"
                , 4.0f, 51.142280, 71.462954
            ), CarWash(
                "Автопати", 6, "Кабанбай батыр 345, Астана"
                , 4.2f, 51.172616, 71.436646
            ), CarWash(
                "Бумер", 7, "Кабанбай батыр 235, Астана"
                , 2.5f, 51.172203, 71.402248
            ), CarWash(
                "Top Gear", 8, "Кабанбай батыр 57, Астана"
                , 5.0f, 51.143472, 71.448505
            )
        )
    }
}
//private val arrayPlaces = arrayOf(LatLng(51.142067, 71.421842), LatLng(51.151115, 71.388013), LatLng(51.155410, 71.436438), LatLng(51.160247, 71.461346),
// LatLng(51.142280, 71.462954), LatLng(51.172616, 71.436646), LatLng(51.172203, 71.402248), LatLng(51.143472, 71.448505))
//private val arrayNames = arrayOf("Johns Wash", "Car Wash", "Calypso", "Столичная", "Good Wash", "Автопати", "Бумер", "Top Gear")
//private val arrayStars = arrayOf("Rating: 5.0", "Rating: 5.0", "Rating: 5.0", "Rating: 5.0", "Rating: 5.0", "Rating: 5.0", "Rating: 5.0", "Rating: 5.0")
