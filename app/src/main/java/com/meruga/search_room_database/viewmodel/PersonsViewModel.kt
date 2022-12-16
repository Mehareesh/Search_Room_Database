package com.meruga.search_room_database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.meruga.search_room_database.database.Person
import com.meruga.search_room_database.database.PersonDatabase
import com.meruga.search_room_database.repository.PersonRepository
import kotlinx.coroutines.launch

class PersonsViewModel(application: Application): AndroidViewModel(application) {

    private val personRepository: PersonRepository
    private val readAllPersons: LiveData<List<Person>>

    init {
        val personDao = PersonDatabase.getDataBase(application).getPersonDao()
        personRepository = PersonRepository(personDao)
        readAllPersons = personRepository.readAllData
    }

    fun addPerson(person: Person) {
        viewModelScope.launch {
            personRepository.addPerson(person)
        }
    }

    fun deletePerson(person: Person) {
        viewModelScope.launch {
            personRepository.deletePerson(person)
        }
    }

    fun updatePerson(person: Person) {
        viewModelScope.launch {
            personRepository.updatePerson(person)
        }
    }

    fun deleteAllPersons(person: Person) {
        viewModelScope.launch {
            personRepository.deleteAllPersons()
        }
    }
}