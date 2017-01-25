package org.testatoo.sample.bootstrap.component.matcher

import org.hamcrest.Description
import org.testatoo.hamcrest.PropertyMatcher
import org.testatoo.sample.bootstrap.component.property.TabSupport

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class TabSizeMatcher extends PropertyMatcher<TabSupport> {
    private Integer number

    TabSizeMatcher(Integer number) {
        this.number = number
    }

    @Override
    protected boolean matchesSafely(TabSupport component) {
        component.tabs().size() == number
    }

    @Override
    void describeTo(Description description) {
        description.appendText(number + ' tabs(s)')
    }

    @Override
    protected void describeMismatchSafely(TabSupport component, Description mismatchDescription) {
        mismatchDescription.appendText('has ' + component.tabs().size()).appendText(' tabs(s)')
    }
}

