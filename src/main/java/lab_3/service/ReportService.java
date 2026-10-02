package lab_3.service;

import lab_3.aop.LogExecutionTime;

/** Deliberately has NO interface, so Spring uses CGLIB (Part H.2). */
public class ReportService {

    public String findReport(String name) {
        return "Report:" + name;
    }

    // TODO (F1): add a slow method (Thread.sleep) annotated with @LogExecutionTime
    @LogExecutionTime
    public String generateAnnualReport() throws InterruptedException {
        Thread.sleep(500);
        return "Annual report";
    }
}
