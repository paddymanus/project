package com.example.paddy.project.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Exercise implements Parcelable {

    private String name;
    private String category;



    public Exercise(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Exercise() {
    }

    protected Exercise(Parcel in) {
        name = in.readString();
        category = in.readString();
    }

    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(category);
    }
}
