/**
 * 
 */
package java7.concurrency.cookbook.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @author bells
 *
 */
public class Calculator implements Runnable {

	private int number;

	public Calculator(int number) {
		this.number = number;
	}

	public void run() {

		for (int i = 1; i <= 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread()
					.getName(), number, i, i * number);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(1);  //Terminates the currently running Java Virtual Machine
		}

	}

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			Calculator calculator = new Calculator(i);
			Thread thread = new Thread(calculator);
			thread.start();
		}
	}

}