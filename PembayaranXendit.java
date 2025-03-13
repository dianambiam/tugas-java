public class PaymentXendit extends Payment {
    private String paymentMethod;
    private String secretToken;
    private String projectId;

    public PaymentXendit(String paymentMethod, String customerId) {
        super(customerId);
        this.paymentMethod = paymentMethod;
        this.secretToken = generateToken();
        this.projectId = generateProjectId();
    }

    @Override
    public void pay(double amount) {
        if (!validatePayment(amount)) {
            System.out.println("Invalid payment amount.");
            return;
        }

        if (paymentMethod.equalsIgnoreCase("transfer")) {
            bankTransfer(amount);
        } else if (paymentMethod.equalsIgnoreCase("VA")) {
            virtualAccount(amount);
        } else {
            System.out.println("Unknown payment method: " + paymentMethod);
        }
    }

    private void bankTransfer(double amount) {
        System.out.println("Sending money by transfer: $" + amount);
    }

    private void virtualAccount(double amount) {
        System.out.println("Sending money by Virtual Account: $" + amount);
    }

    private boolean validatePayment(double amount) {
        return amount > 0;
    }

    private String generateToken() {
        return "XENDIT-TOKEN-12345";
    }

    private String generateProjectId() {
        return "XENDIT-PROJECT-67890";
    }
}
public class PaymentXenditQR extends PaymentXendit {
    private String qrCode;

    public PaymentXenditQR(String customerId) {
        super("QR", customerId);
        this.qrCode = generateQRCode();
    }

    @Override
    public void pay(double amount) {
        if (validatePayment(amount)) {
            System.out.println("Scanning QR Code for payment: $" + amount);
        } else {
            System.out.println("QR Payment failed. Invalid amount.");
        }
    }

    private String generateQRCode() {
        return "XENDIT-QR-XYZ123";
    }

    public void printQRCodeDetails() {
        System.out.println("QR Code: " + qrCode);
    }
}
public class PaymentXenditEWallet extends PaymentXendit {
    private String eWalletProvider;

    public PaymentXenditEWallet(String eWalletProvider, String customerId) {
        super("E-Wallet", customerId);
        this.eWalletProvider = eWalletProvider;
    }

    @Override
    public void pay(double amount) {
        if (validatePayment(amount)) {
            System.out.println("Processing e-wallet payment of $" + amount + " using " + eWalletProvider);
        } else {
            System.out.println("E-Wallet Payment failed. Invalid amount.");
        }
    }

    public void printEWalletDetails() {
        System.out.println("E-Wallet Provider: " + eWalletProvider);
    }
}
