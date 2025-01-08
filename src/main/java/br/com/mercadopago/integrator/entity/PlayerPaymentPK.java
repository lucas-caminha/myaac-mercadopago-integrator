package br.com.mercadopago.integrator.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PlayerPaymentPK implements Serializable {

	private static final long serialVersionUID = -1153205668497734857L;
	
    private String playerAccountName;
    private String idPayment;
    
    public PlayerPaymentPK() {
    }

    public PlayerPaymentPK(String playerAccountName, String idPayment) {
        this.playerAccountName = playerAccountName;
        this.idPayment = idPayment;
    }

    public String getPlayerAccountName() {
        return playerAccountName;
    }

    public void setPlayerAccountName(String playerAccountName) {
        this.playerAccountName = playerAccountName;
    }

    public String getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(String idPayment) {
        this.idPayment = idPayment;
    }

}
