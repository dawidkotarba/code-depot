package app.common.domain;

import app.common.model.AbstractDocument;
import app.common.utils.BusinessObjectUtils;
import com.google.common.base.Preconditions;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BusinessObject<T extends AbstractDocument> implements Serializable {

    @NotNull
    @Getter
    private final T document;

    @NotNull
    @Getter
    private final Class<T> clazz;

    @NotNull
    @Getter
    private final MongoRepository<T, String> repository;

    public BusinessObject(final T document, final Class<T> clazz, final Class<? extends MongoRepository> mongoRepositoryClass) {
        Preconditions.checkNotNull(document);
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(mongoRepositoryClass);

        this.document = document;
        this.clazz = clazz;
        final String beanNameFromClass = BusinessObjectUtils.getBeanNameFromClass(mongoRepositoryClass);
        repository = BusinessObjectUtils.getRepositoryByName(beanNameFromClass);
    }
}
