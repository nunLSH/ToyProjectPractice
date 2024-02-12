package smu.toyproject1.product;

public class CreditLoan {

    private String company;
    private String productName;
    private String method;
    private String loanType;
    private String cbCompany;
    private String rateType;
    private int averageRate;

    public CreditLoan(String company, String productName, String method, String loanType, String cbCompany, String rateType, int averageRate) {
        this.company = company;
        this.productName = productName;
        this.method = method;
        this.loanType = loanType;
        this.cbCompany = cbCompany;
        this.rateType = rateType;
        this.averageRate = averageRate;
    }

    // 각 변수에 대한 Getter & Setter
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getCbCompany() {
        return cbCompany;
    }

    public void setCbCompany(String cbCompany) {
        this.cbCompany = cbCompany;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public int getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(int averageRate) {
        this.averageRate = averageRate;
    }
}
