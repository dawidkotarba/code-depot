package app.common.view.components

import com.vaadin.ui.TextField
import spock.lang.Specification

class ErrorAwareButtonTest extends Specification {

    def testTextField = Stub(TextField)
    def underTest = new TestableErrorAwareButton("", testTextField)

    def "MarkIfNoError"() {
    }

    def "EnableIfAllValid"() {
    }

    def "SetErrorDescription"() {
    }

    def "should enable button"() {
        given:
        underTest.setErrorDescription() >> null
        underTest.enabled = false

        when:
        underTest.enable()

        then:
        underTest.enabled
    }

    def "Disable"() {
    }

    class TestableErrorAwareButton extends ErrorAwareButton {

        TestableErrorAwareButton(final String caption, final TextField... fieldsToCheckErrors) {
            super(caption, fieldsToCheckErrors)
            ErrorAwareButton
        }

        @Override
        def void setErrorDescription() {
            // intentionally left blank
        }
    }
}
