package com.example.carwashing.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.carwashing.common.NavigationController
import com.example.carwashing.common.autoCleared
import com.example.carwashing.databinding.FragmentCarwashBinding
import com.example.carwashing.databinding.FragmentProfileBinding
import com.example.carwashing.ui.MainViewModel
import com.example.carwashing.ui.base.BaseFragment
import com.example.carwashing.vo.CarWash
import kotlinx.android.synthetic.main.item_carwash.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KProperty



class ProfileFragment : BaseFragment(){


    private val mainSharedViewModel: MainViewModel by sharedViewModel()
    private var binding: FragmentProfileBinding by autoCleared()
    private val navigationController: NavigationController by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        mainSharedViewModel.carWashList.observe(viewLifecycleOwner, Observer {
//            if (it == null) {
//                return@Observer
//            }
//            initViews(it)
//        })
    }

    private fun initViews(carwashes: List<CarWash>) {
//        Log.v("INITVIEWS", "de")

        binding.apply {
//            recycler.adapter = adapter
        }
    }
    companion object {
        const val TAG = "CarWashFragment"
        @JvmStatic
        fun newInstance() =
            ProfileFragment().apply {

            }
    }

}

