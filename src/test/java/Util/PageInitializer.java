package Util;

import Pages.*;

public class PageInitializer {
    public static loginPage lnPage;
    public static DashboardPage dashboardPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static AddEmployeePage addEmployeePage;
    public static AdminDashboardPage adminDashBoardPage;
    public static JobTitlePage jobTitlePage;


    public static void initializePageObjects(){
        lnPage = new loginPage();
        dashboardPage = new DashboardPage();
        employeeSearchPage = new EmployeeSearchPage();
        addEmployeePage = new AddEmployeePage();
        adminDashBoardPage = new AdminDashboardPage();
        jobTitlePage = new JobTitlePage();
    }
}
