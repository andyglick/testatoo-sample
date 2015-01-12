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
package starter

import org.testatoo.core.Testatoo
import org.testatoo.core.component.Button
import org.testatoo.core.component.input.TextField
import org.testatoo.core.component.list.ListView
import starter.component.GoogleListView

/**
 * Created by david on 07/05/14.
 */
class Factory extends Testatoo {
    TextField searchField = $('#gbqfq') as TextField
    Button searchButton = $('#gbqfba') as Button
    ListView resultList = $('#rso') as ListView

    GoogleListView googleResultList = $('#rso') as GoogleListView
}
