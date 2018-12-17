package com.example.evgen.domain.interactors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//FIXME решить куда лучше запихнуть этот класс
public class DateParser {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

    public String dateToText(Date date){
        return dateFormat.format(date);
    }

    /**
     * May produce ParseException if edited wrong date format
     */
    public Date textToDate(String string) throws ParseException{
            return dateFormat.parse(string);
    }

    public long daysToMillis(long days){
        return days * 86400000;
    }
}
