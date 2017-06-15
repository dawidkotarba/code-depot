package app.common.i18n.service;

public interface LocalizationService {
    String getMessage(String code);

    String getMessage(String code, String locale);

    String getMessage(String code, Object[] args);

    String getMessage(String code, Object[] args, String locale);
}
