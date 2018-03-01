package enums

import enums.Alignment
import spock.lang.Specification

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.IsEqual.equalTo


class AlignmentSpec extends Specification {
    def 'An alignment has a text representation'(){
        expect:
        assertThat Alignment.NEUTRAL.text, equalTo('Neutral')
    }

}
