import org.testatoo.hamcrest.PropertyMatcher
import org.testatoo.sample.bootstrap.component.matcher.TabSizeMatcher
import org.testatoo.sample.presentation.component.matcher.SlideSizeMatcher

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class GroovyExtensions {
    static PropertyMatcher getSlides(Integer number) {
        new SlideSizeMatcher(number)
    }

    static PropertyMatcher getTabs(Integer number) {
        new TabSizeMatcher(number)
    }
}
