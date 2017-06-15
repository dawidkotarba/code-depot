package app.auth.service.impl

import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.core.Authentication
import spock.lang.Specification
import spock.lang.Unroll

class AuthenticationServiceImplSpec extends Specification {

    def daoAuthenticationProvider = Stub(DaoAuthenticationProvider)
    def underTest = new AuthenticationServiceImpl(daoAuthenticationProvider)

    @Unroll
    def "should authenticate user as #isAuthenticated"() {
        given:
        def authenticationResult = Stub(Authentication)
        authenticationResult.authenticated >> isAuthenticated
        daoAuthenticationProvider.authenticate(_ as Authentication) >> authenticationResult

        expect:
        Authentication result = underTest.authenticate(_ as String, _ as String)
        result.authenticated == expectedResult

        where:
        isAuthenticated | expectedResult
        false           | false
        true            | true
    }

    @Unroll
    def "should not allow putting empty data for username: #username and password: #password"() {
        when:
        underTest.authenticate(username, password)

        then:
        thrown Exception

        where:
        username | password
        null     | null
        _        | null
        null     | _
    }
}