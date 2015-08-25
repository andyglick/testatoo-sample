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
package bootstrap.component

import org.testatoo.bundle.html5.Panel
import org.testatoo.core.ByJs
import org.testatoo.core.Component
import org.testatoo.core.property.Items
import org.testatoo.core.property.Size
import org.testatoo.core.property.Title
import org.testatoo.core.state.Selected
import org.testatoo.core.state.Unselected

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@ByJs("it.hasClass('panel-group')")
class Accordion extends Component {

    Accordion() {
        support Size, { eval("it.find('.panel-heading a').length") as int }
        support Items, { find('.panel-heading a', Item) }
    }

    List<Item> getItems() {
        find('.panel-heading a', Item)
    }

    @ByJs("it.is('a') && it.closest('div').hasClass('panel-heading')")
    private class Item extends Component {
        Item() {
            support Title, { eval('it.text()') }
            support Selected, {
                it.check("\$('#" + eval("it.attr('href').substring(1)") + "').hasClass('in')")
            }
            support Unselected, { !it.check("\$('#" + eval("it.attr('href').substring(1)") + "').hasClass('in')") }
        }

        Panel getPanel() {
            $('#' + eval("it.attr('href').substring(1)")) as Panel
        }
    }
}
