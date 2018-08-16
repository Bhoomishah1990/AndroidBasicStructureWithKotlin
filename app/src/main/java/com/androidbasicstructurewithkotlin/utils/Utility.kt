package com.androidbasicstructurewithkotlin.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Build
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView


/**
 * Created by imobdev-darshna on 26/3/18.
 */
object Utility {

    fun hasInternet(context: Context): Boolean {
        val connectivityManager = context.getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }

    fun getText(textView: TextView): String {
        return textView.text.toString().trim()
        //return textView.text.toString().trim { it <= ' ' }
    }

    fun showKeyboard(activity: Activity?, view: EditText) {
        try {
            if (activity != null) {
                val inputManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
            }
        } catch (e: Exception) {
            Log.e("Exception on  show", e.toString())
        }
    }

    fun hideKeyboard(ctx: Activity) {
        if (ctx.currentFocus != null) {
            val imm = ctx.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(ctx.currentFocus!!.windowToken, 0)
        }
    }

    fun requestEditTextFocus(activity: Activity, view: EditText) {
        view.requestFocus()
        showKeyboard(activity, view)
    }

    fun showSnackBar(v: View, msg: String) {
        val mSnackBar = Snackbar.make(v, msg, Snackbar.LENGTH_LONG)
        val view = mSnackBar.view
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP
        view.layoutParams = params
        view.setBackgroundColor(Color.DKGRAY)
        val mainTextView = view.findViewById<TextView>(android.support.design.R.id.snackbar_text)
        // val mainTextView: TextView = view.findViewById(android.support.design.R.id.snackbar_text)
        mainTextView.setTextColor(Color.WHITE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mainTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        }
        mainTextView.gravity = Gravity.CENTER_HORIZONTAL
        mSnackBar.show()
    }
}