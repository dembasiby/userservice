package com.dembasiby.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Session extends BaseModel {
    private String token;
    private Date ExpiringAt;

    @ManyToOne
    private User user;

    @Enumerated(value = EnumType.ORDINAL)
    private SessionStatus sessionStatus;
}
