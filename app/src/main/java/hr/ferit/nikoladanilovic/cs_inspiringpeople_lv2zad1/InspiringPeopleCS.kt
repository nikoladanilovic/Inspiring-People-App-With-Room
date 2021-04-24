package hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1

import android.app.Application

class InspiringPeopleCS : Application() {
    companion object {
        lateinit var application: InspiringPeopleCS
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}