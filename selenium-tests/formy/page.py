from selenium.webdriver.common.keys import Keys


class BasePage(object):
    """base class"""

    def __init__(self, driver):
        self.driver = driver


class FormPage(BasePage):
    """form page"""

    def openPage(self):
        self.driver.get("https://formy-project.herokuapp.com/form")

    def fillOutTheForm(self):
        # fill in the form
        firstName = self.driver.find_element_by_id("first-name")
        firstName.send_keys("Stefan")
        lastName = self.driver.find_element_by_id("last-name")
        lastName.send_keys("Słomnicki")
        jobTitle = self.driver.find_element_by_id("job-title")
        jobTitle.send_keys("Professor")
        # level of education radio btn
        self.driver.find_element_by_id("radio-button-3").click()
        # gender checkbox
        self.driver.find_element_by_id("checkbox-3").click()
        # experience
        self.driver.find_element_by_css_selector("option[value='3']").click()
        # date
        datepicker = self.driver.find_element_by_id("datepicker")
        datepicker.send_keys("02/03/2021")
        datepicker.send_keys(Keys.RETURN)

        # submit
        self.driver.find_element_by_css_selector(
            ".btn.btn-lg.btn-primary").click()


class ThanksPage(BasePage):
    """thanks page object"""
    SUCCESS_BANNER_STRING = "The form was successfully submitted!"

    def getBannerText(self):
        banner = self.driver.find_element_by_css_selector("[class*=alert]")
        return banner.text
