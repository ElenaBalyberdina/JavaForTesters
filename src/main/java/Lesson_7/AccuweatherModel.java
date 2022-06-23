package Lesson_7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "eQO1TFc4iG3JF0gwsNip11dWOAwzwCAM";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String LANGUAGE_QUERY_PARAM = "language";
    private static final String LANGUAGE = "ru";
    private static final String METRIC = "metric";
    private static final String METRIC_IN_C = "true";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW -> {
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(getCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE)
                        .addQueryParameter(METRIC, METRIC_IN_C)
                        .build();
                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();
                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();


                WeatherResponse weather = new WeatherResponse(
                        objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Date").asText(),
                        objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Day/IconPhrase").asText(),
                        objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Temperature/Minimum/Value").asText(),
                        objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Temperature/Maximum/Value").asText()
                );
                System.out.println(weather);
            }
            case FIVE_DAYS -> {
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(getCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE)
                        .addQueryParameter(METRIC, METRIC_IN_C)
                        .build();
                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();
                Response fiveDaysForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = fiveDaysForecastResponse.body().string();

                WeatherResponse[] weather5 = new WeatherResponse[5];
                for (int i = 0; i < 5; i++) {
                    weather5[i] = new WeatherResponse(
                            objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(i).at("/Date").asText().substring(1, 10),
                            objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(i).at("/Day/IconPhrase").asText(),
                            objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(i).at("/Temperature/Minimum/Value").asText(),
                            objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(i).at("/Temperature/Maximum/Value").asText()
                    );
                    System.out.println(weather5[i] + "\n");
                }
                break;
            }
        }
    }


    private String getCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        return objectMapper.readTree(responseString).get(0).at("/Key").asText();
    }

    public static void main(String[] args) throws IOException {
        UserInterfaceView userInterfaceView = new UserInterfaceView();
        userInterfaceView.runInterface();
    }
}