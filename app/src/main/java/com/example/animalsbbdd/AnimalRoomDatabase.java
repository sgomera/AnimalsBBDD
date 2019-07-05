package com.example.animalsbbdd;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Animal.class}, version = 1)
public abstract class AnimalRoomDatabase extends RoomDatabase {

    //Provide an abstract "getter" method for each @Dao.
    public abstract AnimalDao animalDao();

    //---------- Make the WordRoomDatabase a singleton to prevent having multiple instances
    //---------- of the database opened at the same time.
    private static volatile AnimalRoomDatabase INSTANCE;

    //getDatabase method
    public static AnimalRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AnimalRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                }
            }
        }
        return INSTANCE;
    }
    //----------

    // Code to get a database. This code uses Room's database builder to create a RoomDatabase
    // object in the application context from the AnimalRoomDatabase class and
    // names it "animal_database"
/*    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
    AnimalRoomDatabase.class, "animal_database")
            .build();*/

}
