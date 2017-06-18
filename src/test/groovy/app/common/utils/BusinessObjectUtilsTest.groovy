package app.common.utils

import helpers.AbstractIntegrationTest
import org.junit.Test

class BusinessObjectUtilsTest extends AbstractIntegrationTest {

    @Test
    def "should get repository by name"() {
        given:
        def mongoRepositoryName = "userRepository"

        when:
        def result = BusinessObjectUtils.getRepositoryByName(mongoRepositoryName)

        then:
        result != null
    }
}
