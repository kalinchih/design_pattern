package inapp_sub;

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
        System.out.println(toString(newLicenseDao));
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
