package app.features.snippets.model;

import app.common.model.AbstractDocument;
import lombok.Data;

import java.net.URL;

@Data
public class SnippetDocument extends AbstractDocument {

    private String snippetHtml;
    private URL repositoryLink;
}
