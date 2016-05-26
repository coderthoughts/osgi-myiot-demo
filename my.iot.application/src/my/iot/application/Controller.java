package my.iot.application;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import my.iot.api.MyDevice;

@Component
public class Controller {
    private volatile boolean keepRunning = true;

    @Reference
    private volatile MyDevice myDevice;

    @Activate
    public void activate() {
        new Thread(() -> {
            while(keepRunning) {
                try {
                    Map<String, String> res = myDevice.blinkGreenLight();
                    System.out.println("Contacted: " + res);
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Stopped");
        }).start();
    }

    @Deactivate
    public void deactivate() {
        keepRunning = false;
    }
}
