package app.authentication.model

import app.authentication.repository.UserRepository
import helpers.AbstractIntegrationTest
import org.junit.Test

import javax.inject.Inject

class UserBoTest extends AbstractIntegrationTest {

    @Inject
    private UserRepository userRepository

    @Test
    def "should register user"() {
        given:
        def userDocument = new UserDocument()
        def underTest = new UserBo(userDocument)
        def username = "usr"
        def authorities = UserRole.ROLE_USER

        when:
        underTest.register(username, _ as String, authorities)

        then:
        def result = userRepository.findByUsername(username)
        result != null
        result.username == userDocument.username
        result.password != null
        result.authorities.contains authorities
        result.enabled
    }
}
