package app.common.repository;

import app.authentication.model.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserRepository extends MongoRepository<UserDocument, String>, QueryDslPredicateExecutor<UserDocument> {
    UserDocument findByUsername(final String username);
}