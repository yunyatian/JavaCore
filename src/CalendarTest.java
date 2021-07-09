import java.time.DayOfWeek;
import java.time.LocalDate;
//编写当月的日历
public class CalendarTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        //LocalDate date = LocalDate.of(2021,2,23);
        int month = date.getMonthValue();//获取当前月份
        int today = date.getDayOfMonth();//获取当前日期
        date = date.minusDays(today-1);//回到本月第一天,方法是将当前日期向前推today-1天
        DayOfWeek week = date.getDayOfWeek();//获取当前周几
        int value = week.getValue();//将周几转化为数字
        System.out.println("          "+date.getYear()+"年"+date.getMonthValue()+"月          ");
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        if(value==7){
            System.out.print("");
        }else {
            for (int i = 1;i < value+1;i++){
                System.out.print("    ");
            }
        }
        while(date.getMonthValue()==month){
            System.out.format("%3d",date.getDayOfMonth());//java8以后的格式化输出方式
            if(date.getDayOfMonth()==today){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }
            if (date.getDayOfWeek().getValue()==6){
                System.out.println();
            }
            date=date.plusDays(1);//将日期向前走一天
        }
        /*if(date.getDayOfWeek().getValue()!=1){
            System.out.println();
        }*/
    }
}
