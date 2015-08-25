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
package presentation.component

import org.testatoo.core.ByJs
import org.testatoo.core.Component
import org.testatoo.core.property.Size
import org.testatoo.core.property.Title
import presentation.component.property.Author
import presentation.component.property.Company
import presentation.component.property.Slides

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@ByJs("it.data('role') == 'slides'")
class Presentation extends Component {

    Presentation() {
        support Title, { eval("it.find('h1').text()") }
        support Size, { eval("it.find('section').length") as int }
        support Slides, Author, Company
    }
}