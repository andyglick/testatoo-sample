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

import org.testatoo.core.ByJs
import org.testatoo.core.Component
import org.testatoo.core.property.Value

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@ByJs("el.attr('role') == 'progressbar'")
class ProgressBar extends Component {

    public ProgressBar() {
        support Value, { eval("document.getElementById(el.attr('id')).style.width") }
    }
}