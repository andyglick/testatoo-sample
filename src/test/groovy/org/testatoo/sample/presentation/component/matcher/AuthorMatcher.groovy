package org.testatoo.sample.presentation.component.matcher

import org.hamcrest.Description
import org.testatoo.hamcrest.PropertyMatcher
import org.testatoo.sample.presentation.component.support.AuthorSupport

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class AuthorMatcher extends PropertyMatcher<AuthorSupport> {
    private String value

    AuthorMatcher(String value) {
        this.value = value
    }

    @Override
    protected boolean matchesSafely(AuthorSupport component) {
        component.author() == value
    }

    @Override
    void describeTo(Description description) {
        description.appendText('value ') appendValue(value)
    }

    @Override
    protected void describeMismatchSafely(AuthorSupport component, Description mismatchDescription) {
        mismatchDescription.appendText('has value ').appendValue(component.author())
    }
}
