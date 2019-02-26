package method_chaining.inapp_subscription;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ObjectUtils;

public class Main {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        LicenseDao oldLicenseDao = new LicenseDao();
        LicenseDao newLicenseDao = ObjectUtils.clone(oldLicenseDao);
        LicenseDaoHandlerChain licenseDaoHandlerChain = new LicenseDaoHandlerChain(newLicenseDao, "iap_verify_result");
        licenseDaoHandlerChain.handleExpiry(6, 20).handleIsAutoRenew(true).handleSku(3);
        newLicenseDao = licenseDaoHandlerChain.getLicenseDao();
        System.out.println(toString(oldLicenseDao));
        // {"licenseId":null,"isAutoRenew":false,"expiryDate":0,"provisionPeriod":0,"skuId":0,"iapVerifyResult":null,"entityEvent":null,
        //        "behaviorEvents":null}

        System.out.println(toString(newLicenseDao));
        // {"licenseId":null,"isAutoRenew":true,"expiryDate":20,"provisionPeriod":14,"skuId":3,"iapVerifyResult":null,"entityEvent":null,
        //    "behaviorEvents":null}
    }

    private static String toString(Object object) {
        if (object != null) {
            try {
                return objectMapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
