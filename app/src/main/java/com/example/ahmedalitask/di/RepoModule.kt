package com.example.ahmedalitask.di


import com.example.data.remote.ApiService
import com.example.data.repo.ProductsRepoImp
import com.example.domain.repo.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 17/06/2023
 */
@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService): Repo {
        return ProductsRepoImp(apiService)
    }
}