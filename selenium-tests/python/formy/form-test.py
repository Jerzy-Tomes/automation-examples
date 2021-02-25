from selenium import webdriver
import page
import unittest


class FormPageTest(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.formPage = page.FormPage(self.driver)
        self.thanksPage = page.ThanksPage(self.driver)

    def test_form(self):
        self.formPage.openPage()
        self.formPage.fillOutTheForm()

        text = self.thanksPage.getBannerText()
        assert text == self.thanksPage.SUCCESS_BANNER_STRING

    def tearDown(self):
        self.driver.close()


if __name__ == "__main__":
    unittest.main()
