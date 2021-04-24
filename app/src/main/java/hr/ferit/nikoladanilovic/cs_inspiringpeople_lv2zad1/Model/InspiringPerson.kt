package hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "people")
data class InspiringPerson (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "dateOfBirth") val dateOfBirth : String,
    @ColumnInfo(name = "dateOfDeath") val dateOfDeath : String,
    @ColumnInfo(name = "description") val description : String,
    @ColumnInfo(name = "cover") val cover : String,
    @ColumnInfo(name = "quote") val quote : String
) : Serializable

// tu treba dodati jos jedan dio klase -> poznati citati tih osoba