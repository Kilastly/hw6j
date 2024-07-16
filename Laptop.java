import java.util.Objects;

public class Laptop {
    private String brand;
    private String model;
    private int ramСapacity;
    private int hddСapacity;
    public Laptop (String brand, String model, int ramСapacity, int hddСapacity){
        this.brand = brand;
        this.model = model;
        this.ramСapacity = ramСapacity;
        this.hddСapacity = hddСapacity;
    }

    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public int getRamCapacity(){
        return ramСapacity;
    }
    public int getHddCapacity(){
        return hddСapacity;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setRamCapacity(short ramСapacity){
        this.ramСapacity = ramСapacity;
    }
    public void setHddCapacity(short hddСapacity){
        this.hddСapacity = hddСapacity;
    }

    @Override
    public String toString() {
        return "Производитель: " + brand + "\n" +
               "Модель: " + model + "\n" +
               "Объем ОЗУ: " + ramСapacity + "ГБ" + "\n" +
               "Жесткий диск: " + hddСapacity + "ГБ" + "\n";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass()!= obj.getClass()) return false;
        Laptop laptop = (Laptop) obj;
        return brand.equals(laptop.brand) &&
               model == laptop.model &&
               ramСapacity == laptop.ramСapacity &&
               hddСapacity == laptop.hddСapacity;
    }
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, ramСapacity, hddСapacity);
        
    }
}
