package com.bignerdranch.android.criminalintent

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import java.io.File
import java.util.zip.Inflater


class ImageDialogFragment(
    val photofile : File) : DialogFragment() {

    private lateinit var imageView: ImageView

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.image_dialog_fragment, container, false)
        imageView = view.findViewById(R.id.imageView) as ImageView

        val image = getScaledBitmap(photofile.path, requireActivity())
        imageView.setImageBitmap(image)

        return view
    }

    @RequiresApi(Build.VERSION_CODES.R)
    fun getScaledBitmap(path: String, activity: Activity): Bitmap {
        val size = Point()
        val display = activity.display
        display?.getRealSize(size)
        return getScaledBitmap(path, size.x, size.y)
    }
}