package Lesson_7;

public class WeatherResponse {
    private final String date;
    private final String weather_text;
    private final String temperature_min;
    private final String temperature_max;

    public WeatherResponse(String date, String weather_text, String temperature_min, String temperature_max) {
        this.date = date;
        this.weather_text = weather_text;
        this.temperature_min = temperature_min;
        this.temperature_max = temperature_max;
    }

    @Override
    public String toString() {
        return "На дату " + date +
                ",\nОжидается: " + weather_text +
                ",\nМинимальная температура " + temperature_min + " C" +
                ",\nМаксимальная температура " + temperature_max + " C.";
    }
}