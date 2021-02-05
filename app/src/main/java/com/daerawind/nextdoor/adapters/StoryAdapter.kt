package com.daerawind.nextdoor.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daerawind.nextdoor.R
import com.daerawind.nextdoor.model.Story
import kotlinx.android.synthetic.main.item_story.view.*

class StoryAdapter : ListAdapter<Story, RecyclerView.ViewHolder>(Story.DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (holder is StoryViewHolder) {
            holder.init(item)
        }
    }

    inner class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun init(story: Story) {
            itemView.tv_author.text = story.author
            itemView.tv_body.text = story.body
            story.image?.url?.let { Glide.with(itemView.context).load(it).into(itemView.image) }
        }
    }

}