package com.apartment.examen_final.model;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Reservation {
    private int idReservation;

    private int idApartment;

    private int idClient;

    private String reservationDate;
}
