package org.testatoo.sample.presentation.component.matcher

import org.hamcrest.Description
import org.testatoo.hamcrest.PropertyMatcher
import org.testatoo.sample.presentation.component.support.SlideSupport

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class SlideSizeMatcher extends PropertyMatcher<SlideSupport> {
    private Integer number

    SlideSizeMatcher(Integer number) {
        this.number = number
    }

    @Override
    protected boolean matchesSafely(SlideSupport component) {
        component.slides().size() == number
    }

    @Override
    void describeTo(Description description) {
        description.appendText(number + ' slide(s)')
    }

    @Override
    protected void describeMismatchSafely(SlideSupport component, Description mismatchDescription) {
        mismatchDescription.appendText('has ' + component.slides().size()).appendText(' slide(s)')
    }
}
