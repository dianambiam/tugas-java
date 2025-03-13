public class PaymentPaypal extends Payment {
    private String paypalToken;
    private String paypalId;

    // Konstruktor yang benar, memanggil super(customerId)
    public PaymentPaypal(String token, String id, String customerId) {
        super(customerId);
        this.paypalToken = token;
        this.paypalId = id;
    }

    @Override
    public void pay(double amount) {
        if (validatePayment(amount) && authenticateToken()) {
            System.out.println("Using PayPal API to transfer $" + amount + " to the account.");
        } else {
            System.out.println("PayPal payment failed. Invalid amount or authentication error.");
        }
    }

    private boolean validatePayment(double amount) {
        return amount > 0;
    }

    private boolean authenticateToken() {
        return paypalToken != null && !paypalToken.isEmpty();
    }

    public void printPaypalDetails() {
        printPaymentDetails();
        System.out.println("PayPal ID: " + paypalId);
        System.out.println("PayPal Token: " + (paypalToken != null ? "Valid" : "Invalid"));
    }
}
public class PaymentStripe extends Payment {
    private String stripeApiKey;
    private String stripeCustomerId;

    public PaymentStripe(String apiKey, String stripeCustomerId, String customerId) {
        super(customerId);
        this.stripeApiKey = apiKey;
        this.stripeCustomerId = stripeCustomerId;
    }

    @Override
    public void pay(double amount) {
        if (validatePayment(amount) && authenticateStripe()) {
            System.out.println("Using Stripe API to process $" + amount + " payment.");
        } else {
            System.out.println("Stripe payment failed. Check API key and amount.");
        }
    }

    private boolean validatePayment(double amount) {
        return amount > 0;
    }

    private boolean authenticateStripe() {
        return stripeApiKey != null && !stripeApiKey.isEmpty();
    }

    public void printStripeDetails() {
        printPaymentDetails();
        System.out.println("Stripe Customer ID: " + stripeCustomerId);
    }
}
public class PaymentCrypto extends Payment {
    private String walletAddress;
    private String cryptoType;

    public PaymentCrypto(String walletAddress, String cryptoType, String customerId) {
        super(customerId);
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
    }

    @Override
    public void pay(double amount) {
        if (validatePayment(amount)) {
            System.out.println("Transferring " + amount + " " + cryptoType + " to wallet " + walletAddress);
        } else {
            System.out.println("Crypto payment failed. Invalid amount.");
        }
    }

    private boolean validatePayment(double amount) {
        return amount > 0;
    }

    public void printCryptoDetails() {
        printPaymentDetails();
        System.out.println("Crypto Wallet: " + walletAddress);
        System.out.println("Crypto Type: " + cryptoType);
    }
}
