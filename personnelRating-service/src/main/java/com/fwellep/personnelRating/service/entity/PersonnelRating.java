package com.fwellep.personnelRating.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "personnel_ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelRating {
    @Id
    private Long userId;
    private String description;
    private int overallRatingOutOf10;



}
