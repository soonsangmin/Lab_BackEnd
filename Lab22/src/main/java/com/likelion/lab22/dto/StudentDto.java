package com.likelion.lab22.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    private Long id;
    private String studentCode;
    private String name;
    private String phone;
    private String email;
    private String address;
}

