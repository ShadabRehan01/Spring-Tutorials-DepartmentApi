package com.DepartmentManagementSystem.DepartmentApi.repositories;

import com.DepartmentManagementSystem.DepartmentApi.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*Spring data JPA define the CRUD Operations for us also handle complex query with the help of JPQL
  so we have to extend JPARepository, in DepartmentRepository interface */
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

}
