package com.joel.springcloud.mscv.course.domain.repositories;

import com.joel.springcloud.mscv.course.domain.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByName(String name);
}
