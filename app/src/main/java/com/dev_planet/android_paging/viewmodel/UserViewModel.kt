package com.dev_planet.android_paging.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dev_planet.android_paging.datasource.UserDataSource
import com.dev_planet.android_paging.datasource.UserDataSourceFactory
import com.dev_planet.android_paging.model.User

class UserViewModel : ViewModel() {


    val userPagedList : LiveData<PagedList<User>>

    private val liveDataSource : LiveData<UserDataSource>

    init {
        val itemDataSourceFactory = UserDataSourceFactory()

        liveDataSource = itemDataSourceFactory.userLiveDataSource

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(UserDataSource.PAGE_SIZE)
            .build()

        userPagedList = LivePagedListBuilder(itemDataSourceFactory,config)
            .build()

    }
}