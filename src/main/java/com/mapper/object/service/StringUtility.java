package com.mapper.object.service;

public class StringUtility {


    private StringUtility() {

    }

    public static String addAfterSequence(String parent, String sequence, String strToAdd) {
        // Initialize a StringBuilder to build the modified string
        StringBuilder modified = new StringBuilder();


        // Find the next occurrence of the sequence string
        int index = parent.indexOf(sequence);
        while (index != -1) {
            // Append the part of the parent string before the sequence string
            modified.append(parent, 0, index + sequence.length());
            // Append the string to add
            modified.append(strToAdd);
            // Update the parent string to start from the end of the sequence string
            parent = parent.substring(index + sequence.length());
            // Find the next occurrence of the sequence string
            index = parent.indexOf(sequence);
        }

        // Append the remainder of the parent string
        modified.append(parent);

        // Return the modified string
        return modified.toString();
    }


    public static String addToStartAndEnd(String parent, String strToAddStart, String strToAddEnd) {
        // Initialize a StringBuilder to build the modified string
        StringBuilder modified = new StringBuilder();
        // Add the string to add at the start
        modified.append(strToAddStart);
        // Add the parent string
        modified.append(parent);
        // Add the string to add at the end
        modified.append(strToAddEnd);
        // Return the modified string
        return modified.toString();
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
