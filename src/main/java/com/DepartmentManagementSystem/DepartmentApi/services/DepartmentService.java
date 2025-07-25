package com.DepartmentManagementSystem.DepartmentApi.services;

import com.DepartmentManagementSystem.DepartmentApi.Dto.DepartmentDto;
import com.DepartmentManagementSystem.DepartmentApi.entity.DepartmentEntity;
import com.DepartmentManagementSystem.DepartmentApi.exceptions.ResourceNotFoundException;
import com.DepartmentManagementSystem.DepartmentApi.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }
    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentEntity> departmentEntity=departmentRepository.findAll();
        return departmentEntity
                .stream()
                .map(departmentEntity1 ->
                        modelMapper.map(departmentEntity1,DepartmentDto.class))
                .collect(Collectors.toList());
    }

    public Optional<DepartmentDto> getDepartmentById(Long id) {
        return departmentRepository.findById(id).map(departmentEntity->
                modelMapper.map(departmentEntity,DepartmentDto.class));
    }

    public DepartmentDto createNewDepartment(DepartmentDto inputDepartment) {
        //To check if user is admin
        // login something
        DepartmentEntity toSaveEntity=modelMapper.map(inputDepartment,DepartmentEntity.class);
        DepartmentEntity SavedepartmentEntity=departmentRepository.save(toSaveEntity);
        return modelMapper.map(SavedepartmentEntity,DepartmentDto.class);
    }
    public void isExistByDepartmentId(Long departmentId){
        boolean exist=departmentRepository.existsById(departmentId);
        if(!exist) throw new ResourceNotFoundException("Department not found with Id: "+departmentId);
    }
    public DepartmentDto UpdateDepartmentById(Long departmentId,DepartmentDto departmentDto) {
        isExistByDepartmentId(departmentId);
        DepartmentEntity departmentEntity=modelMapper.map(departmentDto, DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity savedepartmentEntity=departmentRepository.save(departmentEntity);
        return modelMapper.map(savedepartmentEntity, DepartmentDto.class);
    }

    public boolean DeleteDepartmentById(Long departmentId) {
        isExistByDepartmentId(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }

    public DepartmentDto UpdatePartiallyDepartmentById(Map<String, Objects> updates, Long departmentId) {
        isExistByDepartmentId(departmentId);
        DepartmentEntity departmentEntity=departmentRepository.findById(departmentId).get();

        updates.forEach((field,value)->{
            Field fieldToBeUpdated= ReflectionUtils.findRequiredField(DepartmentEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,departmentEntity,value);
        });
        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDto.class);
    }
}
