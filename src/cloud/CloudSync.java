package cloud;

import action.Action;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CloudSync {
    private ConcurrentLinkedQueue<Action> queue;
    private Timer timer;
    private final int sendPeriod = 5;

    static private volatile CloudSync cloud = null;

    static public synchronized CloudSync getCloudSync(){
        if (CloudSync.cloud == null){
            CloudSync.cloud = new CloudSync();
        }
        return CloudSync.cloud;
    }

    public void addToQueue(Action action){
        this.queue.add(action);
    }

    /**
     * Send action to the server.
     * Returns true if it is successful and false otherwise
     * @param action
     * @return
     */
    private synchronized boolean send(Action action){
        // TODO : Stub
        System.out.println("Send " + action.toString());
        return true;
    }

    public synchronized boolean sendCurrentQueue(){
        while (!queue.isEmpty()){
            Action actionToSend = this.queue.peek();
            if (send(actionToSend)) {
                queue.remove();
            } else {
                // It is better to try next time
                return false;
            }
        }
        return true;
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
