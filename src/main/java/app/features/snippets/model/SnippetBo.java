package app.features.snippets.model;

import app.common.domain.BusinessObject;
import app.features.snippets.repository.SnippetRepository;

public class SnippetBo extends BusinessObject<SnippetDocument> {
    public SnippetBo(final SnippetDocument document) {
        super(document, SnippetDocument.class, SnippetRepository.class);
    }
}
