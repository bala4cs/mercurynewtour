package com.tour.report.listener;

import java.io.File;

/**
 * An enum which holds the properties to be set for extent reporter
 */
public enum ExtentProperties {
    INSTANCE;
    private String reportPath;
    private String extentXServerUrl;
    private String projectName;

    //Klov properties
    private String klovServerUrl;
    private String klovProjectName;
    private String klovReportName;
    
    ExtentProperties() {
        this.reportPath = "output" + File.separator + "Run_" + System.currentTimeMillis() + File.separator
                + "report.html";
        this.projectName = "default";
    }

    /**
     * Gets the report path
     * @return The report path
     */
    public String getReportPath() {
        return reportPath;
    }

    /**
     * Sets the report path
     * @param reportPath The report path value
     */
    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    /**
     * Gets the ExtentX server URL
     * @return The ExtentX server URL
     */
    @Deprecated
    public String getExtentXServerUrl() {
        return extentXServerUrl;
    }

    /**
     * Sets the ExtentX server URL
     * @param extentXServerUrl The ExtentX server URL
     */
    @Deprecated
    public void setExtentXServerUrl(String extentXServerUrl) {
        this.extentXServerUrl = extentXServerUrl;
    }

    /**
     * Gets the project name
     * @return The project name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets the project name
     * @param projectName The project name
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Gets the Klov server URL
     * @return The Klov server URL
     */
    public String getKlovServerUrl() {
        return klovServerUrl;
    }

    /**
     * Sets the Klov server URL
     * @param klovServerUrl The Klov server URL
     */
    public void setKlovServerUrl(String klovServerUrl) {
        this.klovServerUrl = klovServerUrl;
    }

    /**
     * Gets the Klov project name
     * @return The Klov project name
     */
    public String getKlovProjectName() {
        return klovProjectName;
    }

    /**
     * Sets the Klov project name
     * @param klovProjectName The Klov project name
     */
    public void setKlovProjectName(String klovProjectName) {
        this.klovProjectName = klovProjectName;
    }

    /**
     * Gets the Klov report name
     * @return The Klov report name
     */
    public String getKlovReportName() {
        return klovReportName;
    }

    /**
     * Sets the Klov report name
     * @param klovReportName The Klov report name
     */
    public void setKlovReportName(String klovReportName) {
        this.klovReportName = klovReportName;
    }

    
}
