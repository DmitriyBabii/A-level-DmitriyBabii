package com.alevel.hw18;

import java.io.File;

class Main {
    public static void main(String[] args) {
        File file = new File("D:\\Обои", "File.txt");
        try {
            file.createNewFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            file.delete();
        }
    }
}
