

package designPattern.builder.builderMethod;

/**
 *
 */
public class StudentReceiverBuilder {

// volatile student instance to ensure visibility
    // of shared reference to immutable objects
    private volatile StudentBuilder studentBuilder;
  
    // constructor
    public StudentReceiverBuilder()
    {
  
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                studentBuilder = StudentBuilder.Builder.newInstance()
                        .setAddress("Maldrive")
                        .setId(1)
                        .setName("Chris")
                        .build();
                System.out.println("student value in Thread 1: " +studentBuilder);

            }
        });
         t1.start();
  
        // this create a new instance
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                studentBuilder = StudentBuilder.Builder.newInstance()
                              .setId(2)
                              .setName("Shyam")
                              .setAddress("Delhi")
                              .build();
                System.out.println("student value in Thread 2: " +studentBuilder);
            }
        });
        t2.start();
        //System.out.println("student value in StudentReceiverBuilder() constructor: " +studentBuilder);
    }
  
    public StudentBuilder getStudent()
    {
        System.out.println("student value in getStudent(): " +studentBuilder);
        return studentBuilder;
    }
}