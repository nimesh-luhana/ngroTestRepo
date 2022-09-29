package com.ngro.data.model

import android.os.Parcel
import android.os.Parcelable

data class NewsDetails(
    val title: String,
    val abstract: String,
    val media: List<Media>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.createTypedArrayList(Media)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(abstract)
        parcel.writeTypedList(media)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewsDetails> {
        override fun createFromParcel(parcel: Parcel): NewsDetails {
            return NewsDetails(parcel)
        }

        override fun newArray(size: Int): Array<NewsDetails?> {
            return arrayOfNulls(size)
        }
    }
}
