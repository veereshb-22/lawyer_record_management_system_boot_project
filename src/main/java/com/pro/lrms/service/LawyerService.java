package com.pro.lrms.service;

import java.util.List;
import com.pro.lrms.entity.LawyerRecord;

/**
 * Service interface for managing operations related to LawyerRecord entities.
 * Defines the business logic to be implemented by the service layer.
 */
public interface LawyerService {
    
    /**
     * Retrieves a list of all lawyers.
     * 
     * @return A list of all LawyerRecord objects.
     */
    public List<LawyerRecord> getAllLawyer();
    
    
    /**
     * Updates the status of a lawyer (e.g., Active/Inactive) based on their ID.
     * 
     * @param lawyerID The unique ID of the lawyer whose status needs to be updated.
     */
    public void changeLawyerStatus(String lawyerID);
    
    
    /**
     * Deletes a lawyer record from the system based on their ID.
     * 
     * @param lawyerID The unique ID of the lawyer to be deleted.
     */
    public void deleteLaywer(String lawyerID);
    
    
    /**
     * Creates a new lawyer profile in the system.
     * 
     * @param lawyerRecord The LawyerRecord object containing the details of the new lawyer.
     */
    public void createLawyerProfile(LawyerRecord lawyerRecord);

    
    /**
     * Retrieves the details of a specific lawyer based on their ID.
     * 
     * @param lawyerID The unique ID of the lawyer to be retrieved.
     * @return The LawyerRecord object for the specified lawyer.
     */
    public LawyerRecord getLawyerByID(String lawyerID);
    
    /**
     * Retrieves a list of all active lawyers.
     * 
     * @return A list of LawyerRecord objects representing active lawyers.
     */
    public List<LawyerRecord> getActiveLawyers();
    
    
    /**
     * Retrieves a summary of lawyers, including their name, domain, 
     * contact number, and calculated win ratio.
     * 
     * @return A list of object arrays containing lawyer summary details.
     * Each array contains: [lawyerName, lawyerDomain, lawyerNumber, calculatedWinRatio].
     */
    public List<Object[]> getLawyerSummary();
    
    
    /**
     * Retrieves a lawyer's record by their license number.
     * 
     * @param lawyerLicenseNumber The license number of the lawyer.
     * @return A LawyerRecord object containing the lawyer's details or return null if lawyerLicense not found 
     */
    public LawyerRecord getLawyerByLicenseNumber(String lawyerLicenseNumber);
    
    
    /**
     * Retrieves a list of lawyers based on their domain of expertise.
     * 
     * @param domain The domain of expertise for the lawyer (e.g., Civil, Criminal).
     * @return A list of LawyerRecord objects representing lawyers in the specified domain.
     * @throws LawyerDetailsNotFoundException if no lawyers are found with the given domain.
     */
    List<LawyerRecord> getLawyerByDomain(String domain);

}
