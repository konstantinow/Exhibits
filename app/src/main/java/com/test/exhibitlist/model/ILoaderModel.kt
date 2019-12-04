package com.test.exhibitlist.model

interface ILoaderModel {
    data class Exhibit(val title: String, val images: List<String>)

    interface ExhibitsLoader {
        fun getExhibitList(): List<Exhibit>
    }
}
