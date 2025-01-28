package com.github.romariog.mavendemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


@DisplayName("Unit-level testing for ImageComparator")
class ImageComparatorTest {

    @Test
    void isTheNotSameImages() throws Exception {
        int numberFromImage1 = readNumberFromFile("/image1.txt");
        int numberFromImage2 = readNumberFromFile("/image2.txt");

        Assertions.assertNotEquals(numberFromImage1, numberFromImage2);
    }

    @Test
    void isTheSameImages() throws Exception {
        int numberFromImage1 = readNumberFromFile("/image1.txt");
        Assertions.assertEquals(numberFromImage1, numberFromImage1);
    }

    // Method to read the number from a given file
    public static int readNumberFromFile(String filePath) throws Exception {
        try (InputStream inputStream = ImageComparatorTest.class.getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();  // Read the first line
            return Integer.parseInt(line);  // Parse the number
        }
    }
}