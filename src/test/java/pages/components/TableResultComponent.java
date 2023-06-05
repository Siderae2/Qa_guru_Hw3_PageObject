package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {

    SelenideElement
            table = $(".table-responsive"),
            tile = $("#example-modal-sizes-title-lg");

    public void tableVerify(String key, String value) {
        table.$(byText(key)).parent().shouldHave(text(value));
    }
    public void titleVerify(String text){
        tile.shouldHave(text(text));
    }
}
