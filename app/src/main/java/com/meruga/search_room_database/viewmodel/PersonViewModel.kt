package com.meruga.search_room_database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.meruga.search_room_database.database.Person
import com.meruga.search_room_database.database.PersonDatabase
import com.meruga.search_room_database.repository.PersonRepository
import kotlinx.coroutines.launch

class PersonViewModel(application: Application): AndroidViewModel(application) {

    val readAllPersons: LiveData<List<Person>>
    private val personRepository: PersonRepository

    init {
        val personDao = PersonDatabase.getDataBase(application.applicationContext).getPersonDao()
        personRepository = PersonRepository(personDao)
        readAllPersons = personRepository.readAllPersons()
    }

    fun insertData(person: Person) {
        viewModelScope.launch {
            personRepository.insertData(person)
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Person>> {
        return personRepository.searchDatabase(searchQuery)
    }
}