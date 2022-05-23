package learn.up.HomeWork20.event;

import learn.up.HomeWork20.WorkTime;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

    @WorkTime
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println(event.getData());
    }
}
