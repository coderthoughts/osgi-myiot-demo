package my.test.provider;

import java.util.Collections;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import my.iot.api.MyDevice;

@Component
public class TestImpl implements MyDevice {
    @Override
    public Map<String, String> blinkGreenLight() {
        System.out.println("<green>blink!</green>");

        return Collections.singletonMap("device", "Test-Device");
    }
}
