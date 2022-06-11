package Lesson_6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .build();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("332287")
                .addQueryParameter("apikey", "eQO1TFc4iG3JF0gwsNip11dWOAwzwCAM")
                .build();

        System.out.println(url);

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response fiveDaysForecastResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = null;
        if (fiveDaysForecastResponse.body() != null) {
            weatherResponse = fiveDaysForecastResponse.body().string();
        }
        JSONObject jsonObject = null;
        if (weatherResponse != null) {
            jsonObject = new JSONObject(weatherResponse);
        }
        System.out.println(jsonObject);

    }


}
