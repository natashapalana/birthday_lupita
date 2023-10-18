package com.lupita;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//import org.json.simple.JSONArray;
public class bb {

    // this is a private and static hashmap to store the birthdays
    private static HashMap<String, String> birthdayMap = new HashMap<String, String>();

    // this code reads a the json file
    // students do not have to change this function
    public static JSONArray readJSONArrayFile(String fileName) throws ParseException {
        // JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        JSONArray birthdayArr = null;

        // Read JSON file
        try (FileReader reader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(reader);

            birthdayArr = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return birthdayArr;
    }

    // students do not have to change this function
    public static void initializeMap(final String pathToFile) throws ParseException {
        JSONArray jsonData = readJSONArrayFile(pathToFile);

        // loop over list
        String birthday, name;
        JSONObject obj;
        for (Integer i = 0; i < jsonData.size(); i++) {
            // parse the object and pull out the name and birthday
            obj = (JSONObject) jsonData.get(i);
            birthday = (String) obj.get("birthday");
            name = (String) obj.get("name");

            // add the name and birthday in to a hashmap
            birthdayMap.put(name, birthday);

            // print the names and birthdays
            System.out.println("name = " + name);
            System.out.println("birthday = " + birthday);
        }
    }

    public static void main(final String[] args) throws ParseException {
        /*
         * students will need to change the path below to work on THEIR laptop. this is
         * currently the path for my laptop.
         * if students do not know or understand what a "path" is, students should first
         * complete the
         * extra credit module on Files, Directories, and Folders in Canvas.
         */

        String pathToFile = "/Users/natasha/Documents/birthday/birthday_lupita/birthday.json";

        // students should change the code below in order to implment their own solution

        // initialize the hash map
        initializeMap(pathToFile);
        // System.out.println(birthdayMap);

        // read user input from keyboard
        System.out.println("Reading user input into a string");

        // get user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = input.nextLine();

        String birthday = birthdayMap.get(name);

        if (birthday != null) {
            System.out.println("Enter the name: " + name + " "+ "Birthday: " + birthday);

        } else {
            System.out.println("The name is unknown");

        }

        
        System.out.println("Enter the partial name: ");
        String name2 = input.nextLine();
        

        for (Map.Entry<String, String> entry : birthdayMap.entrySet() ) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.toLowerCase().contains(name2.toLowerCase())) {
            
            //for (String value : birthdayMap.values()){
                System.out.println("Enter the partial name: " + key +  ", " + "Birthday: "+ value);

            }

            


            //for (String key : birthdayMap.keySet()){
               // System.out.println("Enter the partial name: " + key +  "b-day: " );

            
            

           

        }
        
        
        


         input.close();

        

        // print user input
        // System.out.println("name = " + name);

    
    


}        

    

    // close the scanner

}