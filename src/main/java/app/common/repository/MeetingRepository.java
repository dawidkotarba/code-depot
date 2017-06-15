package app.common.repository;

import app.common.model.Meeting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface MeetingRepository extends MongoRepository<Meeting, String>, QueryDslPredicateExecutor<Meeting> {
}
