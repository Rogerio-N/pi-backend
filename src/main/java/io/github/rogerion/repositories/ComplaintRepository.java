package io.github.rogerion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.rogerion.entities.Complaint;
import io.github.rogerion.entities.User;
import org.springframework.data.jpa.repository.Query;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

}
