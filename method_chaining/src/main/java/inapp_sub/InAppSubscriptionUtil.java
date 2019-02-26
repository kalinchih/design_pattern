package inapp_sub;

import java.time.Instant;

public class InAppSubscriptionUtil {

    private LicenseDao licenseDao;
    private String iapVerifyResult;
    private String correlationId;

    InAppSubscriptionUtil(LicenseDao licenseDao, String iapVerifyResult) {
        this.licenseDao = licenseDao;
        this.iapVerifyResult = iapVerifyResult;
        this.correlationId = String.valueOf(Instant.now().toEpochMilli());
    }

    InAppSubscriptionUtil handleExpiry(long subscriptionStartDate, long subscriptionExpiryDate) {
        licenseDao.expiryDate = subscriptionExpiryDate;
        licenseDao.provisionPeriod = subscriptionExpiryDate - subscriptionStartDate;
        return this;
    }

    InAppSubscriptionUtil handleIsAutoRenew(boolean subscriptionIsAutoRenew) {
        licenseDao.isAutoRenew = subscriptionIsAutoRenew;
        return this;
    }

    InAppSubscriptionUtil handleSku(int subscriptionSkuId) {
        licenseDao.skuId = subscriptionSkuId;
        return this;
    }

    LicenseDao getLicenseDao() {
        return this.licenseDao;
    }
}
