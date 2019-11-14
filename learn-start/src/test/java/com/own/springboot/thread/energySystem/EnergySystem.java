package com.own.springboot.thread.energySystem;

/**
 * 能量系统
 */
public class EnergySystem {

    // 能量盒子,存储能量
    private final double[] energyBoxs;
    // 锁对象，保证线程的同步
    private Object lockObj = new Object();

    /**
     *
     * @param n 能量盒子的数量
     * @param
     */
    public EnergySystem(int n,double initialEnergy) {

        this.energyBoxs = new double[n];
        for(int i = 0; i < energyBoxs.length; i++){
            energyBoxs[i] = initialEnergy;
        }
    }

    /**
     * 能量转移
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(int from, int to,double amount){

        // 能量不够，退出
        /*
        if(energyBoxs[from] < amount){
            return;
        }
         */
        synchronized (lockObj){
            // wait,释放岁lockObj的对象锁，将阻塞的进程放到wait set里去
            // wait(),notify(),notifyAll()都是Object的对象，而不是Thread的
            while(energyBoxs[from] < amount){
                try {
                    // 以为某些条件不满足，线程进入lockObj的waitSet里等待
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            energyBoxs[from] -= amount;
            energyBoxs[to] +=amount;
            System.out.printf(Thread.currentThread().getName()+":从盒子%d转移到盒子%d的能量是%10.2f",from,to,amount);
            System.out.printf("当前的能量总和：%10.2f%n",getTotalEnergy());
            // 通知wait的进程，lockObj状态已将改变，可以重新进行资源请求
            lockObj.notifyAll();
        }

    }

    public double getTotalEnergy(){
       double sum = 0;
       for(double energy : energyBoxs){
           sum +=energy;
       }
       return  sum;
    }

    public int getBoxAmount(){
        return energyBoxs.length;
    }

}
