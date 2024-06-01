package com.sahansenvar.exzicasestudy

import androidx.lifecycle.ViewModel
import com.sahansenvar.core.common.basesAndMarkers.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MainViewModel(

) : BaseViewModel<MainUiState>(MainUiState()){


}