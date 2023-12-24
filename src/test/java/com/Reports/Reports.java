package com.Reports;
import com.relevantcodes.extentreports.ExtentReports;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Author: Diego Marulanda B. Date:30/11/23 -15:34 Project_Name:marulanda_diego_final_testing
 */
public class Reports {
  public static ExtentReports getInstance() {
    Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
   SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHmm");
    String fechaText = formatter.format(fecha);
    String Path = ("src/test/resources/reportes/report"+fechaText+".html");

    ExtentReports extent = new ExtentReports(Path, false);

    return extent;
  }
}

