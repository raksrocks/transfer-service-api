package com.assessment.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.assessment.domain.Account;
import com.assessment.domain.Transaction;
import com.assessment.repo.AccountRepository;
import com.assessment.repo.TransactionRepository;

@SpringBootApplication(scanBasePackages = { "com.assessment.repo", "com.assessment.domain" })
@ComponentScan({ "com.assessment.controller" , "com.assessment.service"})
@EntityScan("com.assessment.domain")
@EnableJpaRepositories("com.assessment.repo")
public class TransferServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TransferServiceApplication.class, args);
	}
	
	@Autowired
	private AccountRepository accRepo;
	
	@Autowired
	private TransactionRepository txnRepo;
	
	/**
	 * For standalone testing and initializing data base with below pre created
	 * cards
	 */
	@Override
	public void run(String... args) throws Exception {

		this.accRepo.save(new Account("1001", 100.0));
		this.accRepo.save(new Account("1002", 100.0));
		this.accRepo.save(new Account("1003", 100.0));
		this.accRepo.save(new Account("1004", 100.0));
		
		this.txnRepo.save(new Transaction("1001", "1002", 10.0));

	}

}
