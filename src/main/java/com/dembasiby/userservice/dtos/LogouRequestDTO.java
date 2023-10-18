package com.dembasiby.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogouRequestDTO {
    private String token;
    private Long userId;
}
