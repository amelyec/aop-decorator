package tz.co.werelay.aop_decorator.dtos;

public class TransactionResponse {
    private String status;
    private String transactionId;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    
}
