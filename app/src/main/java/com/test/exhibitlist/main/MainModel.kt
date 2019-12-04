package com.test.exhibitlist.main

import android.content.Context
import com.test.exhibitlist.model.FileExhibitsLoader
import com.test.exhibitlist.model.ILoaderModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainModel @Inject constructor(mContext: Context) : IMainModel {
    private val mExhibitsLoader = FileExhibitsLoader(mContext)
    private val mExhibitsList: List<ILoaderModel.Exhibit> = mExhibitsLoader.getExhibitList()

    override fun getExhibitList(): List<ILoaderModel.Exhibit> = mExhibitsList
}