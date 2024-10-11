package org.example.LLD.Designs.CarRentalSystem.Payment;

public class Payment {
    Bill bill;

    public Payment(Bill bill) {
        this.bill=bill;
    }
    public Boolean payBill() {
        //logic to pay bill
        bill.billStatus= BillStatus.PAID;
        return true;
    }
}
