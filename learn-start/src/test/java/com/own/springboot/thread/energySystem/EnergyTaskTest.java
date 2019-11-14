package com.own.springboot.thread.energySystem;

public class EnergyTaskTest {

    public static final int BOX_AMOUNT = 100;
    public static  final int INITIAL_ENERGY = 1000;

    public static void main(String[] args){
        EnergySystem energySystem = new EnergySystem(BOX_AMOUNT,INITIAL_ENERGY);

        for(int i = 0; i < BOX_AMOUNT; i++){
            EnergyTrasnferTask task = new EnergyTrasnferTask(energySystem,i,BOX_AMOUNT);
            Thread thread = new Thread(task,"task"+i);
            thread.start();
        }
    }

}
