package com.daerawind.nextdoor.model

import androidx.recyclerview.widget.DiffUtil

data class Story(
    val id: String,
    val body: String,
    val author: String,
    val image: Image? = null
) {
    class Image(
        val url: String,
        val width: Int,
        val height: Int
    )

    class DiffCallback : DiffUtil.ItemCallback<Story>() {
        override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem.body == newItem.body &&
                    oldItem.author == newItem.author &&
                    oldItem.image == newItem.image
        }
    }

}