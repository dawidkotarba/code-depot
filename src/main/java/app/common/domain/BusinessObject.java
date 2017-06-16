package app.common.domain;

import app.common.model.AbstractDocument;
import com.google.common.base.Preconditions;
import lombok.Data;
import lombok.Getter;

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

    public BusinessObject(final T document, final Class<T> clazz) {
        Preconditions.checkNotNull(document);
        Preconditions.checkNotNull(clazz);
        this.document = document;
        this.clazz = clazz;
    }
}
