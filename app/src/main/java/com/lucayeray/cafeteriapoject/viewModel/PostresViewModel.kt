package com.lucayeray.cafeteriapoject.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucayeray.cafeteriapoject.ProducteRepository
import com.lucayeray.cafeteriapoject.data.model.ProducteEntity

class PostresViewModel : ViewModel() {

    private val _postres = MutableLiveData<List<ProducteEntity>>()


    val postres: LiveData<List<ProducteEntity>> = _postres


    fun carregarPostres(context: Context) {
        ProducteRepository
            .obtenirProductesPerTipus(context, "postres")
            .observeForever { llista ->
                _postres.value = llista
            }
    }

}