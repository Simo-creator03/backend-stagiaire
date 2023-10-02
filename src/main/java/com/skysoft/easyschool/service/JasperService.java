//package com.skysoft.easyschool.service;
//
//import com.skysoft.easyschool.config.ApplicationProperties;
//import com.skysoft.easyschool.dto.ReportingPrinter;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.util.JRLoader;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.ehcache.impl.internal.classes.commonslang.reflect.MethodUtils;
//import org.springframework.stereotype.Service;
//
//import javax.sql.DataSource;
//import javax.validation.constraints.NotNull;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class JasperService {
//    private final ApplicationProperties applicationProperties;
//    private final DataSource dataSource;
//    private Connection con = null;
//    private Map<String, Object> parameters = new HashMap<>();
//    private String folder_jasper = "jasper/";
//    private String file_jasper = "Blank_A4.jasper";
//
//    public JasperService(ApplicationProperties applicationProperties, DataSource dataSource) {
//        this.applicationProperties = applicationProperties;
//        this.dataSource = dataSource;
//    }
//
//    private void addInfo(Map<String, Object> parameters) {
//
//        parameters.clear();
//
//        String chemin = applicationProperties.getResources().getLocationPdfFile();
//
//        parameters.put("Path", chemin + "/");
//    }
//
//    public ReportingPrinter imprimer() throws SQLException, JRException {
//        ReportingPrinter r = new ReportingPrinter();
//
//        addInfo(parameters);
//        con = getConnection();
//        InputStream path = getFileInputStream(file_jasper);
//        String fileName = "liste_stagiaire_" + getPrefixDocumentByDate() +".pdf";
//
//        return getPrinter(r, fileName, path);
//    }
//
//    private InputStream getFileInputStream(String nameFile) {
//        return getClass().getClassLoader().getResourceAsStream(folder_jasper + nameFile);
//    }
//
//    public static String getPrefixDocumentByDate() {
//        LocalDate today = LocalDate.now();
//        Calendar c = Calendar.getInstance();
//        String p = (today.getYear() + "").substring(2);
//        p += format(today.getMonthValue(), 2);
//        p += format(today.getDayOfMonth(), 2);
//        p += "_";
//        p += format(c.get(Calendar.HOUR_OF_DAY), 2);
//        p += format(c.get(Calendar.MINUTE), 2);
//        p += format(c.get(Calendar.SECOND), 2);
//        p += "_";
//        p += RandomStringUtils.randomNumeric(6);
//        return p;
//    }
//
//    public static String format(Integer value, int nombre_char_max) {
//
//        String v = value.toString();
//
//        StringBuilder fixe = new StringBuilder();
//
//        if (v.length() <= nombre_char_max) {
//
//            int nbre_zero = nombre_char_max - v.length();
//
//            for (int i = 0; i < nbre_zero; i++) {
//
//                fixe.append("0");
//            }
//
//            fixe.append(v);
//
//        } else {
//
//            fixe = new StringBuilder(v);
//        }
//
//        return fixe.toString();
//    }
//
//    @NotNull
//    private ReportingPrinter getPrinter(ReportingPrinter r, String fileName, InputStream path) throws JRException {
//        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(path);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
//        r.setDirectorie(fileName);
//        r.setStatut(true);
//        r.setDirectorieLong(String.format("%s%s", applicationProperties.getUpload().getResourcesServerStoreUrl(), fileName));
//        r.setMessage("Impression du fichier PDF");
//        JasperExportManager.exportReportToPdfFile(jasperPrint, String.format("%s%s", applicationProperties.getUpload().getResourcesServerStore(), fileName));
//        return r;
//    }
//
//    private java.sql.Connection getConnection() throws SQLException {
//        return dataSource.getConnection();
//    }
//}
