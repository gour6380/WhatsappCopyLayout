package com.biti.whatsapplayout

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.View
import android.view.WindowManager
import android.view.animation.TranslateAnimation
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal var cameraFragment: CameraFragment? = null
    internal var chatsFragment: ChatsFragment? = null
    internal var statusFragment: StatusFragment? = null
    internal var callsFragment: CallsFragment? = null

    internal var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.app_name)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.navigationBarColor = resources.getColor(android.R.color.black)
        }
        viewPager.adapter = MainAdapter(supportFragmentManager)
        viewPager.setCurrentItem(1, true)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    translateUp()
                    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                            WindowManager.LayoutParams.FLAG_FULLSCREEN)
                    fab.visibility = View.GONE
                } else if (flag) {
                    translateDown()
                    fab.visibility = View.VISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
        tab_layout.setupWithViewPager(viewPager)
        setupTabLayout()

    }


    private fun setupTabLayout() {
        val layout = (tab_layout.getChildAt(0) as LinearLayout).getChildAt(0) as LinearLayout
        val layoutParams = layout.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 0.4f
        layout.layoutParams = layoutParams
        tab_layout.getTabAt(0)!!.icon = resources.getDrawable(R.drawable.ic_camera)
    }

    private fun translateUp() {
        val up = TranslateAnimation(0f, 0f, 0f, -280f)
        app_bar.animation = up
        up.duration = 150
        up.fillAfter = true
        up.start()
        flag = true
    }

    private fun translateDown() {
        val up = TranslateAnimation(0f, 0f, -280f, 0f)
        app_bar.animation = up
        up.duration = 150
        up.fillAfter = true
        up.start()
        flag = false
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private inner class MainAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            if (position == 0) {
                if (cameraFragment == null) {
                    cameraFragment = CameraFragment()
                    return cameraFragment
                }
                return cameraFragment
            }
            if (position == 1) {
                if (chatsFragment == null) {
                    chatsFragment = ChatsFragment()
                    return chatsFragment
                }
                return chatsFragment
            }
            if (position == 2) {
                if (statusFragment == null) {
                    statusFragment = StatusFragment()
                    return statusFragment
                }
                return statusFragment
            }
            if (position == 3) {
                if (callsFragment == null) {
                    callsFragment = CallsFragment()
                    return callsFragment
                }
                return callsFragment
            }
            return null
        }

        override fun getPageTitle(position: Int): CharSequence? {
            if (position == 0)
                return ""
            if (position == 1)
                return resources.getString(R.string.chats_text)
            if (position == 2)
                return resources.getString(R.string.status_text)
            return if (position == 3) resources.getString(R.string.calls_text) else null
        }

        override fun getCount(): Int {
            return 4
        }
    }
}
