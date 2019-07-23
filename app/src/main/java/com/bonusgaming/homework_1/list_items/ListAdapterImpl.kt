package com.bonusgaming.homework_1.list_items

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import com.bonusgaming.homework_1.App
import com.bonusgaming.homework_1.R
import com.bonusgaming.homework_1.TAG
import com.squareup.picasso.Picasso

class ListAdapterImpl() : BaseListAdapter<Item>() {
    init {
        Log.e(TAG, "ListAdapterImpl init block")
    }

    override fun getHolderInstance(view: View): ItemHolder<Item> {
        Log.e(TAG, "getHolderInstance")
        return HolderImpl(view)
    }

    class HolderImpl(view: View) : BaseListAdapter.ItemHolder<Item>(view) {

        private val imagePreview: AppCompatImageView = view.findViewById(R.id.image_preview)
        private val textNameAuthor: TextView = view.findViewById(R.id.author_name)
        private val textLikes: TextView = view.findViewById(R.id.likes)
        private val cardView: CardView = view.findViewById(R.id.card_view_in_list)
        private lateinit var item: Item

        init {
            cardView.isClickable = true
            cardView.setOnClickListener(View.OnClickListener {
                Log.e(TAG,"blabla click${App.appComponent.getMainViewModel().data}")
                App.appComponent.getMainViewModel().onClick(item)
            })
        }

        override fun inflateData(item: Item) {
            Log.e(TAG, "inflateData")
            this.item = item
            Picasso.get().load(item.previewUrl).into(imagePreview)
            textNameAuthor.text = item.authorName
            textLikes.text = item.likes.toString()

            //  textNameAuthor.setOutlineText()
            // textLikes.setOutlineText()
        }


        // fun TextView.setOutlineText() {
        //this.color(Color.WHITE)
        //     paint.isFakeBoldText = false;
        //        paint.setShadowLayer(1.toFloat(), 0.toFloat(), 0.toFloat(), Color.BLACK);
        //    }

    }
}