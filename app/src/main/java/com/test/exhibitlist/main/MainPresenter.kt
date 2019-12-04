package com.test.exhibitlist.main

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val mMainModel: IMainModel
) : MvpPresenter<IMainView>() {
    companion object {
        private const val TAG = "MainPresenter"
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Log.d(TAG, "onFirstViewAttach")
        viewState.updateList(mMainModel.getExhibitList())
    }
}