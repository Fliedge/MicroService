package com.fwellep.personnelRating.service.service;

import com.fwellep.personnelRating.service.entity.PersonnelRating;
import com.fwellep.personnelRating.service.repository.PersonnelRatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonnelRatingService {
    @Autowired
    private PersonnelRatingRepository personnelRatingRepository;

    public PersonnelRating saveRating(PersonnelRating personnelRating) {
        log.info("Inside saveRating of PersonnelRatingService");
        return personnelRatingRepository.save(personnelRating);
    }

    public PersonnelRating findRatingById(Long userId) {
        log.info("Inside findRatingById of PersonnelRatingService");
        return personnelRatingRepository.findRatingByUserId(userId);
    }

    public void deleteRatingById(Long userId) {
        log.info("Inside deleteRatingById of PersonnelRatingService");
        if(personnelRatingRepository.existsById(userId)){
            personnelRatingRepository.deleteById(userId);
        }

    }

    public void updateRating(Long userId, PersonnelRating personnelRating) {
        log.info("Inside updateRating of PersonnelRatingService");
        if (personnelRatingRepository.existsById(userId)){
            personnelRating.setUserId(userId);
            personnelRatingRepository.save(personnelRating);
        }

    }
}
