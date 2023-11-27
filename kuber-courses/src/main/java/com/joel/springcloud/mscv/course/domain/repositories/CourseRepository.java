package com.joel.springcloud.mscv.course.domain.repositories;

import com.joel.springcloud.mscv.course.domain.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
    boolean existsByName(String name);

}
