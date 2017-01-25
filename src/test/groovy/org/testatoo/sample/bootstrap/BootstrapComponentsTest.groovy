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
package org.testatoo.sample.bootstrap

import org.junit.BeforeClass
import org.junit.ClassRule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.testatoo.bundle.html5.Button
import org.testatoo.sample.WebDriverConfig
import org.testatoo.sample.bootstrap.component.Accordion
import org.testatoo.sample.bootstrap.component.ProgressBar
import org.testatoo.sample.bootstrap.component.TabPanel

import static org.testatoo.core.Testatoo.*

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@RunWith(JUnit4)
class BootstrapComponentsTest {
    @ClassRule
    public static WebDriverConfig driver = new WebDriverConfig()

    @BeforeClass
    static void setup() {
        visit 'http://localhost:8080/bootstrap/index.html'
    }

    @Test
    void test_progress_bar() {
        ProgressBar progress_bar = $('#progress_bar') as ProgressBar
        Button plus = $('#plus') as Button
        Button minus = $('#minus') as Button

        progress_bar.should { have value('60%') }

        clickOn plus
        clickOn plus
        progress_bar.should { have value('80%') }

        clickOn minus
        clickOn minus
        clickOn minus
        clickOn minus
        progress_bar.should { have value('40%') }
    }

    @Test
    void test_tab_panel() {
        TabPanel tab_panel = $('#myTab') as TabPanel

        tab_panel.should { have 2.tabs }
        tab_panel.tabs()[0].should { have title('Home') }
        tab_panel.tabs()[1].should { have title('Profile') }

        tab_panel.tabs()[0].panel.should { be visible }
        tab_panel.tabs()[1].panel.should { be hidden }

        clickOn tab_panel.tabs()[1]
        tab_panel.tabs()[1].panel.should { be visible }

        tab_panel.tabs()[0].should { be unselected }
        tab_panel.tabs()[1].should { be selected }

        clickOn tab_panel.tabs()[0]

        tab_panel.tabs()[0].should { be selected }
        tab_panel.tabs()[1].should { be unselected }
    }

    @Test
    void test_accordion() {
        Accordion accordion = $('#accordion') as Accordion
        accordion.should { have 3.items }

        accordion.items()[0].should { have title('Item 1') }
        accordion.items()[1].should { have title('Item 2') }
        accordion.items()[2].should { have title('Item 3') }

        accordion.items()[0].panel.should { be visible }
        accordion.items()[1].panel.should { be hidden }
        accordion.items()[2].panel.should { be hidden }

        accordion.items()[0].should { be selected }
        accordion.items()[1].should { be unselected }
        accordion.items()[2].should { be unselected }

        clickOn accordion.items()[1]
        accordion.items()[0].should { be unselected }
        accordion.items()[1].should { be selected }
        accordion.items()[2].should { be unselected }

        clickOn accordion.items()[2]
        accordion.items()[0].should { be unselected }
        accordion.items()[1].should { be unselected }
        accordion.items()[2].should { be selected }
    }
}