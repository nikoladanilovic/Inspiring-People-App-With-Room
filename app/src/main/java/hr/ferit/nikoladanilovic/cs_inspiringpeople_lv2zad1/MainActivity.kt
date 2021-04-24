package hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.Adapters.InspPeopleAdapter
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.Model.InspiringPerson
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.data.InspiringPeopleDatabase
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.data.PeopleRepository
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    val peopleDao = InspiringPeopleDatabase.getInstance().peopleDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val inputedPerson = intent.getSerializableExtra("inputToMain") as? InspiringPerson
        if(inputedPerson != null){
            PeopleRepository.insert(inputedPerson)
        }
         */


        //binding za recycler view
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.csPeopleDisplay.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mainBinding.csPeopleDisplay.itemAnimator = DefaultItemAnimator()
        mainBinding.csPeopleDisplay.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        initializePeople()
        displayData()



        //binding za button
        mainBinding.btnAddPerson.setOnClickListener{createNewPerson()}

        //Prikazi sve gore navedeno
        setContentView(mainBinding.root)
    }

    private fun initializePeople() {
        if(peopleDao.getAll().isEmpty()) {
            peopleDao.insert(
                InspiringPerson(
                    0,
                    "Linus Torvalds",
                    "28.12.1969.",
                    "",
                    "Founder of " +
                            "Linux kernel used by Linux operating systems. He also helped with development of GIT",
                    "https://upload.wikimedia.org/wikipedia/commons/0/01/LinuxCon_Europe_Linus_Torvalds_03_%28cropped%29.jpg",
                    "Talk is cheap, show me the code."
                )
            )
            peopleDao.insert(
                InspiringPerson(
                    0,
                    "Mark Zuckerberg",
                    "14.05.1984.",
                    "",
                    "Founder of massive social media company called Facebook.",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Mark_Zuckerberg_F8_2019_Keynote_%2832830578717%29_%28cropped%29.jpg/1200px-Mark_" +
                            "Zuckerberg_F8_2019_Keynote_%2832830578717%29_%28cropped%29.jpg",
                    "Move fast and brake things. Unless you are breaking stuff, you are not moving fast enough."
                )
            )
            peopleDao.insert(
                InspiringPerson(
                    0,
                    "Elon Musk",
                    "28.01.1971.",
                    "",
                    "Founder of PayPal, SpaceX, Tesla and many other companies.",
                    "https://upload.wikimedia.org/wikipedia/commons/8/85/Elon_Musk_Royal_Society_%28crop1%29.jpg",
                    "I think it is possible for ordinary people to choose to become extraordinary."
                )
            )
        }
    }


    //otvaranje novog aktivitija preko buttona
    private fun createNewPerson() {
        val newNoteIntent = Intent(this, inputNewPersonActivity::class.java)
        startActivity(newNoteIntent)
    }


    private fun displayData(){
        mainBinding.csPeopleDisplay.adapter = InspPeopleAdapter(peopleDao.getAll().toMutableList())
    }

}