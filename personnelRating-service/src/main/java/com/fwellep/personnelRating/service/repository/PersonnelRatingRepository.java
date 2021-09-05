package com.fwellep.personnelRating.service.repository;

import com.fwellep.personnelRating.service.entity.PersonnelRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRatingRepository extends JpaRepository<PersonnelRating, Long> {
    PersonnelRating findRatingByUserId(Long userId);
}
