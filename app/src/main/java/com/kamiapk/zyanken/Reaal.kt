package com.kamiapk.zyanken

import android.app.Application
import io.realm.Realm

class Reaal :Application(){
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}