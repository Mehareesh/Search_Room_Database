package com.meruga.search_room_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.meruga.search_room_database.adapter.PersonAdapter
import com.meruga.search_room_database.database.Person
import com.meruga.search_room_database.databinding.ActivityMainBinding
import com.meruga.search_room_database.viewmodel.PersonViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var personViewModel: PersonViewModel

    private val personAdapter: PersonAdapter by lazy { PersonAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = personAdapter

        personViewModel = ViewModelProvider(this)[PersonViewModel::class.java]
        // This data insertion should be dynamic in real use case
        for (person in createPersonData()) {
            personViewModel.insertData(person)
        }
        personViewModel.readAllPersons.observe(this) {
            personAdapter.setData(it)
        }
    }

    private fun createPersonData(): ArrayList<Person> {
        return ArrayList<Person>().apply {
            add(Person(0, "Van", "Heusen", 25))
            add(Person(0, "Allen", "Solly", 31))
            add(Person(0, "Calvin", "Klein", 28))
            add(Person(0, "Flying", "Machine", 24))
            add(Person(0, "John", "Players", 35))
            add(Person(0, "Louis", "Philippe", 29))
            add(Person(0, "Monte", "Carlo", 26))
            add(Person(0, "Peter", "England", 32))
            add(Person(0, "Pepe", "Jeans", 22))
            add(Person(0, "Indian", "Terrain", 34))
            add(Person(0, "Park", "Avenue", 19))
            add(Person(0, "Indigo", "Nation", 21))
            add(Person(0, "Bare", "Denim", 18))
        }
    }
}