package kz.zhelezyaka.license.service;

import kz.zhelezyaka.license.model.License;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LicenseService {

    public License getLicense(String licenseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(1_000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("GStock");
        license.setLicenseType("full");
        return license;
    }

    private static String generateResponseMessage(License license, String action, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format("This is the %s and the object is: %s",
                    action, license);
        }
        return responseMessage;
    }

    public String createLicense(License license, String organizationId) {
        return generateResponseMessage(license, "POST", organizationId);
    }

    public String updateLicense(License license, String organizationId) {
        return generateResponseMessage(license, "PUT", organizationId);
    }

    public String deleteLicense(String licenseId, String organizationId) {
        return String.format("Deleting license with id %s for the organization %s",
                licenseId, organizationId);
    }
}
