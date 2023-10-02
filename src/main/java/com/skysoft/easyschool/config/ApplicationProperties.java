package com.skysoft.easyschool.config;

import com.skysoft.easyschool.utils.ApplicationDefaultsUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Properties specific to LocalExternCRM.
 * <p>
 * Properties are configured in the {@code application-*.yml} file.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private final Security security = new Security();
    private final Swagger swagger = new Swagger();
    private final Upload upload = new Upload();
    private final ClientApp clientApp = new ClientApp();
    private final Resources resources = new Resources();
    private final CorsConfiguration cors = new CorsConfiguration();

    public ApplicationProperties() {
    }

    public CorsConfiguration getCors() {
        return cors;
    }

    public Security getSecurity() {
        return security;
    }

    public Swagger getSwagger() {
        return swagger;
    }

    public Upload getUpload() {
        return upload;
    }

    public ClientApp getClientApp() {
        return clientApp;
    }

    public Resources getResources() {
        return resources;
    }

    public static class Security {
        private final Security.ClientAuthorization clientAuthorization = new Security.ClientAuthorization();
        private final Security.Authentication authentication = new Security.Authentication();
        private final Security.RememberMe rememberMe = new Security.RememberMe();
        private final Security.OAuth2 oauth2 = new Security.OAuth2();

        public Security() {
        }

        public Security.ClientAuthorization getClientAuthorization() {
            return this.clientAuthorization;
        }

        public Security.Authentication getAuthentication() {
            return this.authentication;
        }

        public Security.RememberMe getRememberMe() {
            return this.rememberMe;
        }

        public Security.OAuth2 getOauth2() {
            return this.oauth2;
        }

        public static class OAuth2 {
            private List<String> audience = new ArrayList();

            public OAuth2() {
            }

            public List<String> getAudience() {
                return Collections.unmodifiableList(this.audience);
            }

            public void setAudience(@NotNull List<String> audience) {
                this.audience.addAll(audience);
            }
        }

        public static class RememberMe {
            @NotNull
            private String key;

            public RememberMe() {
                this.key = ApplicationDefaultsUtils.Security.RememberMe.key;
            }

            public String getKey() {
                return this.key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }

        public static class Authentication {
            private final Security.Authentication.Jwt jwt = new Security.Authentication.Jwt();

            public Authentication() {
            }

            public Security.Authentication.Jwt getJwt() {
                return this.jwt;
            }

            public static class Jwt {
                private String secret;
                private String base64Secret;
                private long tokenValidityInSeconds;
                private long tokenValidityInSecondsForRememberMe;

                public Jwt() {
                    this.secret = ApplicationDefaultsUtils.Security.Authentication.Jwt.secret;
                    this.base64Secret = ApplicationDefaultsUtils.Security.Authentication.Jwt.base64Secret;
                    this.tokenValidityInSeconds = 1800L;
                    this.tokenValidityInSecondsForRememberMe = 2592000L;
                }

                public String getSecret() {
                    return this.secret;
                }

                public void setSecret(String secret) {
                    this.secret = secret;
                }

                public String getBase64Secret() {
                    return this.base64Secret;
                }

                public void setBase64Secret(String base64Secret) {
                    this.base64Secret = base64Secret;
                }

                public long getTokenValidityInSeconds() {
                    return this.tokenValidityInSeconds;
                }

                public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
                    this.tokenValidityInSeconds = tokenValidityInSeconds;
                }

                public long getTokenValidityInSecondsForRememberMe() {
                    return this.tokenValidityInSecondsForRememberMe;
                }

                public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
                    this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
                }
            }
        }

        public static class ClientAuthorization {
            private String accessTokenUri;
            private String tokenServiceId;
            private String clientId;
            private String clientSecret;

            public ClientAuthorization() {
                this.accessTokenUri = ApplicationDefaultsUtils.Security.ClientAuthorization.accessTokenUri;
                this.tokenServiceId = ApplicationDefaultsUtils.Security.ClientAuthorization.tokenServiceId;
                this.clientId = ApplicationDefaultsUtils.Security.ClientAuthorization.clientId;
                this.clientSecret = ApplicationDefaultsUtils.Security.ClientAuthorization.clientSecret;
            }

            public String getAccessTokenUri() {
                return this.accessTokenUri;
            }

            public void setAccessTokenUri(String accessTokenUri) {
                this.accessTokenUri = accessTokenUri;
            }

            public String getTokenServiceId() {
                return this.tokenServiceId;
            }

            public void setTokenServiceId(String tokenServiceId) {
                this.tokenServiceId = tokenServiceId;
            }

            public String getClientId() {
                return this.clientId;
            }

            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            public String getClientSecret() {
                return this.clientSecret;
            }

            public void setClientSecret(String clientSecret) {
                this.clientSecret = clientSecret;
            }
        }
    }

    public static class Swagger {
        private String title = "Application API";
        private String description = "API documentation";
        private String version = "0.0.1";
        private String termsOfServiceUrl;
        private String contactName;
        private String contactUrl;
        private String contactEmail;
        private String license;
        private String licenseUrl;
        private String defaultIncludePattern;
        private String host;
        private String[] protocols;
        private boolean useDefaultResponseMessages;

        public Swagger() {
            this.termsOfServiceUrl = ApplicationDefaultsUtils.Swagger.termsOfServiceUrl;
            this.contactName = ApplicationDefaultsUtils.Swagger.contactName;
            this.contactUrl = ApplicationDefaultsUtils.Swagger.contactUrl;
            this.contactEmail = ApplicationDefaultsUtils.Swagger.contactEmail;
            this.license = ApplicationDefaultsUtils.Swagger.license;
            this.licenseUrl = ApplicationDefaultsUtils.Swagger.licenseUrl;
            this.defaultIncludePattern = "/api/.*";
            this.host = ApplicationDefaultsUtils.Swagger.host;
            this.protocols = ApplicationDefaultsUtils.Swagger.protocols;
            this.useDefaultResponseMessages = true;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTermsOfServiceUrl() {
            return this.termsOfServiceUrl;
        }

        public void setTermsOfServiceUrl(String termsOfServiceUrl) {
            this.termsOfServiceUrl = termsOfServiceUrl;
        }

        public String getContactName() {
            return this.contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactUrl() {
            return this.contactUrl;
        }

        public void setContactUrl(String contactUrl) {
            this.contactUrl = contactUrl;
        }

        public String getContactEmail() {
            return this.contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public String getLicense() {
            return this.license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getLicenseUrl() {
            return this.licenseUrl;
        }

        public void setLicenseUrl(String licenseUrl) {
            this.licenseUrl = licenseUrl;
        }

        public String getDefaultIncludePattern() {
            return this.defaultIncludePattern;
        }

        public void setDefaultIncludePattern(String defaultIncludePattern) {
            this.defaultIncludePattern = defaultIncludePattern;
        }

        public String getHost() {
            return this.host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String[] getProtocols() {
            return this.protocols;
        }

        public void setProtocols(String[] protocols) {
            this.protocols = protocols;
        }

        public boolean isUseDefaultResponseMessages() {
            return this.useDefaultResponseMessages;
        }

        public void setUseDefaultResponseMessages(boolean useDefaultResponseMessages) {
            this.useDefaultResponseMessages = useDefaultResponseMessages;
        }
    }

    public static class ClientApp {
        private String name = "EasySchool";

        public ClientApp() {
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Upload{
        private String resourcesServerStore;
        private String resourcesServerStoreUrl;

        public String getResourcesServerStore() {
            return resourcesServerStore;
        }

        public void setResourcesServerStore(String resourcesServerStore) {
            this.resourcesServerStore = resourcesServerStore;
        }

        public String getResourcesServerStoreUrl() {
            return resourcesServerStoreUrl;
        }

        public void setResourcesServerStoreUrl(String resourcesServerStoreUrl) {
            this.resourcesServerStoreUrl = resourcesServerStoreUrl;
        }
    }

    public static class Resources {
        private String locationExcelFile;
        private String locationPdfFile;

        public Resources() {
        }

        public String getLocationExcelFile() {
            return locationExcelFile;
        }

        public void setLocationExcelFile(String locationExcelFile) {
            this.locationExcelFile = locationExcelFile;
        }

        public String getLocationPdfFile() {
            return locationPdfFile;
        }

        public void setLocationPdfFile(String locationPdfFile) {
            this.locationPdfFile = locationPdfFile;
        }
    }
}
