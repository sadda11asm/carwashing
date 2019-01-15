package com.example.carwashing.ui.base

import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.IBinder
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*
import android.graphics.Color.parseColor
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.carwashing.R
import com.example.carwashing.util.HasToolbar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.abc_list_menu_item_radio.*


abstract class BaseFragment : Fragment(), HasToolbar {

    override val toolbar by lazy { activity?.findViewById<Toolbar>(R.id.toolbar)!! }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        constructToolbar()
    }

    open fun constructToolbar(){

    }

    fun showMaterialDatePicker(editText: EditText, datePattern: String, minDate: Long, maxDate: Long) {
        if (!isAdded) return
        val calendar = Calendar.getInstance()
        val dialog = DatePickerDialog(context!!,
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    calendar.set(Calendar.YEAR, year)
                    calendar.set(Calendar.MONTH, monthOfYear)
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    val dateFormat = SimpleDateFormat(datePattern, Locale.getDefault())

                    editText.setText(dateFormat.format(calendar.time))
                }, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
        // first, select year
        dialog.datePicker.touchables[0].performClick()
        dialog.datePicker.maxDate = maxDate //calendar.timeInMillis
        dialog.datePicker.minDate = minDate
        dialog.setTitle("")
        dialog.show()
    }

//    fun showIosDatePicker(minDate: Long = 631152060000, maxDate: Long = 18303062460000, callback: (date: Date) -> Unit){
//        DatePickerPopWin.Builder(context,
//            DatePickerPopWin.OnDatePickedListener { year, month, day, dateDesc ->
//                val date = Calendar.getInstance()
//                date.set(year, month-1, day)
//                callback(date.time)
//            }).textConfirm("CONFIRM") //text of confirm button
//            .textCancel("CANCEL") //text of cancel button
//            .btnTextSize(16) // button text size
//            .viewTextSize(25) // pick view text size
//            .colorCancel(ContextCompat.getColor(requireContext(), R.color.disabled_grey)) //color of cancel button
//            .colorConfirm(ContextCompat.getColor(requireContext(), R.color.accent)) //color of confirm button
//            .minDate(minDate)
//            .maxDate(maxDate)
//            //.showDayMonthYear(true) // shows like dd mm yyyy (default is false)
//            .dateChose("2013-11-11") // date chose when init popwindow
//            .build()
//            .showPopWin(activity)
//    }

    fun dismissKeyboard(windowToken: IBinder?) {
        if (windowToken == null) return

        val activity = activity
        if (activity != null) {
            val imm = activity.getSystemService(
                    Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }
    }

    fun showToast(stringId: Int?) {
        if (!isAdded || stringId == null || stringId <= 0) return
        Toast.makeText(activity, stringId, Toast.LENGTH_LONG).show()
    }

//    fun showSnackBar(stringId: Int){
//        Snackbar.make(view!!, stringId, Snackbar.LENGTH_LONG).show()
//    }

    fun showToast(message: String?) {
        if (!isAdded || message == null) return
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

}
