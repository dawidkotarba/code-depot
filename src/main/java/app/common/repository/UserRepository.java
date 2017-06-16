package app.common.repository;

import app.authentication.model.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface UserRepository extends MongoRepository<UserDocument, String>, QueryDslPredicateExecutor<UserDocument> {
    List<UserDocument> findByFirstName(String firstName);

    UserDocument findByUsername(final String username);
}