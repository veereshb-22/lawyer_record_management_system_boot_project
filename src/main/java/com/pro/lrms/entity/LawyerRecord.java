package com.pro.lrms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a lawyer record.
 * Maps to the database table "lawyerrecord".
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lawyerrecord")
public class LawyerRecord {

    /**
     * Unique identifier for the lawyer.
     * Maps to the "lawyerid" column in the database.
     */
    @Id
    @Column(name = "lawyerid", length = 40)
    private String lawyerID;

    /**
     * Name of the lawyer.
     * Maps to the "lawyername" column in the database.
     */
    @Column(name = "lawyername", length = 50)
    private String lawyerName;

    /**
     * Phone number of the lawyer.
     * Maps to the "lawyerphonenumber" column in the database.
     */
    @Column(name = "lawyerphonenumber", length = 15)
    private String lawyerNumber;

    /**
     * Address of the lawyer.
     * Maps to the "lawyeraddress" column in the database.
     */
    @Column(name = "lawyeraddress", length = 200)
    private String laywerAddress;

    /**
     * Domain expertise of the lawyer (e.g., Civil, Criminal).
     * Maps to the "lawyerdomain" column in the database.
     */
    @Column(name = "lawyerdomain", length = 30)
    private String lawyerDomain;

    /**
     * Total number of cases handled by the lawyer.
     * Maps to the "lawyercase" column in the database.
     */
    @Column(name = "lawyercase")
    private int laywerCase;

    /**
     * Total years of experience of the lawyer.
     * Maps to the "lawyerexperience" column in the database.
     */
    @Column(name = "lawyerexperience")
    private int lawyerExperienece;

    /**
     * Win ratio of the lawyer.
     * Maps to the "lawyerwl" column in the database.
     */
    @Column(name = "lawyerwr")
    private float lawyerWinRatio;

    /**
     * License number of the lawyer.
     * Maps to the "lawyerlicense" column in the database.
     */
    @Column(name = "lawyerlicense", length = 30)
    private String lawyerLicenseNumber;

    /**
     * Status of the lawyer (e.g., Active, Inactive).
     * Maps to the "lawyerstatus" column in the database.
     */
    @Column(name = "lawyerstatus", length = 30)
    private String lawyerStatus;

    // Getters and setters for each field

    public String getLawyerID() {
        return lawyerID;
    }

    public void setLawyerID(String lawyerID) {
        this.lawyerID = lawyerID;
    }

    public String getLawyerName() {
        return lawyerName;
    }

    public void setLawyerName(String lawyerName) {
        this.lawyerName = lawyerName;
    }

    public String getLawyerNumber() {
        return lawyerNumber;
    }

    public void setLawyerNumber(String lawyerNumber) {
        this.lawyerNumber = lawyerNumber;
    }

    public String getLaywerAddress() {
        return laywerAddress;
    }

    public void setLaywerAddress(String laywerAddress) {
        this.laywerAddress = laywerAddress;
    }

    public String getLawyerDomain() {
        return lawyerDomain;
    }

    public void setLawyerDomain(String lawyerDomain) {
        this.lawyerDomain = lawyerDomain;
    }

    public int getLaywerCase() {
        return laywerCase;
    }

    public void setLaywerCase(int laywerCase) {
        this.laywerCase = laywerCase;
    }

    public int getLawyerExperienece() {
        return lawyerExperienece;
    }

    public void setLawyerExperienece(int lawyerExperienece) {
        this.lawyerExperienece = lawyerExperienece;
    }

    public float getLawyerWinRatio() {
        return lawyerWinRatio;
    }

    public void setLawyerWinRatio(float lawyerWinRatio) {
        this.lawyerWinRatio = lawyerWinRatio;
    }

    public String getLawyerLicenseNumber() {
        return lawyerLicenseNumber;
    }

    public void setLawyerLicenseNumber(String lawyerLicenseNumber) {
        this.lawyerLicenseNumber = lawyerLicenseNumber;
    }

    public String getLawyerStatus() {
        return lawyerStatus;
    }

    public void setLawyerStatus(String lawyerStatus) {
        this.lawyerStatus = lawyerStatus;
    }
}
