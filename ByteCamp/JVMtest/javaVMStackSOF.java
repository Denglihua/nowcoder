/**
 * @ Author:dlh
 * @ Date:2020/3/27--->16:47
 * @ Description:
 */
public class javaVMStackSOF {
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        javaVMStackSOF oom=new javaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack lenth:"+oom.stackLength);
            throw e;
        }
    }
}
