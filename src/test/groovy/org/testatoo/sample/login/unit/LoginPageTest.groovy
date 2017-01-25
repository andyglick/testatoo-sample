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
package org.testatoo.sample.login.unit

import org.junit.BeforeClass
import org.junit.ClassRule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.testatoo.sample.WebDriverConfig

import static org.testatoo.core.Testatoo.*
import static org.testatoo.sample.login.Factory.*

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@RunWith(JUnit4)
class LoginPageTest {
    @ClassRule
    public static WebDriverConfig driver = new WebDriverConfig()

    @BeforeClass
    static void setup() {
        visit 'http://localhost:8080/login/index.html'
    }

    @Test
    void page_contains_expected_elements() {
        login_panel.should {
            be visible
            have(title('Login Form'))
        }

        login_panel.should {
            contain(
                    email_field,
                    password_field,
                    login_button
            )
        }

        email_field.should {
            be visible
            have placeholder('joe@blow.org')
            have label('Email')
        }

        password_field.should {
            be visible
            have label('Password')
        }

        login_button.should {
            be visible
            have(text('Login'))
        }
    }
}
