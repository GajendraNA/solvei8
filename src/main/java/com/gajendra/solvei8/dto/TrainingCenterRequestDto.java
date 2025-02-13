package com.gajendra.solvei8.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingCenterRequestDto {

    @NotBlank(message = "CenterName is mandatory")
    @Size(max = 40, message = "CenterName must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "CenterCode is mandatory")
    @Size(min = 12, max = 12, message = "CenterCode must be exactly 12 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "CenterCode must be alphanumeric")
    private String centerCode;

    @NotNull(message = "Address is mandatory")
    @Valid
    private AddressDto address;

    @Min(value = 1, message = "Student Capacity must be at least 1")
    private int studentCapacity;

    @NotEmpty(message = "Courses Offered must not be empty")
    private List<String> coursesOffered;

    @Email(message = "ContactEmail must be a valid email")
    private String contactEmail;

    @NotBlank(message = "ContactPhone is mandatory")
    @Pattern(regexp = "^[0-9]{10}$", message = "ContactPhone must be a valid 10-digit number")
    private String contactPhone;

}



