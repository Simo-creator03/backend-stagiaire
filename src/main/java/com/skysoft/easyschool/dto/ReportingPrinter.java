package com.skysoft.easyschool.dto;

public class ReportingPrinter {

    private  String directorie;

    private  String directorieLong;

    private  String message;
    private  boolean statut;

    public static boolean ERROR = false;

    public ReportingPrinter() {
    }

    public ReportingPrinter(String message) {
        this.message = message;
        this.statut = true;
    }

    public ReportingPrinter(String message, boolean statut) {
        this.message = message;
        this.statut = statut;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDirectorie() {
        return directorie;
    }

    public void setDirectorie(String directorie) {
        this.directorie = directorie;
    }

    public String getDirectorieLong() {
        return directorieLong;
    }

    public void setDirectorieLong(String directorieLong) {
        this.directorieLong = directorieLong;
    }
}
