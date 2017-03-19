package com.github.vlshat.epam.unit07.task02;

import com.github.vlshat.epam.unit07.task02.exceptions.KeyNotFoundException;
import com.github.vlshat.epam.unit07.task02.exceptions.PropertyFileNotFoundException;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.PropertyResourceBundle;

/**
 * Created by vladislav on 20.03.17.
 */
public class PropertyManager {
    private Map<String, String> propertyMap;


    /**
     * Returns list of *.property files in resources directory.
     * @return
     */
    public String getResourceList() {
        File file = new File("src/main/resources");

        String[] files = file.list();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < files.length; i++){
            if (files[i].contains(".properties")){
                result.append(files[i]);
                result.append("\n");
            }
        }

        if (result.length() > 0){
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    /**
     * Loads property file with a given name.
     * @param name
     * @throws PropertyFileNotFoundException
     */
    public void loadResource(String name) throws PropertyFileNotFoundException {

        File file = new File("src/main/resources/" + name + ".properties");

        if (!file.exists()){
            throw new PropertyFileNotFoundException("File not found");
        }

        PropertyResourceBundle currentResource = (PropertyResourceBundle) PropertyResourceBundle.getBundle(name);

        Enumeration<String> stringEnumeration = currentResource.getKeys();
        propertyMap = new HashMap<>();

        while (stringEnumeration.hasMoreElements()){
            String key = stringEnumeration.nextElement();
            propertyMap.put(key, currentResource.getString(key));
        }
    }

    /**
     * Returns string associated with this key.
     * @param key
     * @return
     * @throws KeyNotFoundException
     * @throws PropertyFileNotFoundException
     */
    public String getValue(String key) throws KeyNotFoundException, PropertyFileNotFoundException {

        if (propertyMap == null)
            throw new PropertyFileNotFoundException("No property file");

        if (!propertyMap.containsKey(key))
            throw new KeyNotFoundException("Key " + key + " not found");

        return propertyMap.get(key);
    }

    public static void main(String[] args) throws PropertyFileNotFoundException, KeyNotFoundException {
        PropertyManager propertyReader = new PropertyManager();
        System.out.println(propertyReader.getResourceList());
        propertyReader.loadResource("question_en");
    }
}
