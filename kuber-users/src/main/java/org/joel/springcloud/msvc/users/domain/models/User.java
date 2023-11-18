package org.joel.springcloud.msvc.users.domain.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;


@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String email;
    private String password;
    @CreationTimestamp
    private OffsetDateTime creationDate;
    @UpdateTimestamp
    private OffsetDateTime updateDate;

}
