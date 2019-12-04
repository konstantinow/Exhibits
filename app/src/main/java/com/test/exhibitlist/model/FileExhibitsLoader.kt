package com.test.exhibitlist.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream


class FileExhibitsLoader(private val mContext: Context) :
    ILoaderModel.ExhibitsLoader {

    companion object {
        private const val FILE_PATH = "data.json"
    }

    override fun getExhibitList(): List<ILoaderModel.Exhibit> {
        val rawString = readStringFromAssets() ?: return emptyList()
        val type = object : TypeToken<RootObject>() {}.type
        val rootObject = Gson().fromJson<RootObject>(rawString, type)

        return rootObject?.list ?: return emptyList()
    }

    private fun readStringFromAssets(): String? {
        val json: String?
        try {
            val inputStream: InputStream = mContext.assets.open(FILE_PATH)
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    inner class RootObject {
        var list: List<ILoaderModel.Exhibit>? = null
    }

}