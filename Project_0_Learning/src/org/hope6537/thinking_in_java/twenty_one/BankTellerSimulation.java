package org.hope6537.thinking_in_java.twenty_one;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @describe 银行出纳员仿真
 * @author Hope6537(赵鹏)
 * @signdate 2014年8月10日下午7:41:28
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class BankTellerSimulation {

}

class Customer {
	private final int serviceTime;

	public Customer(int serviceTime) {
		super();
		this.serviceTime = serviceTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	@Override
	public String toString() {
		return "[服务时间=" + serviceTime + "]";
	}
}

class CustomerLine extends ArrayBlockingQueue<Customer> {

	/**
	 * @describe
	 */
	private static final long serialVersionUID = 3441359585380160156L;

	public CustomerLine(int maxLineSize) {
		super(maxLineSize);
	}

	@Override
	public String toString() {
		if (this.size() == 0) {
			return "[空]";
		}
		StringBuilder result = new StringBuilder();
		for (Customer customer : this) {
			result.append(customer);
		}
		return result.toString();
	}
}

class CustomerGenerator implements Runnable {
	private CustomerLine customers;
	private static Random rand = new Random(47);

	public CustomerGenerator(CustomerLine customers) {
		super();
		this.customers = customers;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(300);
				customers.put(new Customer(rand.nextInt(1000)));

			}
		} catch (Exception e) {
			System.out.println("顾客生产器被打断");
		}
		System.out.println("顾客生产器已停止");
	}
}

class Teller implements Runnable, Comparable<Teller> {
	private static int counter = 0;
	private final int id = counter++;
	// Customers served during this shift:
	private int customersServed = 0;
	private CustomerLine customers;
	private boolean servingCustomerLine = true;

	public Teller(CustomerLine cq) {
		customers = cq;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Customer customer = customers.take();
				TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
				synchronized (this) {
					customersServed++;
					while (!servingCustomerLine) {
						wait();
					}
				}
			}
		} catch (Exception e) {
			System.out.println(this + " 被打断");
		}
		System.out.println(this + " 业务结束");
	}

	@Override
	public synchronized int compareTo(Teller other) {
		return customersServed < other.customersServed ? -1
				: (customersServed == other.customersServed ? 0 : 1);
	}
}