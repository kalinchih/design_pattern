package inapp_sub;

import java.time.Instant;

public class LicenseDaoHandlerChain {

    private LicenseDao licenseDao;
    private String iapVerifyResult;
    private String correlationId;

    LicenseDaoHandlerChain(LicenseDao licenseDao, String iapVerifyResult) {
        this.licenseDao = licenseDao;
        this.iapVerifyResult = iapVerifyResult;
        this.correlationId = String.valueOf(Instant.now().toEpochMilli());
    }

    LicenseDaoHandlerChain handleExpiry(long subscriptionStartDate, long subscriptionExpiryDate) {
        licenseDao.expiryDate = subscriptionExpiryDate;
        licenseDao.provisionPeriod = subscriptionExpiryDate - subscriptionStartDate;
        return this;
    }

    LicenseDaoHandlerChain handleIsAutoRenew(boolean subscriptionIsAutoRenew) {
        licenseDao.isAutoRenew = subscriptionIsAutoRenew;
        return this;
    }

    LicenseDaoHandlerChain handleSku(int subscriptionSkuId) {
        licenseDao.skuId = subscriptionSkuId;
        return this;
    }

    LicenseDao getLicenseDao() {
        return this.licenseDao;
    }
}
