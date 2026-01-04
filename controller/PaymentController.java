package com.res.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.Utils;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:8082") // Change this to your frontend port
public class PaymentController {

    private static final String KEY_ID = "rzp_test_rYfrB1X0sV11af"; // Your Test Key ID
    private static final String KEY_SECRET = "0SLo3TeBfzzijJZkofEIIzJG"; // Your Test Key Secret

    /**
     * Create Razorpay Order
     */
    @PostMapping("/create-order")
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> data) throws Exception {
        int amount = (int) data.get("amount"); // Amount in paise
        String currency = (String) data.get("currency");

        RazorpayClient client = new RazorpayClient(KEY_ID, KEY_SECRET);

        JSONObject options = new JSONObject();
        options.put("amount", amount);
        options.put("currency", currency);
        options.put("payment_capture", 1); // Auto capture

        Order order = client.orders.create(options);

        Map<String, Object> response = new HashMap<>();
        response.put("id", order.get("id"));
        response.put("amount", order.get("amount"));
        response.put("currency", order.get("currency"));
        return response;
    }

    /**
     * Verify Razorpay Payment Signature
     */
    @PostMapping("/verify")
    public Map<String, String> verifyPayment(@RequestBody Map<String, String> data) {
        Map<String, String> response = new HashMap<>();
        try {
            JSONObject attributes = new JSONObject();
            attributes.put("razorpay_order_id", data.get("razorpay_order_id"));
            attributes.put("razorpay_payment_id", data.get("razorpay_payment_id"));
            attributes.put("razorpay_signature", data.get("razorpay_signature"));

            // If no exception is thrown, verification is successful
            Utils.verifyPaymentSignature(attributes, KEY_SECRET);

            response.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "failure");
        }
        return response;
    }
}
