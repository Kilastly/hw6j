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
import java.util.List;
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
         
           Map <Integer, Map<String, String>> temp = CollectCriterias();
  
        for (Map <String, String> elem : temp.values()) {
            if (elem.get("brand") != null){ 
               String laptopBrand = elem.get("brand");
               List<Laptop> brandLaptops = Laptop.searchByBrand(laptops, laptopBrand);
               for (Laptop laptop : brandLaptops) {
                    System.out.println(laptop);
                }            
            }
            else if (elem.get("model") != null){
                String laptopModel = elem.get("model");
                List<Laptop> modelLaptops = Laptop.searchByModel(laptops, laptopModel);
                for (Laptop laptop : modelLaptops) {
                    System.out.println(laptop);
                }
            }
            else if (elem.get("ramСapacity") != null){
                int laptopRam = Integer.parseInt(elem.get("ramСapacity"));
                List<Laptop> ramLaptops = Laptop.searchByRamCapacity(laptops, laptopRam);
                for (Laptop laptop : ramLaptops) {
                    System.out.println(laptop);
                }
            }
            else if (elem.get("hddСapacity") != null){
                int laptopHdd = Integer.parseInt(elem.get("hddСapacity"));
                List<Laptop> hddLaptops = Laptop.searchByHddCapacity(laptops, laptopHdd);
                for (Laptop laptop : hddLaptops) {
                    System.out.println(laptop);
                }
            }
        }
        
    }

    
    public static Map <String, String> ChoiceCriteria (){
        Map <String, String> criteria = new HashMap<>();     
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Выберете критерий для сортировки:\n 1 Бренд \n 2 Модель \n 3 ОЗУ \n 4 Жесткий диск \n 0 Выход \n");
        String str = iScanner.nextLine();
        switch (str) {
            case "0":
                break;
            case "1":{
                System.out.printf("Введите бренд (или нажмите Enter для отмемы): \n");
                String brand = iScanner.nextLine();
                if (!brand.isEmpty()) {
                    criteria.put("brand", brand);
                    break;                   
                }
                else break;
            }
            case "2":{
                    System.out.printf("Введите модель (или нажмите Enter для отмемы): \n");
                    String model = iScanner.nextLine();
                    if (!model.isEmpty()) {
                        criteria.put("model", model);
                        break; 
                    }
                    else break;
            }
            case "3":{
                    System.out.printf("Введите минимальное количество ОЗУ (или нажмите Enter для отмемы): \n");
                    String ramСapacity = iScanner.nextLine();
                    if (!ramСapacity.isEmpty()) {
                        try {
                            Integer.parseInt(ramСapacity);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Неверный формат количества ОЗУ: " + ramСapacity);
                            break;
                        }
                        criteria.put("ramСapacity", ramСapacity);
                        break;
                    }
                    else break;
            }
            case "4":{
                    System.out.printf("Введите минимальный размер жесткого диска (или нажмите Enter для отмемы): \n");
                    String hddСapacity = iScanner.nextLine();
                    if (!hddСapacity.isEmpty()) {
                        try {
                            Integer.parseInt(hddСapacity);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Неверный формат размера жесткого диска: " + hddСapacity);
                            break;
                        }
                        criteria.put("hddСapacity", hddСapacity);
                        break; 
                    }
                    else break;
            }
        default:
            System.out.println("Неверный ввод!");
            break;    
        }
         return criteria;
    }

    public static Map <Integer, Map<String, String>> CollectCriterias(){
        Map <Integer, Map <String, String>> criteriasCollection = new HashMap<>();
        int position = 0;
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Выбрать критерии для поиска? 1 Да 0 Выход: \n");
        String answer = iScanner.nextLine();
        try {
            Integer.parseInt(answer);
        }
        catch (NumberFormatException e) {
            System.out.println("Неверный ввод!");
            iScanner.close();
            return criteriasCollection;
        }
        switch (answer) {
            case "0":
                break;
            case "1":
                criteriasCollection.put(++position, ChoiceCriteria());
                System.out.printf("Добавить еще один критерий? 1 Да, (или нажмите Enter для отмемы)\n");
                String str = iScanner.nextLine();
                if (!str.isEmpty() && str.equals("1")){
                    criteriasCollection.put(++position, ChoiceCriteria());
                    break;
                }
                else if (!str.isEmpty()){
                    System.out.println("Неверный ввод!");
                    iScanner.close();
                    return criteriasCollection;
                }
                else if (str.isEmpty()){
                    iScanner.close();
                    return criteriasCollection;
                } break;
        }
        iScanner.close();
        return criteriasCollection;
    }

    }

