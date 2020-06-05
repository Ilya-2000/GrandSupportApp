package com.impact.grandsupportapp.adapter

import android.app.Dialog
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.impact.grandsupportapp.R
import com.impact.grandsupportapp.data.Lesson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.full_img.*

class LessonVpAdapter(val item: Lesson?, var context: Context) : RecyclerView.Adapter<PagerVH>() {
    private var listener: LessonListRvAdapter.OnСlickListener? = null

    fun setListener(listener: LessonListRvAdapter.OnСlickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        var itemView =
            PagerVH(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.lesson_item, parent, false))

        return itemView
    }
    



    override fun getItemCount(): Int = item?.steps!!

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        holder.bind(item, position)

        holder.itemView.setOnClickListener {

        }
    }
}

class PagerVH(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val textLesson = itemView.findViewById<TextView>(R.id.lesson_text_item)
    private val titleLesson = itemView.findViewById<TextView>(R.id.lesson_title_item)
    private val imageLesson = itemView.findViewById<ImageView>(R.id.lesson_img_item)
    fun bind(item: Lesson?, position: Int) {
        Picasso.get()
            .load(item?.imageList?.get(position))
            .into(imageLesson)
        textLesson.text = item?.textList?.get(position)
        titleLesson.text = item?.name

        imageLesson.setOnClickListener {
            getDialog(imageLesson.drawable, itemView.context)
        }
    }

    public interface OnСlickListener {
        fun onClick(position: Int)

    }

    fun getDialog(d: Drawable, context: Context) {
        var dialog = Dialog(context, R.style.MyTheme)
        dialog.setContentView(R.layout.full_img)
        var layoutParams: WindowManager.LayoutParams = dialog.window!!.attributes
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog.window!!.setLayout(width,height)
        dialog.window!!.attributes = layoutParams

        val img = dialog.img_full_view
        img.setImageDrawable(d)
        dialog.show()
        img.setOnClickListener {
            img.setImageDrawable(null)
            dialog.cancel()
        }
    }


}