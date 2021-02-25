package com.panagiac.demo.data.models

data class ForecastDTO(
    val city: CityDTO?,
    val cnt: Int?,
    val cod: String?,
    val list: List<DayDTO>?,
    val message: Int?
)

data class CityDTO(
    val coord: CoordDTO,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
)

data class DayDTO(
    val clouds: CloudsDTO,
    val dt: Int,
    val dt_txt: String,
    val main: MainDTO,
    val pop: Int,
    val sys: SysDTO,
    val visibility: Int,
    val weather: List<WeatherDTO>,
    val wind: WindDTO
)

data class CoordDTO(
    val lat: Double,
    val lon: Double
)

data class CloudsDTO(
    val all: Int
)

data class MainDTO(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double,
    val temp_kf: Double,
    val temp_max: Double,
    val temp_min: Double
)

data class SysDTO(
    val pod: String
)

data class WeatherDTO(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

data class WindDTO(
    val deg: Int,
    val speed: Double
)