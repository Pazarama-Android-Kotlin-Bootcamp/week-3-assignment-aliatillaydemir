package com.ayd.series

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ayd.series.data.Repo
import com.ayd.series.models.Avatar
import com.ayd.series.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: Repo,
    application: Application
): AndroidViewModel(application) {

    var avatarResponse: MutableLiveData<NetworkResult<Avatar>> = MutableLiveData()


    fun getAvatar(queries: Map<String,String>) = viewModelScope.launch {
        getRecipesSafeCall(queries)
    }


    private suspend fun getRecipesSafeCall(queries: Map<String, String>) {
        avatarResponse.value = NetworkResult.Loading()

        if(internetConnection()){
            try{
                val response = repo.remote.getAvatar(queries)
                avatarResponse.value = handleAvatarResponse(response)
            }catch (e:Exception){
                avatarResponse.value = NetworkResult.Error("Characters not found")
            }
        }else{
            avatarResponse.value = NetworkResult.Error("Connection error!")
        }
    }

    private fun handleAvatarResponse(response: Response<Avatar>): NetworkResult<Avatar>? {
        when{
            response.message().toString().contains("timeout") ->{
                return NetworkResult.Error("Timeout")
            }
            response.code() == 402 ->{
                return NetworkResult.Error("Api key limited!") //yok böyle bir şey ama yazmış oldum.
            }
            response.body()?.result.isNullOrEmpty() ->{
                return NetworkResult.Error("Characters not found")
            }
            response.isSuccessful -> {
                val avatars = response.body()
                return NetworkResult.Success(avatars!!)
            }
            else ->{
                return NetworkResult.Error(response.message())
            }
        }
    }


    private fun internetConnection():Boolean{
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

        return when{
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }


}