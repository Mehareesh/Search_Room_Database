package com.meruga.search_room_database.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(person: Person)

    @Query("SELECT * FROM person_table ORDER BY id ASC")
    fun readAllPersons(): LiveData<List<Person>>

    @Query("SELECT * FROM person_table WHERE firstName LIKE :searchQuery OR lastName Like :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<Person>>

}