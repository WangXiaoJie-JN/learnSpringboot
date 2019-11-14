package com.own.springboot.thread.energySystem;

public class EnergyTrasnferTask implements  Runnable {

    private EnergySystem energySystem;
    private  int fromBox;
    private  double maxAmount;
    private int delay = 10;

    public EnergyTrasnferTask(EnergySystem energySystem,int fromBox,double maxAmount){
        this.energySystem = energySystem;
        this.fromBox = fromBox;
        this.maxAmount = maxAmount;
    }
    @Override
    public void run() {

        while(true){
            int toBox = (int)Math.floor(energySystem.getBoxAmount()*Math.random());
            double amount = maxAmount*Math.random();
            energySystem.transfer(fromBox,toBox,amount);
            try {
                Thread.sleep((int)(delay*Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
