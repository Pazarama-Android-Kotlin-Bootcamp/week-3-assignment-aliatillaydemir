package com.ayd.series.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

//inject ediyoruz remote data source'u bu repo'ya

@ViewModelScoped
 //bunu repoda annote ediyoruz. böylelikle hem remote hem de kullanılması durumunda local data soruce injecte edilebilecek. bu 2 yerde ayrı ayrı inject edeceğimize repoda tek yerde inject etmiş oluyoruz yani.
class Repo @Inject constructor(
    remoteDataSource: RemoteDataSource
){

    val remote = remoteDataSource

}