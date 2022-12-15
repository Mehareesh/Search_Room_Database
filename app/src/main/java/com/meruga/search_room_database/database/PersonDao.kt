package com.meruga.search_room_database.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPerson(person: Person)

    @Update
    suspend fun updatePerson(person: Person)

    @Delete
    suspend fun deletePerson(person: Person)

    @Query("SELECT * FROM person_table ORDER BY id ASC")
    fun readAllPersons(): LiveData<List<Person>>

    @Query("DELETE FROM person_table")
    suspend fun deleteAllPersons()

}