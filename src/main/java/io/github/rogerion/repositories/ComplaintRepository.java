package io.github.rogerion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.rogerion.entities.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

	public List<Complaint> findByProtocol(String e);
	
}
