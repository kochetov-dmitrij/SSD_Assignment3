package cloud;

import action.Action;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CloudSync {
    private ConcurrentLinkedQueue<Action> queue;
    private Timer timer;
    private final int sendPeriod = 5;

    static private CloudSync cloud = null;

    static public synchronized CloudSync getCloudSync(){
        if (CloudSync.cloud == null){
            CloudSync.cloud = new CloudSync();
        }
        return CloudSync.cloud;
    }

    public void addToQueue(Action action){
        this.queue.add(action);
    }

    private synchronized void send(Action action){
        // TODO : Stub
        System.out.println("Send " + action.toString());
    }

    public synchronized void sendCurrentQueue(){
        while (!queue.isEmpty()){
            this.send(queue.remove());
        }
    }

    private void initializeConnection(){
        // TODO : Stub
        System.out.println("Connection initialized");
    }

    private void startTimer(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                CloudSync.getCloudSync().sendCurrentQueue();
            }
        };
        long delay = sendPeriod * 1000;
        this.timer = new Timer("CloudSyncTimer");
        timer.schedule(task, delay);
    }

    public CloudSync(){
        this.queue = new ConcurrentLinkedQueue<>();
        initializeConnection();
        startTimer();
    }
}
