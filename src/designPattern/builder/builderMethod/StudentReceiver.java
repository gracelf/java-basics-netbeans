package designPattern.builder.builderMethod;

/**
 *
 */
public class StudentReceiver {

    private final Student student = new Student();
    
    // constructor, set student state in this constructor
    public StudentReceiver() {
        student.setAddress("Rockville").setId(0).setName("Eric");
        System.out.println(student);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                student.setId(1).setName("Ram").setAddress("Noida");
                System.out.println("thread 1: " + student);
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                student.setId(2).setName("Shyam").setAddress("Delhi");
                System.out.println("Thread 2: "+student);
            }
        });

        t2.start();

    }

    public Student getStudent() {
        return student;
    }

}
