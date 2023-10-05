package Format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatChange {
    public  String dataFormatChanger(String inputDate) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");


        try {

            Date date = inputDateFormat.parse(inputDate);
            String formattedDate = outputDateFormat.format(date);

            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

