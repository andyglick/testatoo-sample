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
package org.testatoo.sample.login.functional

import org.junit.Before
import org.junit.ClassRule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.testatoo.sample.WebDriverConfig

import static org.testatoo.core.Testatoo.*
import static org.testatoo.core.internal.Wait.waitUntil
import static org.testatoo.sample.login.Factory.*

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@RunWith(JUnit4)
class LoginTest {
    @ClassRule
    public static WebDriverConfig driver = new WebDriverConfig()

    @Before
    void setup() {
        config.evaluator.registerScripts(this.getClass().getResourceAsStream('/login/jquery.mockjax-1.5.3.min.js').text)
        config.evaluator.registerScripts(this.getClass().getResourceAsStream('/login/mocked-data.js').text)

        visit 'http://localhost:8080/login/index.html'
    }

    @Test
    void can_login() {
        user_is_not_logged()

        fill email_field with 'test@email.org'
        fill password_field with 'password666'

        clickOn login_button

        user_is_logged()
    }

    @Test
    void login_failure() {
        user_is_not_logged()

        fill email_field with 'test@email.org'
        fill password_field with 'bad_credential'

        clickOn login_button

        error_message.should { be visible }
        user_is_not_logged()
    }

    private static void user_is_logged() {
        waitUntil({ login_succes.visible() })
    }

    private static void user_is_not_logged() {
        waitUntil({ !login_succes.visible() })
    }
}
