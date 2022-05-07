package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CComplex extends Complex implements Externalizable {
    RealNum imag;
    RealNum real;

    public CComplex() {
    }

    public CComplex(RealNum real2, RealNum imag2) {
        this.real = real2;
        this.imag = imag2;
    }

    public RealNum re() {
        return this.real;
    }

    public RealNum im() {
        return this.imag;
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        ObjectOutput out = objectOutput;
        out.writeObject(this.real);
        out.writeObject(this.imag);
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        ObjectInput in = objectInput;
        this.real = (RealNum) in.readObject();
        this.imag = (RealNum) in.readObject();
    }
}
