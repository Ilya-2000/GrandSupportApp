package com.example.grandsupportapp.social_network


import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView

import com.example.grandsupportapp.R
import kotlinx.android.synthetic.main.full_img.*
import kotlinx.android.synthetic.main.info_network.*

/**
 * A simple [Fragment] subclass.
 */
class StartNetworkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_start_network, container, false)
        val img = root.findViewById<ImageView>(R.id.img_fragment)


        img.setOnClickListener {
            getDialog()

        }
        return root
    }
    public fun getDialog() {
        var dialog = Dialog(activity!!,R.style.MyTheme)
        dialog.setContentView(R.layout.info_network)
        var layoutParams: WindowManager.LayoutParams = dialog.window!!.attributes
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog.window!!.setLayout(width,height)
        dialog.window!!.attributes = layoutParams

        val installBtn = dialog.install_ok_btn
        val closeBtn = dialog.close_dialog_net_btn
        installBtn.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=ru.ok.android")))
        }

        closeBtn.setOnClickListener {
            dialog.cancel()
        }

        dialog.show()

    }


}
