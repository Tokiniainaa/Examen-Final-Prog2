package com.apartment.examen_final.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Client {
    private int idClient;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String nationality;
}
