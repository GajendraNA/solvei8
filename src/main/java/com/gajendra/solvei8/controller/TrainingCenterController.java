package com.gajendra.solvei8.controller;


import com.gajendra.solvei8.dto.TrainingCenterRequestDto;
import com.gajendra.solvei8.dto.TrainingCenterResponseDto;
import com.gajendra.solvei8.model.TrainingCenter;
import com.gajendra.solvei8.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/training-centers")
@CrossOrigin("*")
public class TrainingCenterController {

    @Autowired
    TrainingCenterService service;

    @PostMapping
    public ResponseEntity<TrainingCenterResponseDto> saveTrainingCenter(@Valid @RequestBody TrainingCenterRequestDto trainingCenterRequestDto) {
        return service.saveTrainingCenter(trainingCenterRequestDto);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenterResponseDto>> getAllTrainingCenters(){
        return service.getAllTrainingCenters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingCenterResponseDto> getTrainingCenterById(@PathVariable Long id){
        return service.getTrainingCenterById(id);
    }
}

