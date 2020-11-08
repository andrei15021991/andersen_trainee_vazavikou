package com.andersen_trainee.cache;

import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

public class MemoryCacheClass<KeyType, ValueType extends Serializable> implements ICaсhe<KeyType, ValueType>, IFrequencyCallObject<KeyType> {

    HashMap<KeyType, String> hashMap;
    TreeMap<KeyType, Integer> frequencyMap;


    public MemoryCacheClass() {
        hashMap = new HashMap<KeyType, String>();
        frequencyMap = new TreeMap<KeyType, Integer>();


        File tempFolder = new File("temp\\");
        if (!tempFolder.exists()) {
            tempFolder.mkdirs();
        }
    }

    @Override
    public void cache(KeyType key, ValueType value) throws IOException {
        String pathToObject;
        pathToObject = "temp\\" + UUID.randomUUID().toString() + ".temp";

        frequencyMap.put(key, 1);
        hashMap.put(key, pathToObject);


        FileOutputStream fileStream = new FileOutputStream(pathToObject);
        ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

        objectStream.writeObject(value);
        objectStream.flush();
        objectStream.close();
        fileStream.flush();
        fileStream.close();
    }


    @Override
    public ValueType getObject(KeyType key) throws IOException, ClassNotFoundException {
        if (hashMap.containsKey(key)) {

            String pathToObject = hashMap.get(key);


            try {
                FileInputStream fileStream = new FileInputStream(pathToObject);
                ObjectInputStream objectStream = new ObjectInputStream(fileStream);


                ValueType deserializedObject = (ValueType) objectStream.readObject();

                int frecquency = frequencyMap.remove(key);
                frequencyMap.put(key, ++frecquency);


                fileStream.close();
                objectStream.close();

                return deserializedObject;
            } catch (IOException ex) {
                return null;
            } catch (ClassNotFoundException ex) {
                return null;
            }
        }

        return null;
    }


    @Override
    public void deleteObject(KeyType key) {
        if (hashMap.containsKey(key)) {
            File deletingFile = new File(hashMap.remove(key));
            frequencyMap.remove(key);
            deletingFile.delete();
        }
    }


    @Override
    public void clearCache() {
        for (KeyType key : hashMap.keySet()) {
            File deletingFile = new File(hashMap.get(key));
            deletingFile.delete();
        }

        hashMap.clear();
        frequencyMap.clear();
    }


    @Override
    public ValueType removeObject(KeyType key) throws IOException, ClassNotFoundException {
        if (hashMap.containsKey(key)) {
            ValueType result = this.getObject(key);
            this.deleteObject(key);
            return result;
        }
        return null;
    }


    @Override
    public boolean containsKey(KeyType key) {
        return hashMap.containsKey(key);
    }


    @Override
    public int size() {
        return hashMap.size();
    }


    @Override
    public Set<KeyType> getMostFrequentlyUsedKeys() {
        ComparatorClass comparator = new ComparatorClass(frequencyMap);
        TreeMap<KeyType, Integer> sorted = new TreeMap(comparator);
        sorted.putAll(frequencyMap);
        return sorted.keySet();
    }


    @Override
    public int getFrequencyOfCallingObject(KeyType key) {
        if (hashMap.containsKey(key)) {
            return frequencyMap.get(key);
        }
        return 0;
    }
}
