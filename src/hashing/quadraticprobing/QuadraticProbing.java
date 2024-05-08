package hashing.quadraticprobing;

import java.util.ArrayList;
import java.util.Collections;

public class QuadraticProbing {

    String[] hashTable;
    int usedCellCount;

    QuadraticProbing(int size) {
        hashTable = new String[size];
        usedCellCount = 0;
    }

    public int modAsciiHashFunction(String word,  int M) {
        char[] ch = word.toCharArray();
        int sum = 0;
        for( int i = 0; i< word.length(); i++) {
            sum = sum + ch[i];
        }
        return sum % M;
    }

    public double loadFactor() {
        return usedCellCount * 1.0/hashTable.length;
    }

    public void rehashKeys(String word) {
        usedCellCount = 0;
        ArrayList<String> data = new ArrayList<>();
        Collections.addAll(data,hashTable);
        data.add(word);
        hashTable = new String[hashTable.length * 2];
        for( String S : data) {
            insertKeyInHashTable(S);
        }
    }

    void insertKeyInHashTable(String word) {
        if(loadFactor() > 0.75) {
            rehashKeys(word);
        }
        else {
            int index = modAsciiHashFunction(word, hashTable.length);
            int counter = 0 ;
            for( int i = index ; i < index +  hashTable.length; i++) {
                int newIndex = (index + (counter*counter)) % hashTable.length;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    System.out.println(word + " has been inserted successfully");
                    break;
                } else {
                    System.out.println(newIndex + " is already occupied. Trying next one...");
                }
                counter++;
            }
        }
        usedCellCount++;
    }

    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("\nHashTable does not exits !");
            return;
        } else {
            System.out.println("\n---------- HashTable ---------");
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index:" + i + ".   Key:" + hashTable[i]);
            }
        }
        System.out.println("\n");
    }
}
