package com.gajendra.solvei8.dao;

import com.gajendra.solvei8.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
    boolean existsByCenterCode(String centerCode);
}
