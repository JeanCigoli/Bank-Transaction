package com.transation.bank.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.transation.bank.entity.Transaction;
import com.transation.bank.entity.dto.Statistic;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query("SELECT new com.transation.bank.entity.dto.Statistic("
			+ "COUNT(t.value), "
			+ "SUM(t.value), "
			+ "AVG(t.value), "
			+ "MIN(t.value), "
			+ "MAX(t.value)) "
			+ "FROM Transaction t WHERE t.createdAt BETWEEN :initialDate AND :finalDate")
	Statistic findStatisticBetweenCreatedAt(Date initialDate, Date finalDate);

}
