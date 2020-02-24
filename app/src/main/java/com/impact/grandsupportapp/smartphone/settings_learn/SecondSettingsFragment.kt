package com.impact.grandsupportapp.smartphone.settings_learn

import android.app.Dialog
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView

import com.impact.grandsupportapp.R
import kotlinx.android.synthetic.main.full_img.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SecondSettingsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SecondSettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondSettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_second_settings, container, false)
        val img = root.findViewById<ImageView>(R.id.img_fragment)
        var id = img.drawable

        img.setOnClickListener {
            getDialog(id)

        }
        return root
    }
    public fun getDialog(d: Drawable) {
        var dialog = Dialog(activity!!,R.style.MyTheme)
        dialog.setContentView(R.layout.full_img)
        var layoutParams: WindowManager.LayoutParams = dialog.window!!.attributes
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog.window!!.setLayout(width,height)
        dialog.window!!.attributes = layoutParams

        val image = dialog.img_full_view
        image.setImageDrawable(d)
        dialog.show()
        image.setOnClickListener {
            image.setImageDrawable(null)
            dialog.cancel()
        }

    }

}
