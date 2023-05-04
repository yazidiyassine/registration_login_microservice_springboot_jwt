package com.rm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Role {

    @Id
    private String roleName;
    private String roleDescription;
}
