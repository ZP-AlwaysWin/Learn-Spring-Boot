package com.example.springbootstatemachine;

import com.example.springbootstatemachine.enumpackage.Events;
import com.example.springbootstatemachine.enumpackage.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class SpringbootStatemachineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStatemachineApplication.class, args);
	}

	@Autowired
	private StateMachine<States, Events> stateMachine;

	@Override
	public void run(String... args) throws Exception {

		//在run函数中，我们定义了整个流程的处理过程，其中start()就是创建这个订单流程，根据之前的定义，该订单会处于待支付状态，
		//然后通过调用sendEvent(Events.PAY)执行支付操作，最后通过掉用sendEvent(Events.RECEIVE)来完成收货操作。
		stateMachine.start();
		stateMachine.sendEvent(Events.PAY);
		stateMachine.sendEvent(Events.RECEIVE);
	}

}
