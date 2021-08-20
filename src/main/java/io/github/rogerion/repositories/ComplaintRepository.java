package io.github.rogerion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.rogerion.entities.Complaint;
import io.github.rogerion.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

    @Query("SELECT c FROM Complaint c WHERE  c.user_id = CAST(:userId as int)")
    public List<Complaint> findUserComplaint(@Param("userId") String userId);

    @Query("SELECT c FROM Complaint c WHERE  c.user_id = CAST(:userId as int) AND c.id = CAST(:complaintId as int)")
    public Complaint findSpecificUserComplaint(@Param("userId") String userId, @Param("complaintId") String complaintID);

}
