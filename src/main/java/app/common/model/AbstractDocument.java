package app.common.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document
@Data
public abstract class AbstractDocument implements Serializable {

    @Id
    @NotNull
    private String id;
}