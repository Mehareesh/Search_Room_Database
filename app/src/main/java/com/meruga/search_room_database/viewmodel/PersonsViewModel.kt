package com.meruga.search_room_database.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meruga.search_room_database.database.Person
import com.meruga.search_room_database.repository.PersonRepository
import kotlinx.coroutines.launch

class PersonsViewModel(private val personRepository: PersonRepository): ViewModel() {

    val readAllPersons = personRepository.readAllPersons()

    fun insertData(person: Person) {
        viewModelScope.launch {
            personRepository.insertData(person)
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Person>> {
        return personRepository.searchDatabase(searchQuery)
    }
}