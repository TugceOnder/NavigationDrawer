package com.company.navigationdrawbarexample

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction

open class MainActivity() : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener, Parcelable {
    lateinit var  homeFragment: HomeFragment
    lateinit var  workFragment: WorkFragment
    lateinit var settingFragment: SettingFragment
    lateinit var  timeLineFragment: TimeLineFragment
    lateinit var  logoutFragment: LogoutFragment
    lateinit var  schoolFragment: SchoolFragment

   private  var navview: NavigationView = findViewById(R.id.nav_view)
    private   var  toolbar: Toolbar =findViewById(R.id.toolBar)
    private var  drawerLayout:DrawerLayout=findViewById(R.id.drawerLayout)

    constructor(parcel: Parcel) : this() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title= "Navigation Drawer"
        val drawerToggle :ActionBarDrawerToggle = object : ActionBarDrawerToggle (this,drawerLayout,toolbar,(R.string.open),(R.string.close)){

        }
        drawerToggle.isDrawerIndicatorEnabled =true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

       navview.setNavigationItemSelectedListener (this)

        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()


    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId){
            R.id.home -> {
                homeFragment = HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout,homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }

            R.id.work -> {
                workFragment= WorkFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout,workFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.school -> {
                schoolFragment = SchoolFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout,schoolFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }

            R.id.timeline -> {
                timeLineFragment = TimeLineFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout,timeLineFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }

            R.id.setting -> {
               settingFragment= SettingFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout,settingFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }

            R.id.logout -> {
                logoutFragment= LogoutFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout,logoutFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }

        }
         drawerLayout.closeDrawer(GravityCompat.START)
        return  true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else {
        super.onBackPressed() }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}