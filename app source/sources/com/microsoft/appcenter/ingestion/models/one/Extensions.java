package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Extensions implements Model {
    private static final String APP = "app";
    private static final String DEVICE = "device";
    private static final String LOC = "loc";
    private static final String METADATA = "metadata";
    private static final String NET = "net";
    private static final String OS = "os";
    private static final String PROTOCOL = "protocol";
    private static final String SDK = "sdk";
    private static final String USER = "user";
    private AppExtension app;
    private DeviceExtension device;
    private LocExtension loc;
    private MetadataExtension metadata;
    private NetExtension net;
    private OsExtension os;
    private ProtocolExtension protocol;
    private SdkExtension sdk;
    private UserExtension user;

    public Extensions() {
    }

    public MetadataExtension getMetadata() {
        return this.metadata;
    }

    public void setMetadata(MetadataExtension metadata2) {
        MetadataExtension metadataExtension = metadata2;
        this.metadata = metadataExtension;
    }

    public ProtocolExtension getProtocol() {
        return this.protocol;
    }

    public void setProtocol(ProtocolExtension protocol2) {
        ProtocolExtension protocolExtension = protocol2;
        this.protocol = protocolExtension;
    }

    public UserExtension getUser() {
        return this.user;
    }

    public void setUser(UserExtension user2) {
        UserExtension userExtension = user2;
        this.user = userExtension;
    }

    public DeviceExtension getDevice() {
        return this.device;
    }

    public void setDevice(DeviceExtension device2) {
        DeviceExtension deviceExtension = device2;
        this.device = deviceExtension;
    }

    public OsExtension getOs() {
        return this.os;
    }

    public void setOs(OsExtension os2) {
        OsExtension osExtension = os2;
        this.os = osExtension;
    }

    public AppExtension getApp() {
        return this.app;
    }

    public void setApp(AppExtension app2) {
        AppExtension appExtension = app2;
        this.app = appExtension;
    }

    public NetExtension getNet() {
        return this.net;
    }

    public void setNet(NetExtension net2) {
        NetExtension netExtension = net2;
        this.net = netExtension;
    }

    public SdkExtension getSdk() {
        return this.sdk;
    }

    public void setSdk(SdkExtension sdk2) {
        SdkExtension sdkExtension = sdk2;
        this.sdk = sdkExtension;
    }

    public LocExtension getLoc() {
        return this.loc;
    }

    public void setLoc(LocExtension loc2) {
        LocExtension locExtension = loc2;
        this.loc = locExtension;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        LocExtension locExtension;
        SdkExtension sdkExtension;
        NetExtension netExtension;
        AppExtension appExtension;
        OsExtension osExtension;
        DeviceExtension deviceExtension;
        UserExtension userExtension;
        ProtocolExtension protocolExtension;
        MetadataExtension metadataExtension;
        JSONObject object = jSONObject;
        if (object.has("metadata")) {
            new MetadataExtension();
            MetadataExtension metadata2 = metadataExtension;
            metadata2.read(object.getJSONObject("metadata"));
            setMetadata(metadata2);
        }
        if (object.has(PROTOCOL)) {
            new ProtocolExtension();
            ProtocolExtension protocol2 = protocolExtension;
            protocol2.read(object.getJSONObject(PROTOCOL));
            setProtocol(protocol2);
        }
        if (object.has(USER)) {
            new UserExtension();
            UserExtension user2 = userExtension;
            user2.read(object.getJSONObject(USER));
            setUser(user2);
        }
        if (object.has(DEVICE)) {
            new DeviceExtension();
            DeviceExtension device2 = deviceExtension;
            device2.read(object.getJSONObject(DEVICE));
            setDevice(device2);
        }
        if (object.has(OS)) {
            new OsExtension();
            OsExtension os2 = osExtension;
            os2.read(object.getJSONObject(OS));
            setOs(os2);
        }
        if (object.has(APP)) {
            new AppExtension();
            AppExtension app2 = appExtension;
            app2.read(object.getJSONObject(APP));
            setApp(app2);
        }
        if (object.has(NET)) {
            new NetExtension();
            NetExtension net2 = netExtension;
            net2.read(object.getJSONObject(NET));
            setNet(net2);
        }
        if (object.has(SDK)) {
            new SdkExtension();
            SdkExtension sdk2 = sdkExtension;
            sdk2.read(object.getJSONObject(SDK));
            setSdk(sdk2);
        }
        if (object.has(LOC)) {
            new LocExtension();
            LocExtension loc2 = locExtension;
            loc2.read(object.getJSONObject(LOC));
            setLoc(loc2);
        }
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        if (getMetadata() != null) {
            JSONStringer object = writer.key("metadata").object();
            getMetadata().write(writer);
            JSONStringer endObject = writer.endObject();
        }
        if (getProtocol() != null) {
            JSONStringer object2 = writer.key(PROTOCOL).object();
            getProtocol().write(writer);
            JSONStringer endObject2 = writer.endObject();
        }
        if (getUser() != null) {
            JSONStringer object3 = writer.key(USER).object();
            getUser().write(writer);
            JSONStringer endObject3 = writer.endObject();
        }
        if (getDevice() != null) {
            JSONStringer object4 = writer.key(DEVICE).object();
            getDevice().write(writer);
            JSONStringer endObject4 = writer.endObject();
        }
        if (getOs() != null) {
            JSONStringer object5 = writer.key(OS).object();
            getOs().write(writer);
            JSONStringer endObject5 = writer.endObject();
        }
        if (getApp() != null) {
            JSONStringer object6 = writer.key(APP).object();
            getApp().write(writer);
            JSONStringer endObject6 = writer.endObject();
        }
        if (getNet() != null) {
            JSONStringer object7 = writer.key(NET).object();
            getNet().write(writer);
            JSONStringer endObject7 = writer.endObject();
        }
        if (getSdk() != null) {
            JSONStringer object8 = writer.key(SDK).object();
            getSdk().write(writer);
            JSONStringer endObject8 = writer.endObject();
        }
        if (getLoc() != null) {
            JSONStringer object9 = writer.key(LOC).object();
            getLoc().write(writer);
            JSONStringer endObject9 = writer.endObject();
        }
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Extensions that = (Extensions) o;
        if (this.metadata == null ? that.metadata != null : !this.metadata.equals(that.metadata)) {
            return false;
        }
        if (this.protocol == null ? that.protocol != null : !this.protocol.equals(that.protocol)) {
            return false;
        }
        if (this.user == null ? that.user != null : !this.user.equals(that.user)) {
            return false;
        }
        if (this.device == null ? that.device != null : !this.device.equals(that.device)) {
            return false;
        }
        if (this.os == null ? that.os != null : !this.os.equals(that.os)) {
            return false;
        }
        if (this.app == null ? that.app != null : !this.app.equals(that.app)) {
            return false;
        }
        if (this.net == null ? that.net != null : !this.net.equals(that.net)) {
            return false;
        }
        if (this.sdk == null ? that.sdk != null : !this.sdk.equals(that.sdk)) {
            return false;
        }
        return this.loc != null ? this.loc.equals(that.loc) : that.loc == null;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * (this.metadata != null ? this.metadata.hashCode() : 0)) + (this.protocol != null ? this.protocol.hashCode() : 0))) + (this.user != null ? this.user.hashCode() : 0))) + (this.device != null ? this.device.hashCode() : 0))) + (this.os != null ? this.os.hashCode() : 0))) + (this.app != null ? this.app.hashCode() : 0))) + (this.net != null ? this.net.hashCode() : 0))) + (this.sdk != null ? this.sdk.hashCode() : 0))) + (this.loc != null ? this.loc.hashCode() : 0);
    }
}
