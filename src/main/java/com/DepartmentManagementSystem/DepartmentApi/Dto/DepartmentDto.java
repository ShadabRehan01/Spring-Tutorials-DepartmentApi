package com.DepartmentManagementSystem.DepartmentApi.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

/* DTO Stand for data transfer object, responsible for transfer data from client to Controller and then service
 * it lies between presentation layer and service layer,don't goto persistent layer at all  */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentDto {
    //These are the POJO class it define some Entities in the code
     private Long id;

    @NotBlank(message = "Name of Department can not be Empty")
    @Size(min=2,max=14,message = "Number of characters in Department should be in range: [2,14]")
     private String title;

    @JsonProperty("isActive")
    private boolean isActive;

 //   @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Date must be in the format dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;

}
