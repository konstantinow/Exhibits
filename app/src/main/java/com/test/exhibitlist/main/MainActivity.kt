package com.test.exhibitlist.main

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.test.exhibitlist.App
import com.test.exhibitlist.model.ILoaderModel
import com.test.exhibitlist.R
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : MvpActivity(), IMainView {
    companion object {
        private const val TAG = "MainActivity"
    }

    @InjectPresenter
    lateinit var mPresenter: MainPresenter

    @Inject
    lateinit var presenterProvider: Provider<MainPresenter>

    @ProvidePresenter
    fun providePresenter(): MainPresenter = presenterProvider.get()

    private val mExhibitAdapter: ExhibitAdapter = ExhibitAdapter()

    init {
        App.mAppComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvExhibits.adapter = mExhibitAdapter
        rvExhibits.layoutManager = LinearLayoutManager(this)
        rvExhibits.setHasFixedSize(true)
    }

    override fun updateList(list: List<ILoaderModel.Exhibit>) {
        mExhibitAdapter.setData(list)
        list.forEach {
            Log.d(TAG, it.title)
        }
    }

}
