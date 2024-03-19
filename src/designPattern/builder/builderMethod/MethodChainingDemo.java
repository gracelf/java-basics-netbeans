package designPattern.builder.builderMethod;

/**
 *
 */
public class MethodChainingDemo {

    
    public static void main(String args[])
    {
        StudentReceiver sr = new StudentReceiver();
        for(int i = 0; i<10; i++){
            //in 2 threads in studentReciever constructor, the state of student changes, not consistent
        System.out.println(sr.getStudent());}
    }

}
