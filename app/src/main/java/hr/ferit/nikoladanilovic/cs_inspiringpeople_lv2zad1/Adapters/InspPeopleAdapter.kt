package hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.Model.InspiringPerson
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.R

class InspPeopleAdapter (people: MutableList<InspiringPerson>): RecyclerView.Adapter<InspPeopleHolder>() {
    private val people: MutableList<InspiringPerson>

    init {
        this.people = mutableListOf()
        this.people.addAll(people)
    }

    fun refreshData(people: MutableList<InspiringPerson>){
        this.people.clear()
        this.people.addAll(people)
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return people.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspPeopleHolder {
        val peopleView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_inspiring_person, parent, false)
        val peopleHolder = InspPeopleHolder(peopleView)
        return peopleHolder
    }

    override fun onBindViewHolder(holder: InspPeopleHolder, position: Int) {
        val person = people[position]
        holder.bind(person)
    }
}