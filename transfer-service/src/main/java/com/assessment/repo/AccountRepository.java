/**
 * 
 */
package com.assessment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.domain.Account;

/**
 * @author raksinga1
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByNumber(String number);
}
