package com.test.exhibitlist.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.test.exhibitlist.model.ILoaderModel

interface IMainView : MvpView {
    @StateStrategyType(SingleStateStrategy::class)
    fun updateList(list: List<ILoaderModel.Exhibit>)
}