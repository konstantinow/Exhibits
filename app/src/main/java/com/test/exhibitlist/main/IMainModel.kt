package com.test.exhibitlist.main

import com.test.exhibitlist.model.ILoaderModel

interface IMainModel {
    fun getExhibitList(): List<ILoaderModel.Exhibit>
}