package com.example.headline.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.view.menu.ActionMenuItemView
import com.example.headline.R
import com.example.headline.model.Article
import kotlinx.android.synthetic.main.item_head.view.*

class HeadAdapter(var headList: List<Article>):
    RecyclerView.Adapter<HeadAdapter.HeadViewHolder>() {

    inner class HeadViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindHead(head: Article) {
            itemView.txtTitle.text = head.title
            itemView.txtContent.text = head.content

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_head, parent, false)
        return HeadViewHolder(view)
    }

    override fun getItemCount(): Int {

        return headList.size
    }

    override fun onBindViewHolder(holder: HeadViewHolder, position: Int) {

        holder.bindHead(headList[position])
    }

}