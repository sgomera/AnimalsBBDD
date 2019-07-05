package com.example.animalsbbdd;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "animal_table")
public class Animal {

    //tables columns:
   /* @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo (name = "id")
    private int mId;*/

    @PrimaryKey
    @NonNull
    @ColumnInfo (name = "animal")
    private String mAnimal;

/*    @ColumnInfo (name = "age")
    private int mAge;

    @ColumnInfo (name = "isChipped")
    private boolean mIsChipped;

    @ColumnInfo (name = "tyope")
    private String mType;

    @ColumnInfo (name = "regdate")
    private Date mRegDate;

    @ColumnInfo (name = "photo")
    private String mPhoto;*/


    //constructors

    //constructor
    public Animal(
            //int id,
                  @NonNull String animal
    ) {
  //      this.mId = id;
        this.mAnimal = animal;
    }

/*    public Animal(int id,
                  @NonNull String name,
                  int age,
                  boolean isChipped,
                  String type,
                  Date regDate,
                  String photo
    ) {
        this.mId = id;
        this.mName = name;
        this.mAge = age;
        this.mIsChipped = isChipped;
        this.mType = type;
        this.mRegDate = regDate;
        this.mPhoto = photo;
    }*/

    //Getters
    /*public int getId() {
        return mId;
    }
*/
    @NonNull
    public String getAnimal() {
        return this.mAnimal;
    }

/*    public int getAge() {
        return this.mAge;
    }

    public boolean isIsChipped() {
        return this.mIsChipped;
    }

    public String getType() {
        return this.mType;
    }

    public Date getRegDate() {
        return this.mRegDate;
    }

    public String getPhoto() {
        return this.mPhoto;
    }*/
}
