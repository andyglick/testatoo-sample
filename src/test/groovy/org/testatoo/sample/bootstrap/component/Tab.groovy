package org.testatoo.sample.bootstrap.component

import org.testatoo.bundle.html5.Div
import org.testatoo.bundle.html5.list.Li
import org.testatoo.core.By
import org.testatoo.core.component.Panel
import org.testatoo.core.support.property.TitleSupport

import static org.testatoo.core.Testatoo.config

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class Tab extends Li implements TitleSupport {
    String title() {
        value()
    }

    @Override
    boolean selected() {
        config.evaluator.check(id(), 'it.hasClass("active")')
    }

    Panel getPanel() {
        String href = config.evaluator.eval(id(), "it.find('a').attr('href').substring(1)")
        find(By.js('\$("#' + href + '")'), Div)[0]
    }
}
