package com.example.movieapplicationjava.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie implements Parcelable {
    /* {
        "title": "Dawn of the Planet of the Apes",
        "image": "https://api.androidhive.info/json/movies/1.jpg",
        "rating": 8.3,
        "releaseYear": 2014,
        "genre": ["Action", "Drama", "Sci-Fi"]
    } */

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("image")
    @Expose
    private String imageUrl;

    @SerializedName("rating")
    @Expose
    private float rating;

    @SerializedName("releaseYear")
    @Expose
    private Integer releaseYear;

    @SerializedName("genre")
    @Expose
    private List<String> genreList;

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public float getRating() {
        return rating;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public List<String> getGenreList() {
        return genreList;
    }

    public String getGenreListAsString(){
        StringBuilder genreListAsString = new StringBuilder();

        if(genreList != null && !genreList.isEmpty()) {
            for (String genre : genreList) {
                genreListAsString.append(genre).append(", ");
            }
        }

        return removeLast2Chars(genreListAsString.toString());
    }

    private static String removeLast2Chars(String str) {
        return str.substring(0, str.length() - 2);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(imageUrl);
        dest.writeFloat(rating);
        if (releaseYear == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(releaseYear);
        }
        dest.writeStringList(genreList);
    }

    protected Movie(Parcel in) {
        title = in.readString();
        imageUrl = in.readString();
        rating = in.readFloat();
        if (in.readByte() == 0) {
            releaseYear = null;
        } else {
            releaseYear = in.readInt();
        }
        genreList = in.createStringArrayList();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

}
