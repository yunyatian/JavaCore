public class Employee {
    private static int nextId = 1;
    private String name;
    private int salary;
    private int id;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = nextId;
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("yuan",100000);
        System.out.println("姓名："+employee.getName()+"薪资："+employee.getSalary());
    }
}
