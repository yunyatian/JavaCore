public class StaticTest {
    public static  void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("ajkdnk",23456);
        staff[1] = new Employee("fghygj",16895);
        staff[2] = new Employee("ahjg",25678);
        for (Employee e:staff) {
            e.setId();
            System.out.println("姓名："+e.getName()+" 薪资："+e.getSalary()+" 工号："+e.getId());
        }
        System.out.println("下一位员工工号为："+Employee.getNextId() );
    }
}
