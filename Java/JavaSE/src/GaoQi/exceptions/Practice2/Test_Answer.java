package GaoQi.Exceptions.Practice2;


public class Test_Answer {
    public static void main(String[] args) throws Exception {
                try {
                    // 检查参数个数
                    if (args.length != 2) {
                        throw new ArrayIndexOutOfBoundsException();
                    }

                    // 将字符串转换为整数
                    int dividend = Integer.parseInt(args[0]);
                    int divisor = Integer.parseInt(args[1]);

                    // 进行除法运算
                    System.out.println(dividend / divisor);

                } catch (NumberFormatException e) {
                    // 捕获数字格式异常
                    System.out.println("java.lang.NumberFormatException: " + e.getMessage());

                } catch (ArithmeticException e) {
                    // 捕获除零异常
                    System.out.println("java.lang.ArithmeticException: " + e.getMessage());

                } finally {
                    // 无论如何都会执行
                    System.out.println("总是被执行");
                }
    }
}

