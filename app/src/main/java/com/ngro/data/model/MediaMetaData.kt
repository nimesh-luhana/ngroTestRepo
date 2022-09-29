package com.ngro.data.model

import android.os.Parcel
import android.os.Parcelable

data class MediaMetaData(
    val url: String
): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MediaMetaData> {
        override fun createFromParcel(parcel: Parcel): MediaMetaData {
            return MediaMetaData(parcel)
        }

        override fun newArray(size: Int): Array<MediaMetaData?> {
            return arrayOfNulls(size)
        }
    }
}
