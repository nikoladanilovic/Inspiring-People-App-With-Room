package hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.Adapters

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.InspiringPeopleCS
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.MainActivity
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.Model.InspiringPerson
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.R
import hr.ferit.nikoladanilovic.cs_inspiringpeople_lv2zad1.databinding.ItemInspiringPersonBinding


class InspPeopleHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(person: InspiringPerson) {
        val itemBinding = ItemInspiringPersonBinding.bind(itemView)
        Picasso.get()
            .load(person.cover)
            .fit()
            .placeholder(R.drawable.ic_launcher_background)
            .error(android.R.drawable.stat_notify_error)
            .into(itemBinding.imvInspPersonImg)
        itemBinding.tvDates.text = "Born on " + person.dateOfBirth + parseDateOfDeath(person.dateOfDeath)
        itemBinding.tvPersonDesc.text = person.name + ": " + person.description

        itemBinding.imvInspPersonImg.setOnClickListener { Toast.makeText(itemView.context, person.quote, Toast.LENGTH_LONG).show() }
    }

    fun parseDateOfDeath(date : String) : String {
        val parsedDate = ",  and died on " + date
        if(TextUtils.isEmpty(date)){
            return date
        }
        else
        {
            return parsedDate
        }
    }
}