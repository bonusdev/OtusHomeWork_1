package com.bonusgaming.homework_1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import javax.inject.Inject

/* Один раз создаем фрагмент, данные
   которого потом динамически меняем через метод invalidateItem() */
class ItemFragment : Fragment() {

    @Inject
    lateinit var viewModel: MainViewModel

    lateinit var textName: TextView
    lateinit var imageAuthor: AppCompatImageView
    lateinit var imageMain: AppCompatImageView
    lateinit var likes: TextView
    lateinit var views: TextView

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textName = view.findViewById(R.id.item_author_name)
        imageAuthor = view.findViewById(R.id.item_image_author)
        imageMain = view.findViewById(R.id.item_image_view_big)
        likes = view.findViewById(R.id.item_likes)
        views = view.findViewById(R.id.item_views)
        invalidateItem()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    fun invalidateItem() {
        val item = viewModel.getCurrentItem()
        textName.text = item.authorName
        likes.text = item.likes.toString()
        views.text = item.views.toString()
        if (item.authorAvatarUrl.isEmpty()) {
            Picasso.get()
                .load(R.drawable.baseline_account_box_black_18dp)
                .into(imageAuthor)
        } else {
            Picasso.get()
                .load(item.authorAvatarUrl)
                .into(imageAuthor)
        }

        Picasso.get().load(item.previewUrl).into(imageMain)
    }
}