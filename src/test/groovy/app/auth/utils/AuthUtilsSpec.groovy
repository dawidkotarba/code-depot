package app.auth.utils

import app.auth.model.UserRole
import spock.lang.Specification
import spock.lang.Unroll

class AuthUtilsSpec extends Specification {

    @Unroll
    def "should check if user is authorized for his roles: #userRoles and allowed roles: #allowedRoles"() {
        expect:
        def authorizationResult = AuthUtils.isAuthorized(userRoles, allowedRoles)
        authorizationResult == expectedResult

        where:
        userRoles                    | allowedRoles                                     | expectedResult
        [UserRole.ROLE_ADMIN] as Set | [UserRole.ROLE_ADMIN, UserRole.ROLE_USER] as Set | true
        [UserRole.ROLE_USER] as Set  | [UserRole.ROLE_ADMIN] as Set                     | false
        [UserRole.ROLE_USER] as Set  | [] as Set                                        | false
        [] as Set                    | [UserRole.ROLE_ADMIN] as Set                     | false
    }
}
