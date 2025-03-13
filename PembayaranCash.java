public class PaymentCash extends Payment {
    private String adminId;
    private String branchId;

    // Konstruktor utama tanpa parameter amount
    public PaymentCash(String adminId, String branchId, String customerId) {
        super(customerId);
        this.adminId = adminId;
        this.branchId = branchId;
    }

    @Override
    public void pay(double amount) {
        if (validatePayment(amount)) {
            System.out.println("Customer comes to the branch and pays " + amount + " cash.");
        } else {
            System.out.println("Invalid amount for cash payment.");
        }
    }

    private boolean validatePayment(double amount) {
        return amount > 0;
    }

    public void printCashDetails() {
        printPaymentDetails();
        System.out.println("Admin ID: " + adminId);
        System.out.println("Branch ID: " + branchId);
    }

    // Metode baru untuk mengatur jumlah pembayaran
    public void setAmount(double amount) {
        if (amount > 0) {
            super.pay(amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }
}
