package learn.up.HomeWork20;

import learn.up.HomeWork20.event.MyEventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.*;

@SpringBootApplication
public class HomeWork20Application {

	private static final Logger log = LoggerFactory.getLogger(HomeWork20Application.class);
	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(HomeWork20Application.class, args);

		MyEventPublisher publisher = context.getBean(MyEventPublisher.class);

		int m = randomNumber();
		int i;

		ResourceBundle resourceBundle = ResourceBundle.getBundle("text", Locale.getDefault());

		publisher.publisherEvent(resourceBundle.getString("hello"));

		do {
			int number = new Scanner(System.in).nextInt();
			i = number;

			if ( m == i) {
				publisher.publisherEvent(resourceBundle.getString("win"));
			} else if (m < i) {
				publisher.publisherEvent(resourceBundle.getString("upper"));
			} else if (m > i) {
				publisher.publisherEvent(resourceBundle.getString("lower"));
			}
		} while (m < i || m > i);
	}

	@LogMethod
	public static int randomNumber() {
		int number = new Random().nextInt(1001);
		System.out.println("я загадал " + number);
		return number;
	}

}
