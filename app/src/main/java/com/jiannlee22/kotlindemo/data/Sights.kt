package com.jiannlee22.kotlindemo.data

data class Sights(
    var error_code: Int,
    var reason: String,
    var result: List<Result>
)

data class Result(
    var cityId: String,
    var cityName: String,
    var provinceId: String
)