package edu.mit.appinventor.ble;

import com.google.appinventor.components.runtime.Component;
import java.util.UUID;

public interface BLEDevice extends Component {
    UUID GetBroadcastUUID();
}
