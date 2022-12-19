package com.meruga.search_room_database.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meruga.search_room_database.R
import com.meruga.search_room_database.database.Person
import kotlinx.android.synthetic.main.row_layout.view.*

class PersonAdapter: RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    private var existingData = emptyList<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = existingData[position]
        holder.itemView.firstName_textView.text = person.firstName
        holder.itemView.lastName_textView.text = person.lastName
        holder.itemView.age_textView.text = person.age.toString()
        TODO("profilePicture Not yet implemented")
    }

    override fun getItemCount(): Int {
        return existingData.size
    }

    fun setData(newData: List<Person>) {
        existingData = newData
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}