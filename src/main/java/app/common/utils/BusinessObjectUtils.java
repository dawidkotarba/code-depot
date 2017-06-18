package app.common.utils;

import app.common.repository.RepositoriesBeanHolder;
import com.google.common.base.Preconditions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.util.StringUtils;

public final class BusinessObjectUtils {

    private BusinessObjectUtils() {
        // intentionally left blank
    }

    public static String getBeanNameFromClass(final Class clazz) {
        Preconditions.checkNotNull(clazz);
        return StringUtils.uncapitalize(clazz.getSimpleName());
    }

    public static MongoRepository getRepositoryByName(final String mongoRepositoryName) {
        return RepositoriesBeanHolder.getRepositoryByName(mongoRepositoryName).get();
    }
}
