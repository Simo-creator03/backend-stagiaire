//package com.skysoft.easyschool.web;
//
//import com.skysoft.easyschool.dto.ReportingPrinter;
//import com.skysoft.easyschool.service.JasperService;
//import net.sf.jasperreports.engine.JRException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.sql.SQLException;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/api")
//public class JasperResource {
//
//    private final JasperService jasperService;
//
//    public JasperResource(JasperService jasperService) {
//        this.jasperService = jasperService;
//    }
//
//    @GetMapping("/imprimer")
//    public ResponseEntity<ReportingPrinter> imprimer() throws SQLException, JRException {
//        return new ResponseEntity<>(jasperService.imprimer(), HttpStatus.OK);
//    }
//}
