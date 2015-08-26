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
package login

import org.testatoo.bundle.html5.Button
import org.testatoo.bundle.html5.Heading
import org.testatoo.bundle.html5.Panel
import org.testatoo.bundle.html5.input.EmailField
import org.testatoo.bundle.html5.input.PasswordField
import org.testatoo.core.Testatoo
import org.testatoo.core.property.Title

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class Factory extends Testatoo {

    EmailField email_field = $('[name="email"]') as EmailField
    PasswordField password_field = $('[name="password"]') as PasswordField
    Button login_button = $('input[type=submit]') as Button
    LoginPanel login_panel =  $('#login-form') as LoginPanel
    Heading login_succes = $('[data-role=logged]') as Heading
    Heading error_message = $('[data-role="invalid-credentials"]') as Heading

    class LoginPanel extends Panel {
        LoginPanel() {
            support Title, { eval("it.find('h1').text()") }
        }
    }
}
