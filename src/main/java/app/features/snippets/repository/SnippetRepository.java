package app.features.snippets.repository;

import app.authentication.model.UserDocument;
import app.features.snippets.model.SnippetDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface SnippetRepository extends MongoRepository<SnippetDocument, String>, QueryDslPredicateExecutor<UserDocument> {
}
