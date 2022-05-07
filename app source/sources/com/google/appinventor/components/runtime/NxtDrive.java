package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.NxtMotorMode;
import com.google.appinventor.components.common.NxtMotorPort;
import com.google.appinventor.components.common.NxtRegulationMode;
import com.google.appinventor.components.common.NxtRunState;
import java.util.ArrayList;
import java.util.List;

@SimpleObject
@DesignerComponent(category = ComponentCategory.NXT, description = "A component that provides a high-level interface to a LEGO MINDSTORMS NXT robot, with functions that can move and turn the robot.", iconName = "images/legoMindstormsNxt.png", nonVisible = true, version = 1)
public class NxtDrive extends LegoMindstormsNxtBase {
    private List<NxtMotorPort> KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2;
    private double hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO;
    private boolean kiRcALaZrUgDipBGGRCywmcwXV6owEI5LzNEBeYdXQPOcCNVgoIiuO1Q0ZEin4tA;
    private String vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NxtDrive(ComponentContainer componentContainer) {
        super(componentContainer, "NxtDrive");
        DriveMotors("CB");
        WheelDiameter(4.32f);
        StopBeforeDisconnect(true);
    }

    public void beforeDisconnect(BluetoothConnectionBase bluetoothConnectionBase) {
        BluetoothConnectionBase bluetoothConnectionBase2 = bluetoothConnectionBase;
        if (this.kiRcALaZrUgDipBGGRCywmcwXV6owEI5LzNEBeYdXQPOcCNVgoIiuO1Q0ZEin4tA) {
            for (NxtMotorPort outputState : this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2) {
                setOutputState("Disconnect", outputState, 0, NxtMotorMode.Brake, NxtRegulationMode.Disabled, 0, NxtRunState.Disabled, 0);
            }
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The motor ports that are used for driving: the left wheel's motor port followed by the right wheel's motor port.", userVisible = false)
    public String DriveMotors() {
        return this.vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg;
    }

    @DesignerProperty(defaultValue = "CB", editorType = "string")
    @SimpleProperty
    public void DriveMotors(String str) {
        List<NxtMotorPort> list;
        String str2 = str;
        this.vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg = str2;
        new ArrayList();
        this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2 = list;
        for (int i = 0; i < str2.length(); i++) {
            String valueOf = String.valueOf(str2.charAt(i));
            String str3 = valueOf;
            NxtMotorPort fromUnderlyingValue = NxtMotorPort.fromUnderlyingValue(valueOf);
            NxtMotorPort nxtMotorPort = fromUnderlyingValue;
            if (fromUnderlyingValue == null) {
                this.form.dispatchErrorOccurredEvent(this, "DriveMotors", 407, str3);
            } else {
                boolean add = this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2.add(nxtMotorPort);
            }
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The diameter of the wheels used for driving.", userVisible = false)
    public float WheelDiameter() {
        return (float) this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO;
    }

    @DesignerProperty(defaultValue = "4.32", editorType = "float")
    @SimpleProperty
    public void WheelDiameter(float f) {
        double d = (double) f;
        this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO = d;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether to stop the drive motors before disconnecting.")
    public boolean StopBeforeDisconnect() {
        return this.kiRcALaZrUgDipBGGRCywmcwXV6owEI5LzNEBeYdXQPOcCNVgoIiuO1Q0ZEin4tA;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty
    public void StopBeforeDisconnect(boolean z) {
        boolean z2 = z;
        this.kiRcALaZrUgDipBGGRCywmcwXV6owEI5LzNEBeYdXQPOcCNVgoIiuO1Q0ZEin4tA = z2;
    }

    @SimpleFunction(description = "Move the robot forward indefinitely, with the specified percentage of maximum power, by powering both drive motors forward.")
    public void MoveForwardIndefinitely(int i) {
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("MoveForwardIndefinitely", i, 0);
    }

    @SimpleFunction(description = "Move the robot backward indefinitely, with the specified percentage of maximum power, by powering both drive motors backward.")
    public void MoveBackwardIndefinitely(int i) {
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("MoveBackwardIndefinitely", -i, 0);
    }

    @SimpleFunction(description = "Move the robot forward the given distance, with the specified percentage of maximum power, by powering both drive motors forward.")
    public void MoveForward(int i, double d) {
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("MoveForward", i, (long) ((d * 360.0d) / (this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO * 3.141592653589793d)));
    }

    @SimpleFunction(description = "Move the robot backward the given distance, with the specified percentage of maximum power, by powering both drive motors backward.")
    public void MoveBackward(int i, double d) {
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("MoveBackward", -i, (long) ((d * 360.0d) / (this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO * 3.141592653589793d)));
    }

    private void hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(String str, int i, long j) {
        String str2 = str;
        int i2 = i;
        long j2 = j;
        if (checkBluetooth(str2)) {
            for (NxtMotorPort outputState : this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2) {
                setOutputState(str2, outputState, i2, NxtMotorMode.On, NxtRegulationMode.Speed, 0, NxtRunState.Running, j2);
            }
        }
    }

    @SimpleFunction(description = "Turn the robot clockwise indefinitely, with the specified percentage of maximum power, by powering the left drive motor forward and the right drive motor backward.")
    public void TurnClockwiseIndefinitely(int i) {
        int i2 = i;
        int size = this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2.size();
        int i3 = size;
        if (size >= 2) {
            hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("TurnClockwiseIndefinitely", i2, 0, i3 - 1);
        }
    }

    @SimpleFunction(description = "Turn the robot counterclockwise indefinitely, with the specified percentage of maximum power, by powering the right drive motor forward and the left drive motor backward.")
    public void TurnCounterClockwiseIndefinitely(int i) {
        int i2 = i;
        int size = this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2.size();
        int i3 = size;
        if (size >= 2) {
            hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("TurnCounterClockwiseIndefinitely", i2, i3 - 1, 0);
        }
    }

    private void hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(String str, int i, int i2, int i3) {
        String str2 = str;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (checkBluetooth(str2)) {
            setOutputState(str2, this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2.get(i5), i4, NxtMotorMode.On, NxtRegulationMode.Speed, 0, NxtRunState.Running, 0);
            setOutputState(str2, this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2.get(i6), -i4, NxtMotorMode.On, NxtRegulationMode.Speed, 0, NxtRunState.Running, 0);
        }
    }

    @SimpleFunction(description = "Stop the drive motors of the robot.")
    public void Stop() {
        String str = "Stop";
        if (checkBluetooth(str)) {
            for (NxtMotorPort outputState : this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2) {
                setOutputState(str, outputState, 0, NxtMotorMode.Brake, NxtRegulationMode.Disabled, 0, NxtRunState.Disabled, 0);
            }
        }
    }
}
