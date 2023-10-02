package com.skysoft.easyschool.security;

import com.skysoft.easyschool.utils.ConstantsUtils;
import com.skysoft.easyschool.utils.SecurityUtils;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Implementation of {@link AuditorAware} based on Spring Security.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(SecurityUtils.getCurrentUserLogin().orElse(ConstantsUtils.SYSTEM_ACCOUNT));
    }
}
