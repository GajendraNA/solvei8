package com.gajendra.solvei8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  TrainingCenterResponseDto {

    private Long id;
    private String centerName;
    private String centerCode;
    private AddressDto address;
    private int studentCapacity;
    private List<String> coursesOffered;
    private String contactEmail;
    private String contactPhone;
    private LocalDateTime createdOn;

}
