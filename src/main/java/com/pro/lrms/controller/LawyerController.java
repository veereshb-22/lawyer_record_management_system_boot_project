package com.pro.lrms.controller;

import com.pro.lrms.entity.LawyerRecord;
import com.pro.lrms.service.LawyerService;
import com.pro.lrms.exception.LawyerDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Lawyer Records in the Lawyer Record Management System (LRMS).
 * Provides endpoints for CRUD operations and other functionalities such as status updates and summaries.
 */
@RestController
@RequestMapping("/lrms/lawyers")
public class LawyerController {

    @Autowired
    private LawyerService lawyerService;

    
    /**
     * Retrieve all lawyer records.
     *
     * @return ResponseEntity containing a list of all lawyer records and HTTP status.
     */
    @GetMapping("/getlawyer")
    public ResponseEntity<List<LawyerRecord>> getAllLawyers() {
        List<LawyerRecord> lawyers = lawyerService.getAllLawyer();
        return new ResponseEntity<>(lawyers, HttpStatus.OK);
    }

    
    /**
     * Retrieve a lawyer record by ID.
     *
     * @param lawyerID The ID of the lawyer.
     * @return ResponseEntity containing the lawyer record or an error message and HTTP status.
     */
    @GetMapping("/{lawyerID}")
    public ResponseEntity<Object> getLawyerByID(@PathVariable String lawyerID) {
        try {
            LawyerRecord lawyer = lawyerService.getLawyerByID(lawyerID);
            return new ResponseEntity<>(lawyer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Lawyer not found", HttpStatus.NOT_FOUND);
        }
    }

    
    /**
     * Create a new lawyer profile.
     *
     * @param lawyerRecord The lawyer record to be created.
     * @return ResponseEntity containing a success or error message and HTTP status.
     */
    @PostMapping("/postdata")
    public ResponseEntity<String> createLawyerProfile(@RequestBody LawyerRecord lawyerRecord) {
        try {
            // Check if lawyer with the same LaywerLicenseNumber already exists
        	 if (lawyerService.getLawyerByLicenseNumber(lawyerRecord.getLawyerLicenseNumber()) != null) {
                return new ResponseEntity<>("Lawyer Data Already exist" + lawyerRecord.getLawyerID(), HttpStatus.BAD_REQUEST);
            }

            // Create the lawyer profile
            lawyerService.createLawyerProfile(lawyerRecord);
            return new ResponseEntity<>("Lawyer profile created successfully", HttpStatus.CREATED);
            
        } catch (Exception e) {
        	return new ResponseEntity<>("Lawyer data already exists with ID: ", HttpStatus.CONFLICT);
        }
    }


    
    /**
     * Change the status of a lawyer (active/inactive).
     *
     * @param lawyerID The ID of the lawyer whose status is to be changed.
     * @return ResponseEntity containing a success or error message and HTTP status.
     */
    @PutMapping("/status/{lawyerID}")
    public ResponseEntity<String> changeLawyerStatus(@PathVariable String lawyerID) {
        try {
        	//lawyer Details is found
            lawyerService.changeLawyerStatus(lawyerID);
            return new ResponseEntity<>("Lawyer status updated successfully", HttpStatus.OK);
        } catch (LawyerDetailsNotFoundException e) {
            return new ResponseEntity<>("Lawyer not found", HttpStatus.NOT_FOUND);
        }
    }

    
    /**
     * Delete a lawyer record by ID.
     *
     * @param lawyerID The ID of the lawyer to be deleted.
     * @return ResponseEntity containing a success or error message and HTTP status.
     */
    @DeleteMapping("delete/{lawyerID}")
    public ResponseEntity<String> deleteLawyer(@PathVariable String lawyerID) {
        try {
            lawyerService.deleteLaywer(lawyerID);
            return new ResponseEntity<>("Lawyer deleted successfully", HttpStatus.NO_CONTENT);
        } catch (LawyerDetailsNotFoundException e) {
            return new ResponseEntity<>("LawyerID does not exist", HttpStatus.NOT_FOUND);
        }
    }

    
    
    /**
     * Retrieve a summary of lawyers, including calculated metrics such as win ratio.
     *
     * @return ResponseEntity containing the summary and HTTP status.
     */
    @GetMapping("/summary")
    public ResponseEntity<List<Object[]>> getLawyerSummary() {
        try {
            // Fetch the lawyer summary from the service
            List<Object[]> lawyerSummary = lawyerService.getLawyerSummary();
            return new ResponseEntity<>(lawyerSummary, HttpStatus.OK);
        } catch (RuntimeException e) {
            // If an exception occurs, return an error response
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    /**
     * Retrieve all active lawyers.
     *
     * @return ResponseEntity containing a list of active lawyers and HTTP status.
     */
    @GetMapping("/active")
    public ResponseEntity<List<LawyerRecord>> getAllActiveLawyers() {
        try {
            // Fetch active lawyers from the service layer
            List<LawyerRecord> activeLawyers = lawyerService.getActiveLawyers();
            return new ResponseEntity<>(activeLawyers, HttpStatus.OK);
        } catch (RuntimeException e) {
            // If an exception occurs, return an error response
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    /**
     * Retrieves a list of lawyers based on their domain of expertise.
     * 
     * @param domain The domain of expertise (e.g., Civil, Criminal) to filter lawyers.
     * @return A ResponseEntity containing a list of LawyerRecord objects matching the domain.
     *         If no lawyers are found, returns an empty list with HTTP status 200 (OK).
     *         If an error occurs, returns HTTP status 500 (INTERNAL_SERVER_ERROR).
     */
    @GetMapping("/domain/{domain}")
    public ResponseEntity<List<LawyerRecord>> getLawyerByDomain(@PathVariable String domain) {
        try {
            // Fetch lawyers by domain from the service layer
            List<LawyerRecord> lawyers = lawyerService.getLawyerByDomain(domain);

            // Return the list of lawyers with HTTP status 200 (OK)
            return new ResponseEntity<>(lawyers, HttpStatus.OK);
        } catch (Exception e) {
            // If an error occurs, return an error message with HTTP status 500 (INTERNAL_SERVER_ERROR)
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
