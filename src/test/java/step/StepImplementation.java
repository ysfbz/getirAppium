package step;

import com.thoughtworks.gauge.Step;
import methods.Methods;


public class StepImplementation {

    Methods methods;

    public StepImplementation()
    {
        methods = new Methods();
    }

    @Step({"<element> kontrol et",
            "<element> check element"})
    public void checkElement(String key) {
        methods.checkElementisDisplayed(key);
    }

    @Step({"<sec> sn. saniye bekle",
            "<sec> second wait"})
    public void waitSec(int second) {
        methods.waitSec(second);
    }

    @Step({"<element> butonuna tikla",
            "<element> click button"})
    public void clickToElement(String key) {
        methods.clickElement(key);
    }

    @Step("<element> alanini <input>'la doldur")
    public void clickToElement(String key, String text) {
        methods.sendKeys(key, text);
    }

    @Step("<input> a <inputValue> ara")
    public void sendKeys(String key, String text) {
        methods.sendKeys(key, text);
        methods.sendEnter(key);
    }

    @Step("<liste> icinde <urun> sec")
    public void clickList(String key, String name) {
        methods.clickList(key, name);
    }


    @Step({"Geri dön",
        "Go back"})
    public void goBack(){
        methods.goBack();
    }

    @Step({"<key> elementinin text değeri <expectedText> değerine eşit mi",
            "Is the text value of <key> element is equal to <expectedText>"})
    public void getElementText(String key, String expectedText) {
        methods.getElementText(key,expectedText);
    }
}