package com.ngro.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("media-metadata")
    val mediaMetaDataList: List<MediaMetaData>
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(MediaMetaData)!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(mediaMetaDataList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Media> {
        override fun createFromParcel(parcel: Parcel): Media {
            return Media(parcel)
        }

        override fun newArray(size: Int): Array<Media?> {
            return arrayOfNulls(size)
        }
    }
}
