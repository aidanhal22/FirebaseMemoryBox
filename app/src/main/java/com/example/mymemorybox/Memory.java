package com.example.mymemorybox;

import android.os.Parcel;
import android.os.Parcelable;

public class Memory implements Parcelable{
    private int rating, imageResourceId;
    private String name, desc;

    public Memory(int rating, int imageResourceId, String name, String desc) {
        this.rating = rating;
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.desc = desc;
    }

    public Memory(int rating, String name, String desc) {
        this.rating = rating;
        this.imageResourceId = 0;
        this.name = name;
        this.desc = desc;
    }

    public Memory() {
        this.rating = 0;
        this.imageResourceId = 0;
        this.name = "";
        this.desc = "";
    }
    public static final Parcelable.Creator<Memory> CREATOR = new
            Parcelable.Creator<Memory>() {

                @Override
                public Memory createFromParcel(Parcel parcel) {
                    return new Memory(parcel);
                }

                @Override
                public Memory[] newArray(int size) {
                    return new Memory[0];
                }
            };
    /** This is a "constructor" of sorts that is needed with the Parceable interface to
     * tell the intent how to create a Food object when it is received from the intent
     * basically it is setting each instance variable as a String or Int
     * if the instance variables were objects themselves you would need to do more complex * code.  We need to read in the String, double, and int data.
     *
     * @param parcel    the parcel that is received from the intent
     */
    // to avoid errors keep the order of the parameters that you are setting the same in all
    // of these methods it should match what you have in your original constructor
    public Memory(Parcel parcel) {
        rating = parcel.readInt();
        imageResourceId = parcel.readInt();
        name = parcel.readString();
        desc = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * This is what is used when we send the Food object through an intent
     * It is also a method that is part of the Parceable interface and is needed
     * to set up the object that is being sent.  Then, when it is received, the
     * other Food constructor that accepts a Parcel reference can "unpack it"
     *
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(rating);
        dest.writeInt(imageResourceId);
        dest.writeString(name);
        dest.writeString(desc);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
