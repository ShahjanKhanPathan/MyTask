package com.example.practicetest.map

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import com.example.practicetest.R
import com.example.practicetest.base.BaseActivity
import com.example.practicetest.databinding.ActivityGoogleMapBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class GoogleMapActivity : BaseActivity<ActivityGoogleMapBinding>(),OnMapReadyCallback {

    private var myLocation : Location? = null
    private lateinit var fusedLocation : FusedLocationProviderClient
    private lateinit var mMap : GoogleMap
    private val permissionCode = 101


    override fun getViewBinding() = ActivityGoogleMapBinding.inflate(layoutInflater)

    override fun initView() {
        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.googleMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
        LocationServices.getFusedLocationProviderClient(applicationContext)
       fusedLocation = LocationServices.getFusedLocationProviderClient(this)
    }

    private fun fetchLocation() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), permissionCode
            )
            return
        }

        val myTask = fusedLocation.lastLocation

        myTask.addOnSuccessListener {
            if (it != null){
                myLocation = it
                showToast("Here is the Altitude : ${it.altitude.toString()} & Longitude : ${it.longitude.toString()}")
            }

        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled = true
        setUpMap()
//        val latLong = LatLng(myLocation!!.latitude,myLocation!!.longitude)
//        val marker = MarkerOptions().position(latLong).title("Here you are!!")
//        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLong))
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLong,15f))
//        googleMap.addMarker(marker)
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), permissionCode
            )

            return
        }
        mMap.isMyLocationEnabled = true

        fusedLocation.lastLocation.addOnSuccessListener { location ->
            if (location != null){
                myLocation = location
                val currentLatlong = LatLng(location.latitude,location.longitude)
                mMap.animateCamera(CameraUpdateFactory.newLatLng(currentLatlong))
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatlong,15f))
                val marker = MarkerOptions().position(currentLatlong).title("Here's you are!!")
                mMap.addMarker(marker)

            }

        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            permissionCode -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                setUpMap()
            }
        }
    }


}