package GaoQi.thread;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String> {
    public String call()throws Exception{
        return "该线程已启动";
    }
    public static void main(String[] args) {

        FutureTask<String> task=new FutureTask<String>(new CallableDemo());

        new Thread(task).start();
        try{
            String result=task.get();
            System.out.println(result);
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch(ExecutionException e){
            e.printStackTrace();
        }


    }
}
