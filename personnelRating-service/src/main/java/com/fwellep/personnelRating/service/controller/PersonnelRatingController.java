package com.fwellep.personnelRating.service.controller;

import com.fwellep.personnelRating.service.entity.PersonnelRating;
import com.fwellep.personnelRating.service.service.PersonnelRatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personnelRatings")
@Slf4j
public class PersonnelRatingController {

    @Autowired
    private PersonnelRatingService personnelRatingService;

    @PostMapping("/")
    public PersonnelRating saveRating(@RequestBody PersonnelRating personnelRating){
        log.info("Inside saveRating method of PersonnelRatingController");
        return personnelRatingService.saveRating(personnelRating);
    }

    @GetMapping("/{id}")
    public PersonnelRating findRatingById(@PathVariable("id") Long userId){
        log.info("Inside findRatingById of PersonnelRatingService");
        return personnelRatingService.findRatingById(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteRatingById(@PathVariable("id") Long userId){
        log.info("Inside deleteRatingById of PersonnelRatingService");
        personnelRatingService.deleteRatingById(userId);
    }

    @PutMapping("/{id}")
    public void updateRating(@PathVariable("id") Long userId, @RequestBody PersonnelRating personnelRating){
        log.info("Inside updateRating of PersonnelRatingService");
        personnelRatingService.updateRating(userId, personnelRating);
    }

}
