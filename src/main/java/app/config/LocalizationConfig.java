package app.config;

import app.common.i18n.service.LocalizationService;
import app.common.i18n.service.impl.DefaultLocalizationService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Locale;

@Configuration
@ConfigurationProperties(prefix = "default")
public class LocalizationConfig {

    @Setter
    private String locale;

    @Getter
    private Locale defaultLocale;

    @PostConstruct
    public void init() {
        defaultLocale = new Locale.Builder().setLanguageTag(locale).build();
    }

    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:i18n/messages", "classpath:i18n/exceptions");
        return messageSource;
    }

    @Bean
    @Inject
    public LocalizationService localizationService(final MessageSource messageSource, final LocalizationConfig localizationConfig) {
        return new DefaultLocalizationService(messageSource, localizationConfig);
    }
}