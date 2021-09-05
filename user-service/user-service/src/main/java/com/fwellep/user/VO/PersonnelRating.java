package com.fwellep.user.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelRating {
    private Long userId;
    private String description;
    private int overallRatingOutOf10;
}
