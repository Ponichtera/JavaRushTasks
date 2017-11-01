package com.javarush.task.task17.task1712;

public class Cook implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        boolean needToWait;
        while (continueWorking || needToCookOrders()) {
            try {
                synchronized (this) {
                    needToWait = !needToCookOrders();
                    if (!needToWait) {
                        cooking();
                    }
                }
                if (continueWorking && needToWait) {
                    System.out.println("Chef resting"); //Повар отдыхает
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean needToCookOrders() {
        return !Manager.getInstance().getOrderQueue().isEmpty();
    }

    private void cooking() throws InterruptedException {
        Manager manager = Manager.getInstance();
        Order order = manager.getOrderQueue().poll();      // повар берет заказ из очереди
        System.out.println(String.format("The order will be prepared %d ms for table no.%d", order.getTime(), order.getTableNumber()));//"Заказ будет готовиться %d мс для стола №%d"
        Thread.sleep(order.getTime());     // готовим блюдо
        Dishes dishes = new Dishes(order.getTableNumber());       //  это готовое блюдо
        System.out.println(String.format("Order for table #%d ready", dishes.getTableNumber())); //"Заказ для стола №%d готов"
        manager.getDishesQueue().add(dishes);
    }
}
