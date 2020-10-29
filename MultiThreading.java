package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultiThreading {
    public static void main(String[] args) throws InterruptedException {

        Store res = new Store();

        Van van1 = new Van("1", res);
        Van van2 = new Van("2", res);
        Van van3 = new Van("3", res);
        Van van4 = new Van("4", res);
        Van van5 = new Van("5", res);

        van1.start();
        van2.start();
        van3.start();
        van4.start();
        van5.start();

        Thread.sleep(100);

        van1.stopThread();
        van2.stopThread();
        van3.stopThread();
        van4.stopThread();
        van5.stopThread();

        van1.join();
        van2.join();
        van3.join();
        van4.join();
        van5.join();

    }

}

class Store{
    private List<Integer> storeList;

    public Store(){
        storeList = new ArrayList<>();
    }

    public void setElement(Integer element){
        storeList.add(element);
    }

    public Integer getElement(){
        if(storeList.size() > 0){
            return storeList.remove(0);
        }

        return null;
    }
}

class Van extends Thread{
    private Store resources;
    private boolean run;

    private Random random = new Random();

    public Van(String name, Store resources){
        super(name);
        this.resources = resources;
        run = true;
    }

    public void stopThread(){
        run = false;
    }

    @Override
    public void run() {
        int action;

        try{
            while(run){
                action = random.nextInt(1000);
                if(action % 2 == 0){
                    getFromResource();
                }else {
                    setIntoResources();
                }
            }

            System.out.println("Фура " + getName() + " завершила работу");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void getFromResource() throws InterruptedException {
        Integer number;

        synchronized (resources){
            System.out.println("Фура " + getName() + " хочет загрузить товар");
            number = resources.getElement();

            while(number == null){
                System.out.println("Фура" + getName() + " ждет товар");
                resources.wait();

                System.out.println("Фура" + getName() + " возобновила загрузку");
                number = resources.getElement();
            }
            System.out.println("Фура" + getName() + " загрузила товар");
        }
    }

    private void setIntoResources() throws InterruptedException{
        Integer number = random.nextInt(500);

        synchronized (resources){
            resources.setElement(number);
            System.out.println("Фура" + getName() + " выгрузила товар");

            resources.notify();
        }
    }
}


