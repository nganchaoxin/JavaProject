package xmlbasedconfiguration.pojobeans;

import java.util.Date;

public class Account {
    private long id;
    private String ownername;
    private double balance;
    private Date accesTime;
    private boolean locked;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getAccesTime() {
        return accesTime;
    }

    public void setAccesTime(Date accesTime) {
        this.accesTime = accesTime;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }


}
