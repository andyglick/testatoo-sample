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
package org.testatoo.sample.login

import org.testatoo.bundle.html5.Button
import org.testatoo.bundle.html5.Div
import org.testatoo.bundle.html5.heading.H1
import org.testatoo.bundle.html5.heading.H4
import org.testatoo.bundle.html5.input.InputTypeEmail
import org.testatoo.bundle.html5.input.InputTypePassword
import org.testatoo.core.component.Heading
import org.testatoo.core.component.field.EmailField
import org.testatoo.core.component.field.PasswordField

import static org.testatoo.core.Testatoo.$
import static org.testatoo.core.Testatoo.getConfig

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class Factory {

    static EmailField email_field = $('[name="email"]') as InputTypeEmail
    static PasswordField password_field = $('[name="password"]') as InputTypePassword
    static Button login_button = $('input[type=submit]') as Button
    static LoginPanel login_panel = $('#login-form') as LoginPanel
    static Heading login_succes = $('[data-role=logged]') as H1
    static Heading error_message = $('[data-role="invalid-credentials"]') as H4

    class LoginPanel extends Div {
        @Override
        String title() {
            config.evaluator.eval(id(), "it.find('h1').text().trim()")
        }
    }
}
