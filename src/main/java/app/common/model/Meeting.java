package app.common.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Meeting {

    @Id
    private String id;

    private String name;
    private Date startTime;
    private Date endTime;
}
