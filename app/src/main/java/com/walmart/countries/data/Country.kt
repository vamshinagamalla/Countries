package com.walmart.countries.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Country(
    @Json(name = "capital")
    val capital: String,
    @Json(name = "code")
    val code: String,
    @Json(name = "currency")
    val currency: Currency,
    @Json(name = "demonym")
    val demonym: String?,
    @Json(name = "flag")
    val flag: String,
    @Json(name = "language")
    val language: Language,
    @Json(name = "name")
    val name: String,
    @Json(name = "region")
    val region: String
)