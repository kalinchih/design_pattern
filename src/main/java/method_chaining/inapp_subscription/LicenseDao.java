package method_chaining.inapp_subscription;

public class LicenseDao implements Cloneable {

    public String licenseId;
    public boolean isAutoRenew;
    public long expiryDate;
    public long provisionPeriod;
    public int skuId;
    public String iapVerifyResult;
    public String entityEvent;
    public String[] behaviorEvents;

    @Override
    public LicenseDao clone() {
        try {
            return (LicenseDao) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
