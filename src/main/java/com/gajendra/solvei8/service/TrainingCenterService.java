package com.gajendra.solvei8.service;

import com.gajendra.solvei8.dao.TrainingCenterRepository;
import com.gajendra.solvei8.dto.AddressDto;
import com.gajendra.solvei8.dto.TrainingCenterRequestDto;
import com.gajendra.solvei8.dto.TrainingCenterResponseDto;
import com.gajendra.solvei8.model.Address;
import com.gajendra.solvei8.model.TrainingCenter;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrainingCenterService {
    @Autowired
    TrainingCenterRepository repository;


    public ResponseEntity<TrainingCenterResponseDto> saveTrainingCenter(@Valid TrainingCenterRequestDto trainingCenterRequestDto) {
        if (repository.existsByCenterCode(trainingCenterRequestDto.getCenterCode())) {
            System.out.println("CenterCode already exists "+trainingCenterRequestDto.getCenterCode());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        TrainingCenter trainingCenter = toEntity(trainingCenterRequestDto);
        repository.save(trainingCenter);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO(trainingCenter));
    }

    public ResponseEntity<List<TrainingCenterResponseDto>> getAllTrainingCenters() {
        List<TrainingCenter> trainingCenters = repository.findAll();
        List<TrainingCenterResponseDto> responseDtos = trainingCenters.stream().map(this::toResponseDTO).toList();
        return ResponseEntity.status(HttpStatus.OK).body(responseDtos);
    }

    public ResponseEntity<TrainingCenterResponseDto> getTrainingCenterById(Long id) {
        TrainingCenterResponseDto dto;
        try {
            dto = toResponseDTO(repository.findById(id).orElseThrow(RuntimeException::new));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    public TrainingCenter toEntity(TrainingCenterRequestDto dto) {
        TrainingCenter trainingCenter = new TrainingCenter();
        Address address = new Address();
        BeanUtils.copyProperties(dto, trainingCenter, "address");
        BeanUtils.copyProperties(dto.getAddress(), address);
        trainingCenter.setAddress(address);
        return trainingCenter;
    }

    public TrainingCenterResponseDto toResponseDTO(TrainingCenter entity) {
        TrainingCenterResponseDto dto = new TrainingCenterResponseDto();
        AddressDto addressDto = new AddressDto();
        BeanUtils.copyProperties(entity, dto, "address");
        BeanUtils.copyProperties(entity.getAddress(), addressDto);
        dto.setAddress(addressDto);
        return dto;
    }


}
