package com.test.makemytrip.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static ConfigLoader config;
    private Properties properties;
    private final String propertyFilePath=".\\config.properties";


    private ConfigLoader(){
        BufferedReader reader;
        try{

            reader=new BufferedReader(new FileReader(propertyFilePath));
            properties=new Properties();
            try{
            properties.load(reader);
            reader.close();

            }

            catch (IOException e){
                e.printStackTrace();
            }

        }

        catch (FileNotFoundException e){
           e.printStackTrace();
           throw new RuntimeException("Config.properties not found at loaction"+propertyFilePath);
        }
    }

    public static ConfigLoader getInstance(){
        if(config==null){
            return new ConfigLoader();
        }
        else{
            return  config;
        }

    }

    public String  getPropertyValue(String key){

        String property_Value=properties.getProperty(key);
        if(property_Value!=null){
            return property_Value;
        }
        else{
            throw new RuntimeException("value is null for key");
        }

    }









}
