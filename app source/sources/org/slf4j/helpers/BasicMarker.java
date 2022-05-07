package org.slf4j.helpers;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Marker;

public class BasicMarker implements Marker {
    private static String CLOSE = " ]";
    private static String OPEN = "[ ";
    private static String SEP = ", ";
    private static final long serialVersionUID = -2849567615646933777L;
    private final String name;
    private List<Marker> referenceList;

    BasicMarker(String str) {
        List<Marker> list;
        Throwable th;
        String name2 = str;
        new CopyOnWriteArrayList();
        this.referenceList = list;
        if (name2 == null) {
            Throwable th2 = th;
            new IllegalArgumentException("A marker name cannot be null");
            throw th2;
        }
        this.name = name2;
    }

    public String getName() {
        return this.name;
    }

    public void add(Marker marker) {
        Throwable th;
        Marker reference = marker;
        if (reference == null) {
            Throwable th2 = th;
            new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
            throw th2;
        } else if (!contains(reference) && !reference.contains((Marker) this)) {
            boolean add = this.referenceList.add(reference);
        }
    }

    public boolean hasReferences() {
        return this.referenceList.size() > 0;
    }

    public boolean hasChildren() {
        return hasReferences();
    }

    public Iterator<Marker> iterator() {
        return this.referenceList.iterator();
    }

    public boolean remove(Marker referenceToRemove) {
        return this.referenceList.remove(referenceToRemove);
    }

    public boolean contains(Marker marker) {
        Throwable th;
        Marker other = marker;
        if (other == null) {
            Throwable th2 = th;
            new IllegalArgumentException("Other cannot be null");
            throw th2;
        } else if (equals(other)) {
            return true;
        } else {
            if (hasReferences()) {
                for (Marker ref : this.referenceList) {
                    if (ref.contains(other)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public boolean contains(String str) {
        Throwable th;
        String name2 = str;
        if (name2 == null) {
            Throwable th2 = th;
            new IllegalArgumentException("Other cannot be null");
            throw th2;
        } else if (this.name.equals(name2)) {
            return true;
        } else {
            if (hasReferences()) {
                for (Marker ref : this.referenceList) {
                    if (ref.contains(name2)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this == obj2) {
            return true;
        }
        if (obj2 == null) {
            return false;
        }
        if (!(obj2 instanceof Marker)) {
            return false;
        }
        return this.name.equals(((Marker) obj2).getName());
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        StringBuilder sb;
        if (!hasReferences()) {
            return getName();
        }
        Iterator<Marker> it = iterator();
        new StringBuilder(getName());
        StringBuilder sb2 = sb;
        StringBuilder append = sb2.append(' ').append(OPEN);
        while (it.hasNext()) {
            StringBuilder append2 = sb2.append(it.next().getName());
            if (it.hasNext()) {
                StringBuilder append3 = sb2.append(SEP);
            }
        }
        StringBuilder append4 = sb2.append(CLOSE);
        return sb2.toString();
    }
}
