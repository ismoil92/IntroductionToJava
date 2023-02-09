public class Notebook {
    private int id;
    private String name;
    private int ram;
    private int hardware;
    private String operationSystem;
    private String color;

    public  Notebook(){

    }

    public Notebook(int id, String name, int ram, int hardware, String operationSystem, String color){
        this.id = id;
        this.name = name;
        this.ram = ram;
        this.hardware = hardware;
        this.operationSystem = operationSystem;
        this.color = color;
    }

    public int getRam(){
        return ram;
    }

    public int getHardware(){
        return hardware;
    }

    public String getOperationSystem(){
        return operationSystem;
    }

    public String getColor(){
        return color;
    }
    @Override
    public boolean equals(Object obj) {
        Notebook note = (Notebook) obj;
        return this.id == note.id;
    }

    @Override
    public String toString() {

        return String.format("ID:%d, Name:%s, RAM:%d, Hardware:%d," +
                " Operation System:%s, Color:%s", id, name, ram, hardware, operationSystem, color);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
