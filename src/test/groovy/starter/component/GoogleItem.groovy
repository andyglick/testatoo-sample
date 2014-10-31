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
package starter.component

import org.testatoo.core.component.Component
import org.testatoo.core.property.Title
import starter.component.property.Description
import starter.component.property.Url

/**
 * Created by david on 07/05/14.
 */
class GoogleItem extends Component {

    GoogleItem() {
        support Title, {
            Component c -> c.evaluator.getString("\$('#${id} h3').text()")
        }
        support Url, Description
    }
}