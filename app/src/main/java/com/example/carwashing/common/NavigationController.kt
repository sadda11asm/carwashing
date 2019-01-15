package com.example.carwashing.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.carwashing.R
import com.example.carwashing.ui.MapsActivity
import com.example.carwashing.ui.carwash.CarWashFragment

class NavigationController (
    mapsActivity: MapsActivity
) {

    private val containerId = R.id.main_fragment_container
    private val fragmentManager: FragmentManager = mapsActivity.supportFragmentManager

    fun navigateToCarWashes() {
        val fragment = CarWashFragment.newInstance()
        fragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack(CarWashFragment.TAG)
            .replace(containerId, fragment, CarWashFragment.TAG)
            .commitAllowingStateLoss()
    }
//
//    fun navigateProfile() {
//        val fragment = ProfileFragment.newInstance()
//        fragmentManager.beginTransaction()
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            .addToBackStack(ProfileFragment.TAG)
//            .replace(containerId, fragment, ProfileFragment.TAG)
//            .commitAllowingStateLoss()
//
//
//    }
//
//    fun navigateCheckList(selectedObjectId: Int) {
//        val fragment = CheckListFragment.newInstance(selectedObjectId)
//        fragmentManager.beginTransaction()
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            .addToBackStack(CheckListFragment.TAG)
//            .replace(containerId, fragment, CheckListFragment.TAG)
//            .commitAllowingStateLoss()
//    }
//
//    fun navigateSubjectDetail() {
//        val fragment = SubjectDetailFragment.newInstance()
//        fragmentManager.beginTransaction()
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            .addToBackStack(SubjectDetailFragment.TAG)
//            .replace(containerId, fragment, SubjectDetailFragment.TAG)
//            .commitAllowingStateLoss()
//    }
//
//    fun navigateObjectList(fragment: Fragment){
//        val newFragment = ObjectListFragment.newInstance()
//        fragment.childFragmentManager.beginTransaction()
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            .addToBackStack(ObjectListFragment.TAG)
//            .replace(nestedContainerId, newFragment, ObjectListFragment.TAG)
//            .commitAllowingStateLoss()
//    }
//
//    fun navigateTalonFragment(fragment: Fragment){
//        val newFragment = TalonFragment.newInstance()
//        fragment.childFragmentManager.beginTransaction()
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            .addToBackStack(TalonFragment.TAG)
//            .replace(nestedContainerId, newFragment, TalonFragment.TAG)
//            .commitAllowingStateLoss()
//    }
//
//    fun navigateCriteriaList(selectedObjectId: Int, selectedCriteriaListId: Int) {
//        val fragment = CriteriaListFragment.newInstance(selectedObjectId, selectedCriteriaListId)
//        fragmentManager.beginTransaction()
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            .addToBackStack(CriteriaListFragment.TAG)
//            .replace(containerId, fragment, CriteriaListFragment.TAG)
//            .commitAllowingStateLoss()
//    }
//
//    fun navigateAct(fragment: Fragment) {
//        val newFragment = ActFragment.newInstance()
//        fragment.childFragmentManager.beginTransaction()
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            .addToBackStack(ActFragment.TAG)
//            .replace(nestedContainerId, newFragment, ActFragment.TAG)
//            .commitAllowingStateLoss()
//    }
//
//    fun navigateRequisites() {
//        val newFragment = RequisitesFragment.newInstance()
//        fragmentManager.beginTransaction()
//            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            .addToBackStack(RequisitesFragment.TAG)
//            .replace(containerId, newFragment, RequisitesFragment.TAG)
//            .commitAllowingStateLoss()
//    }
//
//    fun popChildBackStack(fragment: Fragment){
//        if(fragment.childFragmentManager.backStackEntryCount > 1){
//            fragment.childFragmentManager.popBackStack()
//        }
//    }
//    fun setStep(mstep: Int) {
//        step = mstep
//    }
//    fun getStep(): Int {
//        return step
//    }


}