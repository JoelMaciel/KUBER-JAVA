package com.joel.springcloud.mscv.course.domain.repositories;

import com.joel.springcloud.mscv.course.domain.models.Course;
import com.joel.springcloud.mscv.course.domain.models.CourseUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseUserRepository extends JpaRepository<CourseUser, UUID> {

    @Transactional
    @Modifying
    void deleteByUserUserId(UUID userId);

    Optional<CourseUser> findByUserUserIdAndCourseCourseId(UUID userId, UUID courseId);

    @Query("SELECT cu.course FROM CourseUser cu WHERE cu.user.userId = :userId ORDER BY cu.course.courseId ASC")
    Page<Course> findCoursesByUserId(@Param("userId") UUID userId, Pageable pageable);
}
