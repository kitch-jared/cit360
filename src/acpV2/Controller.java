package acpV2;

import java.util.HashMap;

public class Controller {
	
	HashMap<String,Handler> operationMap = new HashMap<String,Handler>();

    public void handleRequest(String option){
        Handler myOption = operationMap.get(option);
        if (myOption != null){
        	myOption.handleIt();
        }
    }

    public void mapOption(String newOption, Handler newHandler){
        operationMap.put(newOption, newHandler);
    }
}
