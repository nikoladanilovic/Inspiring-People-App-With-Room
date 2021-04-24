package hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.Model.InspiringPerson
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.data.InspiringPeopleDAO
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.data.InspiringPeopleDatabase
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.databinding.ActivityInputNewPersonBinding

class inputNewPersonActivity : AppCompatActivity() {

    private lateinit var inputBinding : ActivityInputNewPersonBinding
    val peopleDao = InspiringPeopleDatabase.getInstance().peopleDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inputBinding = ActivityInputNewPersonBinding.inflate(layoutInflater)
        inputBinding.btnInputAddPerson.setOnClickListener { addNewPersonToRecyclerView() }
        setContentView(inputBinding.root)

    }

    private fun addNewPersonToRecyclerView() {

        // tu treba dodati inicijalizaciju za poznat citate
        val newPerson = InspiringPerson(0, inputBinding.etInputFullName.text.toString()
                ,inputBinding.etInputDateOfBirth.text.toString()
                ,inputBinding.etInputDateOfDeath.text.toString()
                ,inputBinding.etInputPersonDesc.text.toString()
                ,inputBinding.etInputImageURL.text.toString()
                ,inputBinding.etInputQuote.text.toString())

        peopleDao.insert(newPerson)

        val intentToMain = Intent(this, MainActivity::class.java)
        startActivity(intentToMain)
    }
}