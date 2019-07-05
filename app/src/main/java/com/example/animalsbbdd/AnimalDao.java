package com.example.animalsbbdd;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnimalDao {
    @Insert
    void insert(Animal animal);

    @Query("DELETE FROM animal_table")
    void deleteAll();

    //By default, to avoid poor UI performance, Room doesn't allow you to issue database queries
    // on the main thread. LiveData applies this rule by automatically running the query
    // asynchronously on a background thread, when needed.

    @Query("SELECT * from animal_table ORDER BY animal ASC")
    LiveData<List<Animal>> getAllAnimals();

/*    @Query("SELECT * from animal_table where name =:name ORDER BY name ASC")
    LiveData<List<Animal>> getAnimalByName(String name);*/

}
