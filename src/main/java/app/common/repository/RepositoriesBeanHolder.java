package app.common.repository;

import com.google.common.base.Preconditions;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.Optional;

@Named
public class RepositoriesBeanHolder {

    private static Map<String, MongoRepository> repositories;

    @Inject
    public RepositoriesBeanHolder(final Map<String, MongoRepository> repositories) {
        RepositoriesBeanHolder.repositories = repositories;
    }

    public static Optional<MongoRepository> getRepositoryByName(final String name) {
        Preconditions.checkNotNull(name);
        Preconditions.checkArgument(!name.isEmpty());
        return Optional.ofNullable(repositories.get(name));
    }
}
