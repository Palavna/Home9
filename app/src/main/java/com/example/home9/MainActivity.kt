package com.example.home9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.isInvisible
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager2
    private lateinit var btnNext: Button
    private lateinit var btnPrev: Button
    private lateinit var btnSkip: Button
    private lateinit var pins: TabLayout
    private lateinit var btnEnd: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initListeners()
        initViewPager()
    }
    private fun initViews(){
        pager = findViewById(R.id.pager)
        btnNext = findViewById(R.id.btnNext)
        btnPrev = findViewById(R.id.btnPrev)
        btnSkip = findViewById(R.id.btnSkip)
        pins = findViewById(R.id.pins)
        btnEnd = findViewById(R.id.btnEnd)
    }
    private fun initListeners(){
        btnNext.setOnClickListener { pager.currentItem += 1}
        btnPrev.setOnClickListener { pager.currentItem -= 1}
        btnEnd.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        btnSkip.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
        }
        pager.onPageChange { changePageOnViewPager(it) }
    }
    private fun initViewPager(){
        pager.adapter = PagerAdapter(getAdapterData())
        TabLayoutMediator(pins, pager) { _, _ -> }.attach()
    }

    private fun changePageOnViewPager(position: Int) {
        when {
            position == 0 -> {
                btnPrev.isInvisible = true
                btnEnd.isInvisible = false
                position == 0
                btnEnd.isInvisible = true
            }
            position + 1 == pager.adapter?.itemCount -> {
                btnNext.isInvisible = true
                btnEnd.isInvisible = false
            }
            else -> {
                btnPrev.isInvisible = false
                btnNext.isInvisible = false
                btnEnd.isInvisible = true
                }
            }
        }
    }
    private fun getAdapterData(): ArrayList<OnBoardModel> {
        val dataList = arrayListOf<OnBoardModel>()
        dataList.add(
            OnBoardModel(
                "Welcome to Hermes",
                R.drawable.ic_baseline_question_answer_24,
                "Mobile IRC made simple and fun",
                R.color.grey1,
                "online",
                R.drawable.ic_baseline_directions_bike_24,
                "Get Starteg",
                R.drawable.ic_baseline_hail_24
            )
        )
        dataList.add(
            OnBoardModel(
                "Your rooms and channels, all organised",
                R.drawable.ic_baseline_article_24,
                "Make your life simpler with auto",
                R.color.blu2,
                "online",
                R.drawable.ic_baseline_directions_bike_24,
                "Get Starteg",
                R.drawable.ic_baseline_hail_24
            )
        )

        dataList.add(
            OnBoardModel(
                "Expresss yourself with emojis",
                R.drawable.ic_baseline_insert_emoticon_24,
                "Send a smiley or two for those moments",
                R.color.purple3,
                "online",
                R.drawable.ic_baseline_directions_bike_24,
                "Get Starteg",
                R.drawable.ic_baseline_hail_24
            )
        )

        dataList.add(
            OnBoardModel(
                "You are all set. Enjoy Hermes",
                R.drawable.ic_baseline_check_circle_outline_24,
                "GET STARTED",
                R.color.teal_200,
                "online",
                R.drawable.ic_baseline_directions_bike_24,
                "Get Starteg",
                R.drawable.ic_baseline_hail_24
            )
        )
        dataList.add(
            OnBoardModel(
                "You are all set. Enjoy Hermes",
                R.drawable.ic_baseline_check_circle_outline_24,
                "GET STARTED",
                R.color.teal_200,
                "online",
            R.drawable.ic_baseline_directions_bike_24,
                "Get Starteg",
                R.drawable.ic_baseline_hail_24
            )
        )
        dataList.add(
            OnBoardModel(
                "You are all set. Enjoy Hermes",
                R.drawable.ic_baseline_check_circle_outline_24,
                "GET STARTED",
                R.color.teal_200,
                "online",
                R.drawable.ic_baseline_directions_bike_24,
                "Get Starteg",
                R.drawable.ic_baseline_hail_24
            )
        )

        return dataList
    }

