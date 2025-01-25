package com.pro.lrms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pro.lrms.entity.LawyerRecord;

/**
 * Repository interface for performing CRUD operations on the LawyerRecord entity.
 * Extends JpaRepository to leverage Spring Data JPA functionalities.
 */
@Repository
public interface LawyerRepository extends JpaRepository<LawyerRecord, String> {

    /**
     * Retrieves a list of LawyerRecord entities filtered by the lawyer domain.
     * 
     * @param lawyerDomain The domain of the lawyer (e.g., Civil, Criminal, etc.).
     * @return A list of LawyerRecord objects matching the given domain.
     */
	@Query("SELECT l FROM LawyerRecord l WHERE l.lawyerDomain ILIKE :lawyerDomain")
	List<LawyerRecord> findByLawyerDomain(@Param("lawyerDomain") String lawyerDomain);

    
    /**
     * Retrieves a specific LawyerRecord entity based on the lawyer ID.
     * 
     * @param lawyerID The unique ID of the lawyer.
     * @return A LawyerRecord object matching the given lawyer ID.
     */
    LawyerRecord findByLawyerID(String lawyerID);

    
    /**
     * Custom query to get a summary of lawyer information including:
     * lawyer name, domain, contact number, and calculated win ratio.
     * 
     * @return A list of object arrays containing lawyer summary details.
     * Each object array contains: [lawyerName, lawyerDomain, lawyerNumber, calculatedWinRatio].
     */
    @Query("SELECT l.lawyerName, l.lawyerDomain, l.lawyerNumber, " +
           "CASE WHEN l.laywerCase > 0 THEN (l.lawyerWinRatio) ELSE 0 END " +
           "FROM LawyerRecord l")
    List<Object[]> getLawyerSummary();

    
    /**
     * Retrieves a list of LawyerRecord entities filtered by their status.
     * 
     * @param lawyerStatus The status of the lawyer (e.g., Active, Inactive).
     * @return A list of LawyerRecord objects matching the given status.
     */
    List<LawyerRecord> findByLawyerStatus(String lawyerStatus);
    
    
    /**
     * Retrieves a LawyerRecord entity filtered by its license number.
     * 
     * @param lawyerLicenseNumber The license number of the lawyer.
     * @return The LawyerRecord object matching the given license number, or null if no match is found.
     */
    LawyerRecord findByLawyerLicenseNumber(String lawyerLicenseNumber);
    
   
}
