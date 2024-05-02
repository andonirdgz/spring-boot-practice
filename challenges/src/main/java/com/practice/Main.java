package com.practice;

public class Main {
    public static void main(String[] args) {
        // Input: code line to check
        String codeLine = "3^2"; // This should be dynamic based on actual input

        // Initialize JSON object string
        String jsonOutput = "{ \"correctness\": \"%s\", \"edgeCases\": \"%s\", \"formatInstructions\": \"%s\"}";

        // Checks
        String correctness = "No";
        String edgeCases = "No";
        String formatInstructions = "No";

        // Check if the format instructions are followed
        if (codeLine.matches("\\d+\\*\\*\\d+")) {
            formatInstructions = "Yes";

            // Parsing the base and exponent values
            String[] parts = codeLine.split("\\*\\*");
            int base = Integer.parseInt(parts[0]);
            int exponent = Integer.parseInt(parts[1]);

            // Calculating the power
            int result = (int) Math.pow(base, exponent);

            // Correctness check
            if (result == 9) {
                correctness = "Yes";
            }
        }

        // Edge Cases check for the use of '^'
        if (codeLine.contains("^")) {
            edgeCases = "Yes";
        }

        // Formatting the JSON output
        jsonOutput = String.format(jsonOutput, correctness, edgeCases, formatInstructions);
        System.out.println(jsonOutput);
    }
}