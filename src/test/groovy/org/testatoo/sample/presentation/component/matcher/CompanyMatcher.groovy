package org.testatoo.sample.presentation.component.matcher

import org.hamcrest.Description
import org.testatoo.hamcrest.PropertyMatcher
import org.testatoo.sample.presentation.component.support.CompanySupport

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class CompanyMatcher extends PropertyMatcher<CompanySupport> {
    private String value

    CompanyMatcher(String value) {
        this.value = value
    }

    @Override
    protected boolean matchesSafely(CompanySupport component) {
        component.company() == value
    }

    @Override
    void describeTo(Description description) {
        description.appendText('value ') appendValue(value)
    }

    @Override
    protected void describeMismatchSafely(CompanySupport component, Description mismatchDescription) {
        mismatchDescription.appendText('has value ').appendValue(component.company())
    }
}