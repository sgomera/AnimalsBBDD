package com.example.animalsbbdd;

/*-------------------------------------WHAT IS A REPOSITORY?----------------------------------------
A Repository is a class that abstracts access to multiple data sources. The Repository is not part
 of the Architecture Components libraries, but is a suggested best practice for code separation and
  architecture. A Repository class handles data operations. It provides a clean API to the rest of
   the app for app data.

   A Repository manages query threads and allows you to use multiple backends.
   In the most common example, the Repository implements the logic for deciding whether to fetch
    data from a network or use results cached in a local database
--------------------------------------------------------------------------------------------------*/


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AnimalRepository {

    //member variables for Dao and the list of animals:
    private AnimalDao mAnimalDao;
    private LiveData<List<Animal>> mAllAnimals;
 //   private LiveData<List<Animal>> mAnimalsByName;


    // constructor that gets a handle to the database and initializes the member variables
    public AnimalRepository(Application application) {
        AnimalRoomDatabase db = AnimalRoomDatabase.getDatabase(application);
        mAnimalDao = db.animalDao();
        mAllAnimals = mAnimalDao.getAllAnimals();
    }

    //wrapper for getAllAnimals(). Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Animal>> getAllAnimals() {
        return mAllAnimals;
    }

    //TODO create a wrapper for the getAnimalByName method just like the one for getAllAnimals
    /*public LiveData<List<Animal>> getAnimalsByName(String name){
        return mAnimalsByName;
    }*/

    //wrapper for the insert() method. You must call this on a non-UI thread or your app will crash.
    // Room ensures that you don't do any long-running operations on the main thread, blocking the UI.
    public void insert (Animal animal) {
        new insertAsyncTask(mAnimalDao).execute(animal);
    }



    //insertAsyncTask Class (subClass)
    private static class insertAsyncTask extends AsyncTask<Animal, Void, Void> {

        private AnimalDao mAsyncTaskDao;

        insertAsyncTask(AnimalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Animal... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
