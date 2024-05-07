package hashing.linearprobing;

import java.util.ArrayList;
import java.util.Collections;

public class LinearProbing {
    String[] hashTable;
    int usedCellCount;

    LinearProbing(int size) {
        hashTable = new String[size];
        usedCellCount = 0;
    }

    public int modAsciiHashFunction(String word, int M) {
        char[] ch  = word.toCharArray();
        int sum = 0;
        for( int i = 0 ;i < word.length(); i++) {
            sum  =  sum + ch[i];
        }
        return  sum % M;
    }

    public double getLoadFactor() {
        return usedCellCount * 1.0/hashTable.length;
    }

    public void insertInHashTable(String word) {
        if(getLoadFactor() > 0.75) {
            rehashKeys(word);
        }
        else {
            int newIndex = modAsciiHashFunction(word, hashTable.length);
            for( int i = newIndex; i < hashTable.length ; i++) {
                if(hashTable[i] ==  null) {
                    hashTable[i] =  word;
                    break;
                }
                else {
                    System.out.println(newIndex+" is already occupied . Trying next empty cell");
                }
            }
        }
        usedCellCount++;
    }

    private void rehashKeys(String word) {
        usedCellCount = 0;
        ArrayList<String > data = new ArrayList<>();
        Collections.addAll(data, hashTable);
        data.add(word);
        hashTable = new String[hashTable.length * 2];
        for (String s : data) {
            insertInHashTable(s);
        }
    }

    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("\nHashTable does not exists");
            return;
        } else {
            System.out.println("\n----------HashTable----------");
            for (int i=0; i<hashTable.length; i++) {
                System.out.println("Index " + i + ", key:" + hashTable[i]);
            }
        }
    }

    public boolean searchHashTable(String word) {
        int index = modAsciiHashFunction(word, hashTable.length);
        for (int i = index; i < index+hashTable.length; i++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                System.out.println(word +" found at location: "+ newIndex);
                return true;
            }
        }
        System.out.println(word +" not found in hasbTable");
        return false;
    }

    public void deleteKeyHashTable(String word) {
        int index = modAsciiHashFunction(word, hashTable.length);
        for (int i = index; i<index+hashTable.length; i++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                hashTable[newIndex] = null;
                System.out.println(word +" has been deleted from HashTable");
                return;
            }
        }
        System.out.println(word +" not found in HashTable");
    }
}
