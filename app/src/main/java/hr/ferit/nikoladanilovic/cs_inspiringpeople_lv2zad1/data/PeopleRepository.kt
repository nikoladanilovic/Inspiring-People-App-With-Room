package hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.data

import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.Model.InspiringPerson

object PeopleRepository {
    val people : MutableList<InspiringPerson>

    init {
        people = retrivePeople()
    }

    private fun retrivePeople(): MutableList<InspiringPerson> {
        return mutableListOf(InspiringPerson(0, "Linus Torvalds", "28.12.1969.", "","Founder of " +
                "Linux kernel used by Linux operating systems. He also helped with development of GIT",
            "https://upload.wikimedia.org/wikipedia/commons/0/01/LinuxCon_Europe_Linus_Torvalds_03_%28cropped%29.jpg", "Talk is cheap, show me the code."),
            InspiringPerson(0,"Mark Zuckerberg", "14.05.1984.", "", "Founder of massive social media company called Facebook.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Mark_Zuckerberg_F8_2019_Keynote_%2832830578717%29_%28cropped%29.jpg/1200px-Mark_" +
                    "Zuckerberg_F8_2019_Keynote_%2832830578717%29_%28cropped%29.jpg", "Move fast and brake things. Unless you are breaking stuff, you are not moving fast enough."),
            InspiringPerson(0,"Elon Musk", "28.01.1971.", "", "Founder of PayPal, SpaceX, Tesla and many other companies.",
            "https://upload.wikimedia.org/wikipedia/commons/8/85/Elon_Musk_Royal_Society_%28crop1%29.jpg", "I think it is possible for ordinary people to choose to become extraordinary.")
        )
    }

    fun getInspiringPeople(): MutableList<InspiringPerson> {
        return people
    }
    fun getInspiringPerson(name: String): InspiringPerson = people.first { it -> it.name == name }
    fun insert(person: InspiringPerson) = people.add(person)
    fun delete(person: InspiringPerson) = people.remove(person)

}