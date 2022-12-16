package com.meruga.search_room_database.repository

import androidx.lifecycle.LiveData
import com.meruga.search_room_database.database.Person
import com.meruga.search_room_database.database.PersonDao

class PersonRepository(private val personDao: PersonDao) {

    val readAllData: LiveData<List<Person>> = personDao.readAllPersons()

    suspend fun addPerson(person: Person) {
        personDao.addPerson(person)
    }

    suspend fun updatePerson(person: Person) {
        personDao.updatePerson(person)
    }

    suspend fun deletePerson(person: Person) {
        personDao.deletePerson(person)
    }

    suspend fun deleteAllPersons() {
        personDao.deleteAllPersons()
    }
}