package org.testatoo.sample

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.DefaultHandler
import org.eclipse.jetty.server.handler.HandlerList
import org.eclipse.jetty.server.handler.ResourceHandler
import org.junit.rules.ExternalResource
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.safari.SafariDriver
import org.testatoo.evaluator.webdriver.WebDriverEvaluator

import static org.testatoo.core.Testatoo.config

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class WebDriverConfig extends ExternalResource {
    public static String BASE_URL
    private static Server server

    @Override
    protected void before() throws Throwable {
        // Defined in the maven profile
        final String browser = System.getProperty('browser') ?: 'Chrome' // defined in the maven profile

        // Defined by JVM maven arguments
        final String drivers = System.getProperty('drivers') ?: '/usr/bin/'
        final boolean docker = Boolean.valueOf(System.getProperty('docker')) ?: false // -Ddocker=true
        final String ip = System.getProperty('ip') ?: '127.0.0.1' // -DIP=xxx.xxx.xxx.xxx

        BASE_URL = 'http://' + ip + ':8080/'

        startJetty()

        switch (browser) {
            case 'Firefox':
                println '================== Firefox Profile ==================='
                if (docker) {
                    WebDriver driver = new RemoteWebDriver(new URL('http://localhost:4444/wd/hub'), DesiredCapabilities.firefox())
                    config.evaluator = new WebDriverEvaluator(driver)
                } else {
                    System.setProperty('webdriver.gecko.driver', drivers + 'geckodriver')
                    DesiredCapabilities capabilities = DesiredCapabilities.firefox()
                    capabilities.setCapability('marionette', true)
                    config.evaluator = new WebDriverEvaluator(new FirefoxDriver(capabilities))
                }
                break
            case 'Chrome':
                println '=================== Chrome Profile ==================='
                if (docker) {
                    WebDriver driver = new RemoteWebDriver(new URL('http://localhost:4444/wd/hub'), DesiredCapabilities.chrome())
                    config.evaluator = new WebDriverEvaluator(driver)
                } else {
                    System.setProperty('webdriver.chrome.driver', drivers + 'chromedriver')
                    config.evaluator = new WebDriverEvaluator(new ChromeDriver())
                }
                break
            case 'Safari ':
                println '=================== Safari Profile ==================='
                System.setProperty('webdriver.safari.driver', '/usr/bin/safaridriver')
                config.evaluator = new WebDriverEvaluator(new SafariDriver())
                break
            case 'Edge':
                println '==================== Edge Profile ===================='
                System.setProperty('webdriver.edge.driver', 'C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe')
                config.evaluator = new WebDriverEvaluator(new EdgeDriver())
                break
        }
    }

    @Override
    protected void after() {
        config.evaluator.close()
        server.stop()
    }

    private static void startJetty() {
        server = new Server(8080)
        ResourceHandler resource_handler = new ResourceHandler()

        resource_handler.directoriesListed = true
        resource_handler.welcomeFiles = ['index.html']
        resource_handler.resourceBase = 'src/main/webapp'

        HandlerList handlers = new HandlerList()
        handlers.handlers = [resource_handler, new DefaultHandler()]
        server.handler = handlers

        server.start()
    }
}