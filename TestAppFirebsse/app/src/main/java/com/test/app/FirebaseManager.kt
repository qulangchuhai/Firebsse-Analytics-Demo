package com.test.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class FirebaseManager {
    companion object {
        var firebaseInstanceId = ""

        @SuppressLint("MissingPermission")
        fun init(application: Application) {
            FirebaseAnalytics.getInstance(application).appInstanceId.addOnCompleteListener {
                if (it.result != null) {
                    firebaseInstanceId = it.result?:""
                }
            }
        }


        @SuppressLint("MissingPermission")
        fun Context?.firebaseTrack(event: String?, params: Map<String?, Any?>? = null) {
            this ?: return
            if (event.isNullOrEmpty()) {
                return
            }
            FirebaseAnalytics.getInstance(this).logEvent(event, Bundle().apply {
                //putString("参数名","参数值")
                params?.forEach {
                    if (it.key.orEmpty().isNotEmpty()) {
                        putString(it.key.orEmpty(), it.value.toString().orEmpty())
                    }
                }
            })
        }
    }
}