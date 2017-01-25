package org.testatoo.sample.angularjs

import org.junit.ClassRule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.testatoo.sample.WebDriverConfig
import org.testatoo.sample.angularjs.component.NavigationMenu

import static org.testatoo.core.Testatoo.*

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
@RunWith(JUnit4)
class AngularJSTest {
    @ClassRule
    public static WebDriverConfig driver = new WebDriverConfig()

    @Test
    void test_navigation_menu() {
        visit 'http://localhost:8080/angularjs/index.html'

        NavigationMenu navigationMenu = $('#menu') as NavigationMenu

        navigationMenu.should {
            be visible
            have 4.items
        }

        navigationMenu.items()[0].should { have title('Home') }
        navigationMenu.items()[1].should { have title('Projects') }
        navigationMenu.items()[2].should { have title('Services') }
        navigationMenu.items()[3].should { have title('Contact') }

        navigationMenu.items()[0].should { be unselected }
        navigationMenu.items()[1].should { be unselected }
        navigationMenu.items()[2].should { be unselected }
        navigationMenu.items()[3].should { be unselected }

        clickOn navigationMenu.item('Projects')
        navigationMenu.items()[0].should { be unselected }
        navigationMenu.items()[1].should { be selected }
        navigationMenu.items()[2].should { be unselected }
        navigationMenu.items()[3].should { be unselected }

        clickOn navigationMenu.items()[3]
        navigationMenu.items()[0].should { be unselected }
        navigationMenu.items()[1].should { be unselected }
        navigationMenu.items()[2].should { be unselected }
        navigationMenu.items()[3].should { be selected }

        navigationMenu.select('Services')
        navigationMenu.items()[0].should { be unselected }
        navigationMenu.items()[1].should { be unselected }
        navigationMenu.items()[2].should { be selected }
        navigationMenu.items()[3].should { be unselected }
    }
}
