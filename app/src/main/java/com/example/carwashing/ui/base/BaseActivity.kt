package com.example.carwashing.ui.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.carwashing.BuildConfig
import com.example.carwashing.R

open class BaseActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @MainThread
    fun showToast(resId: Int) {
        if (resId <= 0) return
        Toast.makeText(this, resId, Toast.LENGTH_LONG).show()
    }

    @MainThread
    fun showToast(message: String?) {
        if (message == null) return
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


//    private fun logout() {
//        val intent = Intent(this, LoginActivity::class.java)
//
//        PreferenceManager.getDefaultSharedPreferences(this).edit {
//            clear()
//        }
//
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//        startActivity(intent)
//    }

    private fun showAboutDialog() {
        val version = BuildConfig.VERSION_NAME

        val message = if (BuildConfig.DEBUG) {
            "Тестовая версия №$version"
        } else {
            "Боевая версия №$version"
        }
        AlertDialog.Builder(this)
            .setTitle(R.string.title_about_app)
            .setMessage(message)
            .create()
            .show()
    }

    fun dismissKeyboard(view: View? = null) {
        val windowToken = view?.windowToken ?: findViewById<View>(android.R.id.content).rootView.windowToken
        val imm = getSystemService(
            Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

}