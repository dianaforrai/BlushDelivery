package com.utcn.SCDProiect.courier;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courierId;
    private String name;
    private String email;
    private Courier manager;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Courier getManager() {
        return manager;
    }

    public void setManager(Courier manager) {
        this.manager = manager;
    }
}
