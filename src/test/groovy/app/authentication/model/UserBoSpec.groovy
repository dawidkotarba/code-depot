package app.authentication.model

import app.common.repository.UserRepository
import helpers.AbstractIntegrationSpec
import org.junit.Test

import javax.inject.Inject

class UserBoSpec extends AbstractIntegrationSpec {

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
