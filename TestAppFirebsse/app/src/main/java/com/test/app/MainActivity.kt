package com.test.app

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.test.app.FirebaseManager.Companion.firebaseTrack
import com.test.app.firebase.R

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        findViewById<View>(R.id.click_1_id).setOnClickListener {
            firebaseTrack("click_event1")
        }
        findViewById<View>(R.id.click_2_id).setOnClickListener {
            val map = HashMap<String?,Any?>()
            map["param1"] = "value1"
            map["param2"] = "value2"
            firebaseTrack("click_event2",map)

        }
    }
}

