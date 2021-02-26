package com.panagiac.demo.data

const val BASE_URL = "http://api.openweathermap.org/data/"

const val VERSION = "2.5"
const val APP_ID = "bf8b138584f8ba729d508c2a97d17a12"

const val WEATHER = "$VERSION/weather?appid=$APP_ID"
const val FORECAST = "$VERSION/forecast?appid=$APP_ID"

const val WEATHER_API_MOCK = "api_weather.json"
const val FORECAST_API_MOCK = "api_forecast.json"
const val CITIES_DB = "city.list.json"