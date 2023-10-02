package com.skysoft.easyschool.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "role")
@NoArgsConstructor
public class Role {

    @NotNull
    @Size(max = 50)
    @Id
    @Column(name = "name", length = 50, unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
