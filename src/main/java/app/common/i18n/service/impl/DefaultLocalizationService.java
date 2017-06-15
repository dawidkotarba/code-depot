package app.common.i18n.service.impl;

import app.config.LocalizationConfig;
import app.common.i18n.service.LocalizationService;
import org.springframework.context.MessageSource;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Locale;

public class DefaultLocalizationService implements LocalizationService {

    private static LocalizationService instance;
    private final MessageSource messageSource;
    private final LocalizationConfig localizationConfig;

    @Inject
    public DefaultLocalizationService(final MessageSource messageSource, final LocalizationConfig localizationConfig) {
        this.messageSource = messageSource;
        this.localizationConfig = localizationConfig;
    }

    @PostConstruct
    public void init() {
        instance = this;
    }

    @Override
    public String getMessage(final String code) {
        return messageSource.getMessage(code, null, localizationConfig.getDefaultLocale());
    }

    @Override
    public String getMessage(final String code, String locale) {
        return messageSource.getMessage(code, null, getLocale(locale));
    }

    @Override
    public String getMessage(final String code, final Object[] args) {
        return messageSource.getMessage(code, args, localizationConfig.getDefaultLocale());
    }

    @Override
    public String getMessage(final String code, final Object[] args, String locale) {
        return messageSource.getMessage(code, args, getLocale(locale));
    }

    private Locale getLocale(String locale) {
        return new Locale.Builder().setLanguageTag(locale).build();
    }

    public static LocalizationService getInstance() {
        return instance;
    }
}
