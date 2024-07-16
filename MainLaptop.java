/*
 * -Подумать над структурой класса Ноутбук для магазина техники
 *  - выделить поля и методы. Реализовать в java.
-Создать множество ноутбуков.
-Написать метод, который будет запрашивать у пользователя 
критерий (или критерии) фильтрации и
выведет ноутбуки, отвечающие фильтру. Критерии фильтрации 
можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию: 1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
-Далее нужно запросить минимальные значения для указанных 
критериев - сохранить параметры фильтрации
можно также в Map.
-Отфильтровать ноутбуки их первоначального множества и вывести 
проходящие по условиям.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainLaptop {
    public static void main(String[] args) {
        Laptop unit1 = new Laptop("Lenovo", "T430", 16, 512);
        Laptop unit2 = new Laptop("Aser", "Aspire 3", 8, 256);
        Laptop unit3 = new Laptop("Asus", "TUF F15", 16, 512);
        Laptop unit4 = new Laptop("Asus", "TUF F15", 16, 1024);
        Laptop unit5 = new Laptop("Lenovo", "Legion 5", 8, 256);
        Laptop unit6 = new Laptop("Asus", "ROG Strix", 32, 1000);
        Set <Laptop> laptops = new HashSet<>(Arrays.asList(unit1, unit2, unit3, unit4, unit5, unit6));
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
         
        
        
    }
    public static Map Filter (HashSet<Laptop> laptops){
        Map <Integer, Laptop> ld = new HashMap<Integer, Laptop>();
        int k = 0;  
        for (Laptop laptop : laptops) {
            ld.put(k, laptop);
            k++;
        }     
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Выберете критерий для сортировки:\n 1 Бренд \n 2 Модель \n 3 ОЗУ \n 4 Жесткий диск \n");
        String str = iScanner.nextLine(); 

        switch (str) {
            case "1":
                
                break;
        
            default:
                break;
        }
        iScanner.close();
        return ld;
    }

    }
