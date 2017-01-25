/**
 * Copyright (C) 2014 Ovea (dev@ovea.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.testatoo.sample.presentation.component

import org.testatoo.bundle.html5.Section
import org.testatoo.core.By
import org.testatoo.core.CssIdentifier
import org.testatoo.core.component.Component
import org.testatoo.core.support.property.TitleSupport
import org.testatoo.sample.presentation.component.support.AuthorSupport
import org.testatoo.sample.presentation.component.support.CompanySupport
import org.testatoo.sample.presentation.component.support.SlideSupport

import static org.testatoo.core.Testatoo.getConfig

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@CssIdentifier('[data-role=slides]')
class Presentation extends Component implements TitleSupport, AuthorSupport, CompanySupport, SlideSupport {
    String title() {
        config.evaluator.eval(id(), "it.find('h1').text().trim()")
    }

    String author() {
        config.evaluator.eval(id(), "it.find('[data-role=author]').text().trim()")
    }

    String company() {
        config.evaluator.eval(id(), "it.find('[data-role=company]').text().trim()")
    }

    List<Section> slides() {
        find(By.css('section'), Section)
    }
}