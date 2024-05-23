package com.walmart.countries.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Language(
    @Json(name = "code")
    val code: String?,
    @Json(name = "iso639_2")
    val iso6392: String?,
    @Json(name = "name")
    val name: String,
    @Json(name = "nativeName")
    val nativeName: String?
)