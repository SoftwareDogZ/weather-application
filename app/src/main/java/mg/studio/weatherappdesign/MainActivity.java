package mg.studio.weatherappdesign;

import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import weatherbean.WeatherBean;

import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DownloadUpdate().execute();
    }

    public void btnClick(View view) {
        new DownloadUpdate().execute();
    }


    private class DownloadUpdate extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... strings) {
            String stringUrl = "http://t.weather.sojson.com/api/weather/city/101040100";
            HttpURLConnection urlConnection = null;
            BufferedReader reader;

            try {
                URL url = new URL(stringUrl);

                // Create the request to get the information from the server, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Mainly needed for debugging
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                //The temperature
                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Toast.makeText(MainActivity.this, "Error:Service is Unavaible", Toast.LENGTH_SHORT).show();
            ((TextView) findViewById(R.id.today_of_week)).setText("Unknown");
            ((TextView) findViewById(R.id.afterday_of_week)).setText("Unknown");
            ((TextView) findViewById(R.id.thirdday_of_week)).setText("Unknown");
            ((TextView) findViewById(R.id.forthday_of_week)).setText("Unknown");
            ((TextView) findViewById(R.id.fifthday_of_week)).setText("Unknown");
            ((TextView) findViewById(R.id.tv_location)).setText("Unknown");
            ((TextView) findViewById(R.id.tv_temperature)).setText("Unknown");
            ((TextView) findViewById(R.id.tv_date)).setText("Unknown");

            return null;
        }

        @Override
        protected void onPostExecute(String temperature) {
            Gson gson = new Gson();  //创建一个GSON对象
            WeatherBean weatherBean = gson.fromJson(temperature, WeatherBean.class);  //获取WeatherBean对象,用来操作JSON字符串

            //Get the temperature
            String temp = weatherBean.getData().getWendu();

            //Get the date and the day of the week
            List<WeatherBean.DataBean.ForecastBean> forecastBeans = weatherBean.getData().getForecast();
            String inputDateStr = forecastBeans.get(0).getYmd();
            String outputDateStr = "";
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            try{
                Date inputDate = inputFormat.parse(inputDateStr);
                outputDateStr = outputFormat.format(inputDate);
            }catch (ParseException e){
                e.printStackTrace();
            }

            //Update the day of the week displayed
            String day_of_week = forecastBeans.get(0).getWeek();
            switch (day_of_week){
                case "星期一":
                    ((TextView) findViewById(R.id.today_of_week)).setText("MONDAY");
                    ((TextView) findViewById(R.id.afterday_of_week)).setText("TUE");
                    ((TextView) findViewById(R.id.thirdday_of_week)).setText("WED");
                    ((TextView) findViewById(R.id.forthday_of_week)).setText("THU");
                    ((TextView) findViewById(R.id.fifthday_of_week)).setText("FRI");
                    break;
                case "星期二":
                    ((TextView) findViewById(R.id.today_of_week)).setText("TUESDAY");
                    ((TextView) findViewById(R.id.afterday_of_week)).setText("WEN");
                    ((TextView) findViewById(R.id.thirdday_of_week)).setText("THU");
                    ((TextView) findViewById(R.id.forthday_of_week)).setText("FRI");
                    ((TextView) findViewById(R.id.fifthday_of_week)).setText("SAT");
                    break;
                case "星期三":
                    ((TextView) findViewById(R.id.today_of_week)).setText("WEDNSDAY");
                    ((TextView) findViewById(R.id.afterday_of_week)).setText("THU");
                    ((TextView) findViewById(R.id.thirdday_of_week)).setText("FRI");
                    ((TextView) findViewById(R.id.forthday_of_week)).setText("SAT");
                    ((TextView) findViewById(R.id.fifthday_of_week)).setText("SUN");
                    break;
                case "星期四":
                    ((TextView) findViewById(R.id.today_of_week)).setText("THURSDAY");
                    ((TextView) findViewById(R.id.afterday_of_week)).setText("FRI");
                    ((TextView) findViewById(R.id.thirdday_of_week)).setText("SAT");
                    ((TextView) findViewById(R.id.forthday_of_week)).setText("SUN");
                    ((TextView) findViewById(R.id.fifthday_of_week)).setText("MON");
                    break;
                case "星期五":
                    ((TextView) findViewById(R.id.today_of_week)).setText("FRIDAY");
                    ((TextView) findViewById(R.id.afterday_of_week)).setText("SAT");
                    ((TextView) findViewById(R.id.thirdday_of_week)).setText("SUN");
                    ((TextView) findViewById(R.id.forthday_of_week)).setText("MON");
                    ((TextView) findViewById(R.id.fifthday_of_week)).setText("TUE");
                    break;
                case "星期六":
                    ((TextView) findViewById(R.id.today_of_week)).setText("SATURDAY");
                    ((TextView) findViewById(R.id.afterday_of_week)).setText("SUN");
                    ((TextView) findViewById(R.id.thirdday_of_week)).setText("MON");
                    ((TextView) findViewById(R.id.forthday_of_week)).setText("TUE");
                    ((TextView) findViewById(R.id.fifthday_of_week)).setText("THU");
                    break;
                case "星期七":
                    ((TextView) findViewById(R.id.today_of_week)).setText("SUNDAY");
                    ((TextView) findViewById(R.id.afterday_of_week)).setText("MON");
                    ((TextView) findViewById(R.id.thirdday_of_week)).setText("TUE");
                    ((TextView) findViewById(R.id.forthday_of_week)).setText("WED");
                    ((TextView) findViewById(R.id.fifthday_of_week)).setText("THU");
                    break;
                    default:break;
            }

            //Get the location
            String location = weatherBean.getCityInfo().getCity();

            //Get the forecast
            String weather_one = forecastBeans.get(0).getType();
            String weather_two = forecastBeans.get(1).getType();
            String weather_three = forecastBeans.get(2).getType();
            String weather_four = forecastBeans.get(3).getType();
            String weather_five = forecastBeans.get(4).getType();

            //Update the temperature/location/date/icon displayed
            ((TextView) findViewById(R.id.temperature_of_the_day)).setText(temp);
            ((TextView) findViewById(R.id.tv_location)).setText("Chongqing");
            ((TextView) findViewById(R.id.tv_date)).setText(outputDateStr);

            SetIcons(R.id.today_image, weather_one);
            SetIcons(R.id.image_one, weather_two);
            SetIcons(R.id.image_two, weather_three);
            SetIcons(R.id.image_four, weather_four);
            SetIcons(R.id.image_three, weather_three);

            String high1 = forecastBeans.get(1).getHigh().replace("高温 ", "");
            String low1 = forecastBeans.get(1).getLow().replace("低温 ", "");
            String high2 = forecastBeans.get(2).getHigh().replace("高温 ", "");
            String low2 = forecastBeans.get(2).getLow().replace("低温 ", "");
            String high3 = forecastBeans.get(3).getHigh().replace("高温 ", "");
            String low3 = forecastBeans.get(3).getLow().replace("低温 ", "");
            String high4 = forecastBeans.get(4).getHigh().replace("高温 ", "");
            String low4 = forecastBeans.get(4).getLow().replace("低温 ", "");

            ((TextView) findViewById(R.id.temp_one)).setText(low1 + "~" + high1);
            ((TextView) findViewById(R.id.temp_two)).setText(low2 + "~" + high2);
            ((TextView) findViewById(R.id.temp_three)).setText(low3 + "~" + high3);
            ((TextView) findViewById(R.id.temp_four)).setText(low4 + "~" + high4);

            //inform the user that the app updated
            Toast.makeText(MainActivity.this, "The Data Updated", Toast.LENGTH_SHORT).show();
        }
    }

    public void SetIcons(int id, String w){
        switch (w){
            case "晴":
                ((ImageView) findViewById(id)).setImageResource(R.drawable.sunny_small);
                break;
            case "多云":
                ((ImageView) findViewById(id)).setImageResource(R.drawable.partly_sunny_small);
                break;
            case "阴":
                ((ImageView) findViewById(id)).setImageResource(R.drawable.partly_sunny_small);
                break;
            case "小雨":
                ((ImageView) findViewById(id)).setImageResource(R.drawable.rainy_small);
                break;
                default:break;
        }
    }
}
