package org.example.LLD.Designs.CarRentalSystem.Payment;

import lombok.Builder;
import org.example.LLD.Designs.CarRentalSystem.Store.Reservation;

@Builder
public class Bill {
    Reservation reservation;
    double BillAmount;
    Boolean isPaid;

    BillStatus billStatus;

    int calculateBill(Reservation reservation) {
        //logic to calcuate bill amount
        return 100;
    }

}
