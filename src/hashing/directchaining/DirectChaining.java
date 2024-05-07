package hashing.directchaining;

import java.util.LinkedList;

public class DirectChaining {

    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    DirectChaining(int size ) {
        hashTable = new LinkedList[size];
    }
    public int modAsciiHashFunction(String word,  int M) {
        char[] ch =  word.toCharArray();
        int sum  = 0;
        for( int i  = 0;  i<  word.length(); i++) {
            sum  =  sum  + ch[i];
        }
        return sum % M;
    }

    public void insertHashTable(String word) {
        int newIndex = modAsciiHashFunction(word, hashTable.length);
        if(hashTable[newIndex] == null) {
            hashTable[newIndex] = new LinkedList<>();
            hashTable[newIndex].add(word);
        }
        else {
            hashTable[newIndex].add(word);
        }
    }

    public void displayHashTable() {
        if(hashTable == null) {
            System.out.println("Hash Table doesn't exist\n");
            return;
        }
        System.out.println("\n----------HashTable----------");
        for( int i = 0 ; i< hashTable.length ; i++) {
            System.out.println("Index: "+ i + " key: "+ hashTable[i]);
        }
    }

    public boolean searchInHashtable(String word) {
        int newIndex  =  modAsciiHashFunction(word,  hashTable.length);
        if( hashTable[newIndex] != null && hashTable[newIndex].contains(word)) {
            System.out.println("\n" + "\"" + word + "\"" + " found in Hashtable at location: " +newIndex);
            return true;
        }
        else {
            System.out.println("\n" + "\"" + word + "\"" + " not found in HashTable");
            return false;
        }
    }

    public void deleteKeyHashTable(String word) {
        int newIndex  =  modAsciiHashFunction(word, hashTable.length);
        boolean result =  searchInHashtable(word);
        if (result) {
            hashTable[newIndex].remove(word);
            System.out.println("\n" + "\"" + word + "\"" + " has been deleted from HashTable ");
        }
    }
}
