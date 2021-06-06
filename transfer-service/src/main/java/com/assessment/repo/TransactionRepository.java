/**
 * 
 */
package com.assessment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.domain.Transaction;

/**
 * @author raksinga1
 *
 */

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	}
