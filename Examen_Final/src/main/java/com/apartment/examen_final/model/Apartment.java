package com.apartment.examen_final.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Apartment {

    private int idApartment;

    private String location;

    private int numberOfRoom;

    private boolean isAvailable;

}
