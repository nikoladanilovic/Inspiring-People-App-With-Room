package hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.InspiringPeopleCS
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.Model.InspiringPerson

@Database(version = 1, entities = arrayOf(InspiringPerson::class))
abstract class InspiringPeopleDatabase : RoomDatabase() {
    abstract fun peopleDAO() : InspiringPeopleDAO

    companion object{
        private const val NAME = "people_database"
        private var INSTANCE : InspiringPeopleDatabase? = null

        fun getInstance(): InspiringPeopleDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    InspiringPeopleCS.application,
                    InspiringPeopleDatabase::class.java,
                    NAME)
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as InspiringPeopleDatabase
        }
    }
}