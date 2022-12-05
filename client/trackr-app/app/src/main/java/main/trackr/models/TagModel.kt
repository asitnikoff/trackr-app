package main.trackr.models

import com.google.gson.annotations.SerializedName

class TagModel {
    @SerializedName("tag_id")
    var tagId: Int = -1

    @SerializedName("title")
    var title: String = ""
}