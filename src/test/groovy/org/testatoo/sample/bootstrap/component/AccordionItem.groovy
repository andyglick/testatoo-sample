package org.testatoo.sample.bootstrap.component

import org.testatoo.bundle.html5.A
import org.testatoo.bundle.html5.Div
import org.testatoo.core.By
import org.testatoo.core.ComponentException
import org.testatoo.core.CssIdentifier
import org.testatoo.core.component.Item
import org.testatoo.core.component.Panel
import org.testatoo.core.support.property.TitleSupport
import org.testatoo.core.support.state.SelectSupport

import static org.testatoo.core.Testatoo.config
import static org.testatoo.core.input.MouseModifiers.LEFT
import static org.testatoo.core.input.MouseModifiers.SINGLE

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@CssIdentifier('.panel-default')
class AccordionItem extends Item implements TitleSupport, SelectSupport {
    String value() {
        config.evaluator.eval(id(), 'it.find(".panel-heading h4").text().trim()')
    }

    boolean selected() {
        config.evaluator.check(id(), 'it.find(".panel-heading ~ .panel-collapse").hasClass("in")')
    }

    @Override
    void click() {
        config.evaluator.click(find(By.css('a'), A)[0].id(), [LEFT, SINGLE], [])
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

    Panel getPanel() {
        find(By.css('.panel-collapse'), Div)[0]
    }
}