package com.meruga.search_room_database.repository

import androidx.lifecycle.LiveData
import com.meruga.search_room_database.database.Person
import com.meruga.search_room_database.database.PersonDao

class PersonRepository(private val personDao: PersonDao) {

    fun readAllPersons(): LiveData<List<Person>> {
        return personDao.readAllPersons()
    }

    suspend fun insertData(person: Person) {
        personDao.insertData(person)
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Person>> {
        return personDao.searchDatabase(searchQuery)
    }
}