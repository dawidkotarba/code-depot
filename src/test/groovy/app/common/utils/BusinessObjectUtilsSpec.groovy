package app.common.utils

import helpers.AbstractUnitSpec

class BusinessObjectUtilsSpec extends AbstractUnitSpec {

    def "should get bean name from class"() {
        given:
        def testObjectClass = Object.class

        when:
        def result = BusinessObjectUtils.getBeanNameFromClass(testObjectClass)

        then:
        result == "object"
    }

    def "should throw exception when getting bean name from null class"() {
        given:
        def testObjectClass = null

        when:
        BusinessObjectUtils.getBeanNameFromClass(testObjectClass)

        then:
        thrown Exception
    }
}
