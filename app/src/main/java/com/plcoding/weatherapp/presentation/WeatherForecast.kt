package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.IconCompat
import com.plcoding.weatherapp.domain.weather.WeatherData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun WeatherForecast(
    day: Int,
    data: List<WeatherData>,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = LocalDateTime.now().dayOfWeek.plus(day.toLong()).toString(),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(content = {
            items(data) { weatherData ->
                Column(modifier = Modifier
                    .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = weatherData.time.format(DateTimeFormatter.ofPattern("HH:mm")), color = Color.LightGray)
                    Image(painter = painterResource(id = weatherData.weatherType.iconRes),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = "${weatherData.temperatureCelsius}ºC",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
        })
    }
}