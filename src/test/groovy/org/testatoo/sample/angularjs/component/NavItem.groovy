package org.testatoo.sample.angularjs.component

import org.testatoo.core.ComponentException
import org.testatoo.core.CssIdentifier
import org.testatoo.core.component.Item
import org.testatoo.core.support.property.TitleSupport
import org.testatoo.core.support.state.SelectSupport

import static org.testatoo.core.Testatoo.config

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@CssIdentifier('a')
class NavItem extends Item implements TitleSupport, SelectSupport {
    String value() {
        config.evaluator.eval(id(), 'it.text().trim()')
    }

    boolean selected() {
        config.evaluator.check(id(), "it.attr('class') === it.closest('nav').attr('class')")
    }

    void select() {
        if (!enabled())
            throw new ComponentException("${this.class.simpleName} ${this} is disabled and cannot be selected")
        if (!selected()) {
            this.click()
        } else
            throw new ComponentException("${this.class.simpleName} ${this} is already selected and cannot be selected")
    }

    void unselect() {
        throw new ComponentException("${this.class.simpleName} ${this} cannot be unselected (Unsupported Operation)")
    }

    String title() {
        value()
    }

}
