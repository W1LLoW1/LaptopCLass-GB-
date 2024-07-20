package org.example.hw6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = laptopList();
        Map<Integer, Object> criteria = getFilterCriteria();
        Set<Laptop> filteredLaptops = filterLaptops(laptops, criteria);

        System.out.println("Отфильтрованный список:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }

    private static Set<Laptop> laptopList() {
        Laptop lap1 = new Laptop();
        lap1.brand = "ASUS";
        lap1.color = "black";
        lap1.cpu = "Intel Core i5";
        lap1.ram = 16;
        lap1.rom = 512;
        lap1.os = "Windows 11";

        Laptop lap2 = new Laptop();
        lap2.brand = "MSI";
        lap2.color = "red";
        lap2.cpu = "Intel Core i7";
        lap2.ram = 32;
        lap2.rom = 1024;
        lap2.os = "Windows 11";

        Laptop lap3 = new Laptop();
        lap3.brand = "HUAWEI";
        lap3.color = "Dark Blue";
        lap3.cpu = "Intel Core i3";
        lap3.ram = 8;
        lap3.rom = 256;
        lap3.os = "Windows 10";

        Laptop lap4 = new Laptop();
        lap4.brand = "Apple";
        lap4.color = "Gray";
        lap4.cpu = "Apple M1";
        lap4.ram = 16;
        lap4.rom = 512;
        lap4.os = "OS X";

        Laptop lap5 = new Laptop();
        lap5.brand = "ASUS";
        lap5.color = "Cyan";
        lap5.cpu = "Intel Core i5";
        lap5.ram = 32;
        lap5.rom = 512;
        lap5.os = "Windows 11";

        Laptop lap6 = new Laptop();
        lap6.brand = "Acer";
        lap6.color = "black";
        lap6.cpu = "Intel Core i7";
        lap6.ram = 16;
        lap6.rom = 512;
        lap6.os = "Windows 11";

        Laptop lap7 = new Laptop();
        lap7.brand = "HP";
        lap7.color = "Gray";
        lap7.cpu = "Intel Core i5";
        lap7.ram = 8;
        lap7.rom = 512;
        lap7.os = "Windows 10";

        Laptop lap8 = new Laptop();
        lap8.brand = "Xiaomi";
        lap8.color = "white";
        lap8.cpu = "Intel Core i3";
        lap8.ram = 8;
        lap8.rom = 128;
        lap8.os = "Windows 10";

        Laptop lap9 = new Laptop();
        lap9.brand = "MSI";
        lap9.color = "black";
        lap9.cpu = "Intel Core i7";
        lap9.ram = 64;
        lap9.rom = 2048;
        lap9.os = "Windows 11";

        Laptop lap10 = new Laptop();
        lap10.brand = "HUAWEI";
        lap10.color = "blue";
        lap10.cpu = "Intel Core i5";
        lap10.ram = 16;
        lap10.rom = 256;
        lap10.os = "Windows 11";
        return new HashSet<>(Arrays.asList(lap1, lap2, lap3, lap4, lap5, lap6, lap7, lap8, lap9, lap10));
    }

    private static Map<Integer, Object> getFilterCriteria() {
        Map<Integer, Object> criteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажите критерий по номеру:");
        System.out.println("1: Производитель");
        System.out.println("2: Операционная система");
        System.out.println("3: Оперативная память");
        System.out.println("4: Процессор");
        System.out.println("5: Объем накопителя");

        String choice = scanner.nextLine();
        if (choice.contains("1")) {
            System.out.println("Введите имя производителя: ");
            criteria.put(1, scanner.nextLine());
        }
        if (choice.contains("2")) {
            System.out.println("Введите ОС:");
            criteria.put(2, scanner.nextLine());
        }
        if (choice.contains("3")) {
            System.out.println("Введите кол-во ОЗУ: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Пожалуйста, введите числовое значение для ОЗУ:");
                scanner.next();
            }
            criteria.put(3, scanner.nextInt());
            scanner.nextLine();
        }
        if (choice.contains("4")) {
            System.out.println("Укажите процессор");
            criteria.put(4, scanner.nextLine());
        }
        if (choice.contains("5")) {
            System.out.println("Введите объем накопителя: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Пожалуйста, введите числовое значение для объема накопителя:");
                scanner.next();
            }
            criteria.put(5, scanner.nextInt());
            scanner.nextLine();
        }
        System.out.println(String.format("Выбранные критерии: " + criteria));
        return criteria;
    }

    private static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<Integer, Object> criteria) {
        Set<Laptop> filteredLaptops = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean match = true;

            if (criteria.containsKey(1) && !laptop.brand.equalsIgnoreCase((String) criteria.get(1))) {
                match = false;
            }
            if (criteria.containsKey(2) && !laptop.os.equalsIgnoreCase((String) criteria.get(2))) {
                match = false;
            }
            if (criteria.containsKey(3) && laptop.ram < (int) criteria.get(3)) {
                match = false;
            }
            if (criteria.containsKey(4) && !laptop.cpu.equalsIgnoreCase((String) criteria.get(4))) {
                match = false;
            }
            if (criteria.containsKey(5) && laptop.rom < (int) criteria.get(5)) {
                match = false;
            }

            if (match) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }
}
