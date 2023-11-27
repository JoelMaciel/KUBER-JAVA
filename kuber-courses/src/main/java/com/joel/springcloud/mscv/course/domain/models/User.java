package com.joel.springcloud.mscv.course.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class User {

    @Type(type = "uuid-char")
    @Id
    @EqualsAndHashCode.Include
    private UUID userId;
    private String name;
    private String email;
    @CreationTimestamp
    private OffsetDateTime creationDate;
    @UpdateTimestamp
    private OffsetDateTime updateDate;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<CourseUser> courseUsers = new HashSet<>();

}
