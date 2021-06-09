package io.github.rogerion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.rogerion.entities.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

}
