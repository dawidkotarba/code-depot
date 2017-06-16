package app.common.repository

import org.springframework.data.mongodb.repository.MongoRepository
import spock.lang.Specification
import spock.lang.Unroll

class RepositoriesBeanHolderSpec extends Specification {

    @Unroll
    def "should provide a repository for name: #repositoryName"() {
        given:
        def testRepo1 = Stub(MongoRepository)
        def testRepo2 = Stub(MongoRepository)
        new RepositoriesBeanHolder(["testRepo1": testRepo1, "testRepo2": testRepo2])

        expect:
        def result = RepositoriesBeanHolder.getRepositoryByName(repositoryName)
        result.isPresent() == expectedResult

        where:
        repositoryName | expectedResult
        "testRepo1"    | true
        "testRepo2"    | true
        "noName"       | false
    }

    def "should not allow check for empty or null bean name"() {
        when:
        RepositoriesBeanHolder.getRepositoryByName(beanName)

        then:
        thrown Exception

        where:
        beanName << ["", null]
    }
}
