package com.pro.lrms.serviceimp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pro.lrms.entity.LawyerRecord;
import com.pro.lrms.exception.LawyerDetailsNotFoundException;
import com.pro.lrms.repository.LawyerRepository;
import com.pro.lrms.service.LawyerService;

/**
 * Service implementation for managing operations related to LawyerRecord entities.
 * Implements the business logic defined in the LawyerService interface.
 */
@Service
public class LawyerServiceImp implements LawyerService {

    @Autowired
    private LawyerRepository lawyerRepo;

    /**
     * Retrieves a list of all lawyers.
     * 
     * @return A list of LawyerRecord objects.
     * @throws LawyerDetailsNotFoundException if no lawyer records are found.
     */
    @Override
    public List<LawyerRecord> getAllLawyer() {
        List<LawyerRecord> lawyers = lawyerRepo.findAll();

        if (lawyers.isEmpty()) {
            throw new LawyerDetailsNotFoundException("No Lawyer Details Found");
        }

        return lawyers;
    }

    
    /**
     * Toggles the status of a lawyer (Active/Inactive) based on their ID.
     * 
     * @param lawyerID The unique ID of the lawyer whose status needs to be updated.
     * @throws LawyerDetailsNotFoundException if the lawyer is not found.
     */
    @Override
    public void changeLawyerStatus(String lawyerID) {
        LawyerRecord lawyer = lawyerRepo.findByLawyerID(lawyerID);
        if (lawyer == null) {
            throw new LawyerDetailsNotFoundException("Lawyer not found");
        }
        lawyer.setLawyerStatus("Active".equals(lawyer.getLawyerStatus()) ? "Inactive" : "Active");
        lawyerRepo.save(lawyer);
    }

    
    /**
     * Deletes a lawyer record from the system based on their ID.
     * 
     * @param lawyerID The unique ID of the lawyer to be deleted.
     * @throws LawyerDetailsNotFoundException if the lawyer does not exist.
     */
    @Override
    public void deleteLaywer(String lawyerID) {
        LawyerRecord lawyerRecord = lawyerRepo.findByLawyerID(lawyerID);

        if (lawyerRecord == null) {
            throw new LawyerDetailsNotFoundException("Lawyer with ID " + lawyerID + " does not exist");
        }
        lawyerRepo.delete(lawyerRecord);
    }

    
    /**
     * Creates a new lawyer profile in the system.
     * 
     * @param lawyerRecord The LawyerRecord object containing the details of the new lawyer.
     * @throws RuntimeException if an error occurs during the save operation.
     */
    @Override
    public void createLawyerProfile(LawyerRecord lawyerRecord) {
        try {
            lawyerRepo.save(lawyerRecord);
        } catch (Exception ex) {
            throw new RuntimeException("Error saving lawyer profile: " + ex.getMessage());
        }
    }

    
    /**
     * Retrieves the details of a specific lawyer based on their ID.
     * 
     * @param lawyerID The unique ID of the lawyer to be retrieved.
     * @return The LawyerRecord object for the specified lawyer.
     * @throws LawyerDetailsNotFoundException if the lawyer is not found.
     */
    @Override
    public LawyerRecord getLawyerByID(String lawyerID) {
        LawyerRecord lawyer = lawyerRepo.findByLawyerID(lawyerID);
        if (lawyer == null) {
            throw new LawyerDetailsNotFoundException("Lawyer with ID " + lawyerID + " not found.");
        }
        return lawyer;
    }

    
    /**
     * Retrieves a summary of lawyers, including their name, domain, 
     * contact number, and calculated win ratio.
     * 
     * @return A list of object arrays containing lawyer summary details.
     * @throws RuntimeException if an error occurs during the query execution.
     */
    @Override
    public List<Object[]> getLawyerSummary() {
        try {
            return lawyerRepo.getLawyerSummary();
        } catch (Exception e) { 
            throw new RuntimeException("An error occurred while fetching the lawyer summary.", e);
        }
    }
    
    /**
     * Retrieves a list of all active lawyers.
     * 
     * @return A list of LawyerRecord objects representing active lawyers.
     * @throws LawyerDetailsNotFoundException if no active lawyers are found.
     */
    @Override
    public List<LawyerRecord> getActiveLawyers() {
        List<LawyerRecord> lawyers = lawyerRepo.findByLawyerStatus("Active");

        if (lawyers.isEmpty()) {
            throw new LawyerDetailsNotFoundException("No Active Lawyer Details Found");
        }

        return lawyers;
    }

    
    /**
     * Retrieves a lawyer's record by their license number.
     * 
     * @param lawyerLicenseNumber The license number of the lawyer.
     * @return A LawyerRecord object containing the lawyer's details.
     * @return null if lawyer details is not found
     */
	@Override
	public LawyerRecord getLawyerByLicenseNumber(String lawyerLicenseNumber) {
		LawyerRecord lawyer = lawyerRepo.findByLawyerLicenseNumber(lawyerLicenseNumber);
		// Return the found lawyer details if found or returns the null if details is not found
		return lawyer;
	}

	/**
	 * Retrieves a list of lawyers based on their domain of expertise.
	 * 
	 * @param domain The domain of expertise (e.g., Civil, Criminal) to filter lawyers.
	 * @return A list of LawyerRecord objects that match the given domain.
	 *         If no lawyers are found, returns an empty list.
	 */
	@Override
	public List<LawyerRecord> getLawyerByDomain(String domain) {
	    // Fetch lawyers from the repository who have the given domain expertise
	    List<LawyerRecord> lawyers = lawyerRepo.findByLawyerDomain(domain);
	    
	    // Return the list of lawyers. If no lawyers are found, an empty list is returned.
	    return lawyers;
	}

}
