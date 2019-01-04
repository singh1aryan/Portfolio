package com.himanshurawat.portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import com.himanshurawat.portfolio.ui.MainActivityContract
import com.himanshurawat.portfolio.ui.MainActivityPresenterImpl
import com.himanshurawat.portfolio.ui.education.EducationFragment
import com.himanshurawat.portfolio.ui.education.WorkExFragment
import com.himanshurawat.portfolio.ui.main.PortfolioMakerEventListener
import com.himanshurawat.portfolio.ui.personal.PersonalFragment

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), View.OnTouchListener, PortfolioMakerEventListener, MainActivityContract.View {



    private lateinit var presenter: MainActivityContract.Presenter

    private lateinit var fragmentManager: androidx.fragment.app.FragmentManager

    private var activeFragment: String = "PersonalFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        presenter = MainActivityPresenterImpl(this)

        fragmentManager = supportFragmentManager
        activity_main_seekbar.progress = 20
        activity_main_seekbar.setOnTouchListener(this)

        setup()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setup(){
        fragmentManager.beginTransaction().
                replace(R.id.content_main_frame_layout_container, PersonalFragment(),"PersonalFragment").
                addToBackStack("PersonalFragment").
                commit()
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if(v != null && v.id == activity_main_seekbar.id){
            return true
        }
        return false
    }

    override fun loadPersonalFragment() {
        fragmentManager.beginTransaction().
            replace(R.id.content_main_frame_layout_container, PersonalFragment(),"PersonalFragment").
            addToBackStack("PersonalFragment").
            commit()
    }

    override fun loadEducationFragment() {
        fragmentManager.beginTransaction().
                replace(R.id.content_main_frame_layout_container,EducationFragment(),"EducationFragment").
                addToBackStack("EducationFragment").
                commit()
    }


    override fun loadWorkExFragment() {
        fragmentManager.beginTransaction().
            replace(R.id.content_main_frame_layout_container,WorkExFragment(),"WorkExFragment").
            addToBackStack("WorkExFragment").
            commit()
    }

    override fun popToEducationFragment() {
        fragmentManager.popBackStack("EducationFragment",0)
    }

    override fun popToWorkExFragment() {
        fragmentManager.popBackStack("WorkExFragment",0)
    }

    override fun popToPersonalFragment() {
        fragmentManager.popBackStack("PersonalFragment", 0)
    }

    override fun popFragment() {
        fragmentManager.popBackStack()
    }

    override fun updateSeekbar(progress: Int) {
        activity_main_seekbar.progress = progress
    }

    override fun updateStepTextView(step: String) {
        activity_main_step_text_view.text = step
    }

    override fun updateStepTitleTextView(title: String) {
        activity_main_step_title_text_view.text = title
    }

    override fun nextQuestionButtonClicked(from: String) {
        activeFragment = presenter.nextFragment(from)
    }

    override fun backButtonClicked(from: String) {
        activeFragment = presenter.previousFragment(from)
    }


    override fun onBackPressed() {
        val count = fragmentManager.backStackEntryCount
        if(count == 0){
            super.onBackPressed()
        }
        if(count == 1){
            finish()
        }
        else{
            presenter.previousFragment(activeFragment)
        }


    }

}
