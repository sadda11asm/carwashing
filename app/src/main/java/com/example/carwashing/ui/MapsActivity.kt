package com.example.carwashing.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

import com.example.carwashing.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.example.carwashing.common.NavigationController
import com.example.carwashing.ui.base.BaseActivity
import com.facebook.accountkit.ui.AccountKitActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_maps.*
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.ext.android.bindScope
import org.koin.androidx.scope.ext.android.getOrCreateScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {

    private val mainSharedViewModel: MainViewModel by viewModel()
    private val navigationController: NavigationController by inject{ parametersOf(this) }


    private lateinit var mMap: GoogleMap
    private val arrayPlaces = arrayOf(LatLng(51.142067, 71.421842), LatLng(51.151115, 71.388013), LatLng(51.155410, 71.436438), LatLng(51.160247, 71.461346), LatLng(51.142280, 71.462954), LatLng(51.172616, 71.436646), LatLng(51.172203, 71.402248), LatLng(51.143472, 71.448505))
    private val arrayNames = arrayOf("Johns Wash", "Car Wash", "Calypso", "Столичная", "Good Wash", "Автопати", "Бумер", "Top Gear")
    private val arrayStars = arrayOf("Rating: 5.0", "Rating: 5.0", "Rating: 5.0", "Rating: 5.0", "Rating: 5.0", "Rating: 5.0", "Rating: 5.0", "Rating: 5.0")

    private lateinit var bottom: BottomNavigationView
    private lateinit var container: FrameLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        bindScope(getOrCreateScope("main"))
        setSupportActionBar(toolbar)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        container = findViewById(R.id.main_fragment_container)
        container.visibility = View.GONE

        mainSharedViewModel.setCarWashes()
        bottom = findViewById(R.id.bottom)
        bottom.setOnNavigationItemSelectedListener { item ->
            when (item.getItemId()) {
                R.id.action_map -> {
                    container.visibility = View.GONE
                    Toast.makeText(this, "map", Toast.LENGTH_SHORT).show()

                }
                R.id.action_carwashes -> {
                    navigationController.navigateToCarWashes()
                    container.visibility = View.VISIBLE
                    Toast.makeText(this, "carwashes", Toast.LENGTH_SHORT).show()
                }
                R.id.action_profile -> {
//                    navigationController.navigateToProfile()
                }
            }
            true
        }


    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(51.0908, 71.3991)))


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, Array(Manifest.permission.ACCESS_FINE_LOCATION.length){Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return
        }else{
            mMap.isMyLocationEnabled = true
            mMap.setOnMyLocationButtonClickListener(this)
            mMap.setOnMyLocationClickListener(this)
            mMap.uiSettings.isZoomControlsEnabled = true
            mMap.uiSettings.isIndoorLevelPickerEnabled = true
            mMap.setMinZoomPreference(12.0f)
        }
        for(i in 0 until arrayNames.size) {
            mMap.addMarker(MarkerOptions()
                .position(arrayPlaces.get(i))
                .title(arrayNames.get(i))
                .snippet(arrayStars.get(i)))
        }
    }

    override fun onMyLocationClick(location: Location) {
        Toast.makeText(this, "Current location:\n$location", Toast.LENGTH_LONG).show()
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show()
        return false
    }

    companion object {
        fun open(context: Context){
            var intent = Intent(context, MapsActivity::class.java)
            context.startActivity(intent)
        }
    }
}
