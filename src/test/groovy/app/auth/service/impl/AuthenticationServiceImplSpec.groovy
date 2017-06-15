package app.auth.service.impl

import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.core.Authentication
import spock.lang.Specification
import spock.lang.Unroll

class AuthenticationServiceImplSpec extends Specification {

    def daoAuthenticationProvider = Stub(DaoAuthenticationProvider)
    def underTest = new AuthenticationServiceImpl(daoAuthenticationProvider)

    @Unroll
    def "should authenticate user"() {
        given:
        def authenticationResult = Stub(Authentication)
        authenticationResult.authenticated >> true
        daoAuthenticationProvider.authenticate(_ as Authentication) >> authenticationResult

        expect:
        Authentication result = underTest.authenticate(_ as String, _ as String)
        result.authenticated == true
    }
}
