package com.example.animalsbbdd;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/*----------------------------------------WHAT IS A VIEWMODEL??------------------------------------
The ViewModel's role is to provide data to the UI and survive configuration changes.
A ViewModel acts as a communication center between the Repository and the UI. You can also use a
ViewModel to share data between fragments. The ViewModel is part of the lifecycle library.
A ViewModel holds your app's UI data in a lifecycle-conscious way that survives configuration changes.
 Separating your app's UI data from your Activity and Fragment classes lets you better follow the
  single responsibility principle: Your activities and fragments are responsible for drawing data
   to the screen, while your ViewModel can take care of holding and processing all the data needed
   for the UI.
--------------------------------------------------------------------------------------------------*/


public class AnimalViewModel extends AndroidViewModel {

    //private member variable to hold a reference to the repository
    private AnimalRepository mRepository;

    //private LiveData member variable to cache the list of animals.
    private LiveData<List<Animal>> mAllAnimals;

    //TODO make changes to allow for searching animals by Name
  //  private LiveData<List<Animal>> mAnimalsByName;

    //constructor that gets a reference to the repository and gets the list of animals from the repository
    public AnimalViewModel(@NonNull Application application) {
        super(application);

        mRepository = new AnimalRepository(application);
        mAllAnimals = mRepository.getAllAnimals();
    }

    //"getter" method for all the words. This completely hides the implementation from the UI.
    public LiveData<List<Animal>> getmAllAnimals() {
        return mAllAnimals;
    }

    //TODO test this method
    /*public LiveData<List<Animal>> getmAnimalsByName(String name){
        mAnimalsByName = mRepository.getAnimalsByName(name);
        return mAnimalsByName;
    }*/

    //Create a wrapper insert() method that calls the Repository's insert() method.
    // In this way, the implementation of insert() is completely hidden from the UI.
    public void insert(Animal animal) {
        mRepository.insert(animal);
    }
}
