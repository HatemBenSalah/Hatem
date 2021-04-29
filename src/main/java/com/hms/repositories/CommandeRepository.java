package com.hms.repositories;
import com.hms.entity.CommandeEntity;
import com.hms.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<CommandeEntity, Long>{
    @Query(
            value = "select  * from commande  where user_id=?1",
            nativeQuery = true)
    List<CommandeEntity> findbyuser(Long i);

   // List<CommandeEntity> findCommandeEntityById(UserEntity user);
}
