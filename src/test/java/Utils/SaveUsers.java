package Utils;

import io.qameta.allure.internal.shadowed.jackson.core.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveUsers {
    public void userSave(String firstname, String lastname, String empid,String username, String password) throws IOException, ParseException {
        String fileLocation= "./src/test/resources/users.json";
        JSONParser parser = new JSONParser();
        JSONArray userArr = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject userobj = new JSONObject();
        userobj.put("firstname",firstname);
        userobj.put("lastname",lastname);
        userobj.put("employeeid",empid);
        userobj.put("username",username);
        userobj.put("password",password);

        userArr.add(userobj);

        FileWriter fileWriter = new FileWriter(fileLocation);
        fileWriter.write(userArr.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }
    public JSONArray getUser() throws IOException, ParseException {
        String fileLocation= "./src/test/resources/users.json";
        JSONParser parser = new JSONParser();
        JSONArray userArr = (JSONArray) parser.parse(new FileReader(fileLocation));
        return userArr;
    }
}
