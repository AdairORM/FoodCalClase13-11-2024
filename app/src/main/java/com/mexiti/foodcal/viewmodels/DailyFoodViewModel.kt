package com.mexiti.foodcal.viewmodels

import androidx.compose.ui.layout.FirstBaseline
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import com.mexiti.foodcal.model.DailyFood
import com.mexiti.foodcal.model.DayFood
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DailyFoodViewModel:ViewModel() {
    private val firestore = Firebase.firestore

    private val _dataDailyFood = MutableStateFlow<List<DailyFood>>(emptyList())

    val dataDailyFood: StateFlow<List<DailyFood>> = _dataDailyFood

    fun fetchDaysFood(){
        firestore.collection("DayFood")
            .orderBy("day")
            .addSnapshotListener {
                    querySnapshot,
                    error ->
                if( error != null){
                    return@addSnapshotListener
                }
                val documents = mutableListOf<DailyFood>()
                if( querySnapshot != null){

                    for( document in querySnapshot){
                        val myDocument = document.toObject(DailyFood::class.java)
                            .copy(id = document.id)
                        documents.add(myDocument)
                    }
                }
                _dataDailyFood.value = documents
            }
    }
}