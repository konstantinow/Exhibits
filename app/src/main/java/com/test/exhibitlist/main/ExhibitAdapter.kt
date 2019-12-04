package com.test.exhibitlist.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.test.exhibitlist.R
import com.test.exhibitlist.model.ILoaderModel

class ExhibitAdapter :
    RecyclerView.Adapter<ExhibitAdapter.ExhibitViewHolder>() {
    private val mData = mutableListOf<ILoaderModel.Exhibit>()

    fun setData(data: List<ILoaderModel.Exhibit>) {
        mData.clear()
        mData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exhibit_item, parent, false)
        return ExhibitViewHolder(view)
    }

    override fun getItemCount() = mData.size

    override fun onBindViewHolder(holder: ExhibitViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    class ExhibitViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val pager = itemView.findViewById<ViewPager>(R.id.vpImages)
        private val title = itemView.findViewById<TextView>(R.id.tvTitle)

        fun bind(item: ILoaderModel.Exhibit) {
            title.text = item.title
            pager.adapter = ImagesPagerAdapter(itemView.context, item.images)
        }
    }

    class ImagesPagerAdapter(mContext: Context, private val mImages: List<String>) :
        PagerAdapter() {
        private val mLayoutInflater: LayoutInflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getCount(): Int = mImages.size

        override fun isViewFromObject(view: View, `object`: Any) = view === `object` as ImageView

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false)

            val imageView = itemView.findViewById(R.id.ivPicture) as ImageView
            Glide.with(itemView.context)
                .load(mImages[position])
                .centerCrop()
                .into(imageView)

            container.addView(itemView)

            return itemView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as ImageView)
        }

    }
}