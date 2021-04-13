package view;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class StringTextField extends TextField {
    String defaultPromptText;
    public StringTextField(String prompt){
        defaultPromptText=prompt;
        setPromptText(defaultPromptText);
    }
}
