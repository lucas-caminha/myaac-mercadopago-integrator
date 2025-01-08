package br.com.mercadopago.integrator.request;


import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreatePixPaymentRequest implements Serializable {

    private static final long serialVersionUID = -6046102899458138368L;

    @NotNull(message = "transactionAmount cannot be null or blank.")
    @Min(value = 1, message = "The transaction amount must be positive.")
    private Double transactionAmount;

    @NotBlank(message = "description cannot be null or blank.")
    private String description;

    @NotBlank(message = "paymentMethodId cannot be null or blank.")
    private String paymentMethodId;

    @NotBlank(message = "payerEmail cannot be null or blank")
    @Email(message = "payerEmail must be valid")
    private String payerEmail;

    @NotBlank(message = "playerNameAccount cannot be null or blank.")
    private String playerNameAccount;

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public String getPlayerNameAccount() {
        return playerNameAccount;
    }

    public void setPlayerNameAccount(String playerNameAccount) {
        this.playerNameAccount = playerNameAccount;
    }
}
