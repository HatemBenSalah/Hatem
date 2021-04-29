package com.hms.repositories;

import com.hms.entity.ClaimEntity;
import com.hms.entity.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<ClaimEntity, Integer> {
   ClaimEntity findByEmail(String email);

   @Query(
           value = "select  * from claim  where user_id=?1",
           nativeQuery = true)
   List<ClaimEntity> findbyuser(Long i);
}
