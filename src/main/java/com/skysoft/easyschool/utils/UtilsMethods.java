package com.skysoft.easyschool.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtilsMethods {
    public static final DateTimeFormatter DATEFORMAT_CONVERTOR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static String getDateToString(LocalDate date_debut) {
        String text = date_debut == null ? "" : DATEFORMAT_CONVERTOR.format(date_debut);
        return text;
    }

    public static String getDateToStringTwo(LocalDate date_de_naissance) {
        String text = date_de_naissance == null ? "" : DATEFORMAT_CONVERTOR.format(date_de_naissance);
        return text;
    }

    public static String getDateToStringThree(LocalDate date_fin) {
        String text = date_fin == null ? "" : DATEFORMAT_CONVERTOR.format(date_fin);
        return text;
    }
}
