package com.apartment.examen_final.model;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Payment {
    private int idPayment;

    private int idReservation;

    private String paymentDate;
}
