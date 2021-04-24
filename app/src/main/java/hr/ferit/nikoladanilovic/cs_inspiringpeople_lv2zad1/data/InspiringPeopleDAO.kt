package hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.data

import androidx.room.*
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.Model.InspiringPerson

@Dao
interface InspiringPeopleDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(people: InspiringPerson)

    @Delete
    fun delete(people: InspiringPerson)

    @Query("SELECT * FROM people")
    fun getAll(): List<InspiringPerson>
}