package com.DepartmentManagementSystem.DepartmentApi.controllers;

import com.DepartmentManagementSystem.DepartmentApi.Dto.DepartmentDto;
import com.DepartmentManagementSystem.DepartmentApi.exceptions.ResourceNotFoundException;
import com.DepartmentManagementSystem.DepartmentApi.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path ="/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public List<DepartmentDto> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable(name = "departmentId") Long id){
        Optional<DepartmentDto> departmentDto=departmentService.getDepartmentById(id);
        return  departmentDto
                .map(departmentDto1->ResponseEntity.ok(departmentDto1))
                .orElseThrow(()->new ResourceNotFoundException("Department not found with Id: "+id));
    }

    /*Custom Exception Handling */
  /*  @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleDepartmentNotFound(NoSuchElementException exception){
        return new ResponseEntity<>("Department not Found,Please input a valid Department id",HttpStatus.NOT_FOUND);
    }*/

    @PostMapping
    public ResponseEntity<DepartmentDto> createNewDepartment(@RequestBody @Valid DepartmentDto inputDepartment){
        DepartmentDto saveDepartment=departmentService.createNewDepartment(inputDepartment);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }
    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDto> UpdateDepartmentById(@RequestBody @Valid DepartmentDto departmentDto,
                                                              @PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.UpdateDepartmentById(departmentId,departmentDto));
    }
    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> DeleteDepartmentById(@PathVariable Long departmentId){
        boolean gotDeleted=departmentService.DeleteDepartmentById(departmentId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
    @PatchMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDto> UpdatePartiallyDepartmentById(@RequestBody Map<String, Objects> updates,
                                                                       @PathVariable Long departmentId){
        DepartmentDto departmentDto=departmentService.UpdatePartiallyDepartmentById(updates,departmentId);
        return ResponseEntity.ok(departmentDto);
    }
}
