package view;


import javafx.scene.control.TextField;

public class IntTextField extends TextField {
    String defaultPromptText;
    public IntTextField(String prompt){
        defaultPromptText=prompt;
        setPromptText(defaultPromptText);
    }


    public boolean tryParse(){
        boolean exceptionCaught=false;
        try {
            Integer.parseInt(getText());
        }
        catch (Exception e){
            exceptionCaught=true;
        }
        if (exceptionCaught){
            setText("");
            setPromptText("введите целое число!");
        }
        else{
            setPromptText(defaultPromptText);
        }
        return !exceptionCaught;
    }
}
