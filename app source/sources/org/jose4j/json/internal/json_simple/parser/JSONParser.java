package org.jose4j.json.internal.json_simple.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jose4j.json.internal.json_simple.JSONArray;
import org.jose4j.json.internal.json_simple.JSONObject;

public class JSONParser {
    public static final int S_END = 6;
    public static final int S_INIT = 0;
    public static final int S_IN_ARRAY = 3;
    public static final int S_IN_ERROR = -1;
    public static final int S_IN_FINISHED_VALUE = 1;
    public static final int S_IN_OBJECT = 2;
    public static final int S_IN_PAIR_VALUE = 5;
    public static final int S_PASSED_PAIR_KEY = 4;
    private LinkedList handlerStatusStack;
    private Yylex lexer;
    private int status = 0;
    private Yytoken token = null;

    public JSONParser() {
        Yylex yylex;
        new Yylex((Reader) null);
        this.lexer = yylex;
    }

    private int peekStatus(LinkedList linkedList) {
        LinkedList statusStack = linkedList;
        if (statusStack.size() == 0) {
            return -1;
        }
        return ((Integer) statusStack.getFirst()).intValue();
    }

    public void reset() {
        this.token = null;
        this.status = 0;
        this.handlerStatusStack = null;
    }

    public void reset(Reader in) {
        this.lexer.yyreset(in);
        reset();
    }

    public int getPosition() {
        return this.lexer.getPosition();
    }

    public Object parse(String s) throws ParseException {
        return parse(s, (ContainerFactory) null);
    }

    public Object parse(String s, ContainerFactory containerFactory) throws ParseException {
        Reader reader;
        Throwable th;
        new StringReader(s);
        try {
            return parse(reader, containerFactory);
        } catch (IOException e) {
            IOException ie = e;
            Throwable th2 = th;
            new ParseException(-1, 2, ie);
            throw th2;
        }
    }

    public Object parse(Reader in) throws IOException, ParseException {
        return parse(in, (ContainerFactory) null);
    }

    public Object parse(Reader in, ContainerFactory containerFactory) throws IOException, ParseException {
        LinkedList linkedList;
        LinkedList linkedList2;
        Throwable th;
        Throwable th2;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Throwable th3;
        Throwable th4;
        ContainerFactory containerFactory2 = containerFactory;
        reset(in);
        new LinkedList();
        LinkedList statusStack = linkedList;
        new LinkedList();
        LinkedList valueStack = linkedList2;
        do {
            try {
                nextToken();
                switch (this.status) {
                    case -1:
                        Throwable th5 = th;
                        new ParseException(getPosition(), 1, this.token);
                        throw th5;
                    case 0:
                        switch (this.token.type) {
                            case 0:
                                this.status = 1;
                                new Integer(this.status);
                                statusStack.addFirst(obj8);
                                valueStack.addFirst(this.token.value);
                                break;
                            case 1:
                                this.status = 2;
                                new Integer(this.status);
                                statusStack.addFirst(obj7);
                                valueStack.addFirst(createObjectContainer(containerFactory2));
                                break;
                            case 3:
                                this.status = 3;
                                new Integer(this.status);
                                statusStack.addFirst(obj6);
                                valueStack.addFirst(createArrayContainer(containerFactory2));
                                break;
                            default:
                                this.status = -1;
                                break;
                        }
                    case 1:
                        if (this.token.type == -1) {
                            return valueStack.removeFirst();
                        }
                        Throwable th6 = th2;
                        new ParseException(getPosition(), 1, this.token);
                        throw th6;
                    case 2:
                        switch (this.token.type) {
                            case 0:
                                if (!(this.token.value instanceof String)) {
                                    this.status = -1;
                                    break;
                                } else {
                                    valueStack.addFirst((String) this.token.value);
                                    this.status = 4;
                                    new Integer(this.status);
                                    statusStack.addFirst(obj5);
                                    break;
                                }
                            case 2:
                                if (valueStack.size() <= 1) {
                                    this.status = 1;
                                    break;
                                } else {
                                    Object removeFirst = statusStack.removeFirst();
                                    Object removeFirst2 = valueStack.removeFirst();
                                    this.status = peekStatus(statusStack);
                                    break;
                                }
                            case 5:
                                break;
                            default:
                                this.status = -1;
                                break;
                        }
                    case 3:
                        switch (this.token.type) {
                            case 0:
                                boolean add = ((List) valueStack.getFirst()).add(this.token.value);
                                break;
                            case 1:
                                List val = (List) valueStack.getFirst();
                                Map newObject = createObjectContainer(containerFactory2);
                                boolean add2 = val.add(newObject);
                                this.status = 2;
                                new Integer(this.status);
                                statusStack.addFirst(obj2);
                                valueStack.addFirst(newObject);
                                break;
                            case 3:
                                List val2 = (List) valueStack.getFirst();
                                List newArray = createArrayContainer(containerFactory2);
                                boolean add3 = val2.add(newArray);
                                this.status = 3;
                                new Integer(this.status);
                                statusStack.addFirst(obj);
                                valueStack.addFirst(newArray);
                                break;
                            case 4:
                                if (valueStack.size() <= 1) {
                                    this.status = 1;
                                    break;
                                } else {
                                    Object removeFirst3 = statusStack.removeFirst();
                                    Object removeFirst4 = valueStack.removeFirst();
                                    this.status = peekStatus(statusStack);
                                    break;
                                }
                            case 5:
                                break;
                            default:
                                this.status = -1;
                                break;
                        }
                    case 4:
                        switch (this.token.type) {
                            case 0:
                                Object removeFirst5 = statusStack.removeFirst();
                                Object put = ((Map) valueStack.getFirst()).put((String) valueStack.removeFirst(), this.token.value);
                                this.status = peekStatus(statusStack);
                                break;
                            case 1:
                                Object removeFirst6 = statusStack.removeFirst();
                                String key = (String) valueStack.removeFirst();
                                Map parent = (Map) valueStack.getFirst();
                                Map newObject2 = createObjectContainer(containerFactory2);
                                Object put2 = parent.put(key, newObject2);
                                this.status = 2;
                                new Integer(this.status);
                                statusStack.addFirst(obj3);
                                valueStack.addFirst(newObject2);
                                break;
                            case 3:
                                Object removeFirst7 = statusStack.removeFirst();
                                String key2 = (String) valueStack.removeFirst();
                                Map parent2 = (Map) valueStack.getFirst();
                                List newArray2 = createArrayContainer(containerFactory2);
                                Object put3 = parent2.put(key2, newArray2);
                                this.status = 3;
                                new Integer(this.status);
                                statusStack.addFirst(obj4);
                                valueStack.addFirst(newArray2);
                                break;
                            case 6:
                                break;
                            default:
                                this.status = -1;
                                break;
                        }
                }
                if (this.status == -1) {
                    Throwable th7 = th3;
                    new ParseException(getPosition(), 1, this.token);
                    throw th7;
                }
            } catch (IOException e) {
                throw e;
            }
        } while (this.token.type != -1);
        Throwable th8 = th4;
        new ParseException(getPosition(), 1, this.token);
        throw th8;
    }

    private void nextToken() throws ParseException, IOException {
        Yytoken yytoken;
        this.token = this.lexer.yylex();
        if (this.token == null) {
            new Yytoken(-1, (Object) null);
            this.token = yytoken;
        }
    }

    private Map createObjectContainer(ContainerFactory containerFactory) {
        Map map;
        Map map2;
        ContainerFactory containerFactory2 = containerFactory;
        if (containerFactory2 == null) {
            new JSONObject();
            return map2;
        }
        Map m = containerFactory2.createObjectContainer();
        if (m != null) {
            return m;
        }
        new JSONObject();
        return map;
    }

    private List createArrayContainer(ContainerFactory containerFactory) {
        List list;
        List list2;
        ContainerFactory containerFactory2 = containerFactory;
        if (containerFactory2 == null) {
            new JSONArray();
            return list2;
        }
        List l = containerFactory2.creatArrayContainer();
        if (l != null) {
            return l;
        }
        new JSONArray();
        return list;
    }

    public void parse(String s, ContentHandler contentHandler) throws ParseException {
        parse(s, contentHandler, false);
    }

    public void parse(String s, ContentHandler contentHandler, boolean isResume) throws ParseException {
        Reader reader;
        Throwable th;
        new StringReader(s);
        try {
            parse(reader, contentHandler, isResume);
        } catch (IOException e) {
            IOException ie = e;
            Throwable th2 = th;
            new ParseException(-1, 2, ie);
            throw th2;
        }
    }

    public void parse(Reader in, ContentHandler contentHandler) throws IOException, ParseException {
        parse(in, contentHandler, false);
    }

    public void parse(Reader reader, ContentHandler contentHandler, boolean isResume) throws IOException, ParseException {
        LinkedList linkedList;
        Throwable th;
        Throwable th2;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Throwable th3;
        Throwable th4;
        LinkedList linkedList2;
        Reader in = reader;
        ContentHandler contentHandler2 = contentHandler;
        if (!isResume) {
            reset(in);
            new LinkedList();
            this.handlerStatusStack = linkedList2;
        } else if (this.handlerStatusStack == null) {
            reset(in);
            new LinkedList();
            this.handlerStatusStack = linkedList;
        }
        LinkedList statusStack = this.handlerStatusStack;
        do {
            try {
                switch (this.status) {
                    case -1:
                        Throwable th5 = th;
                        new ParseException(getPosition(), 1, this.token);
                        throw th5;
                    case 0:
                        contentHandler2.startJSON();
                        nextToken();
                        switch (this.token.type) {
                            case 0:
                                this.status = 1;
                                new Integer(this.status);
                                statusStack.addFirst(obj10);
                                if (!contentHandler2.primitive(this.token.value)) {
                                    return;
                                }
                                break;
                            case 1:
                                this.status = 2;
                                new Integer(this.status);
                                statusStack.addFirst(obj9);
                                if (!contentHandler2.startObject()) {
                                    return;
                                }
                                break;
                            case 3:
                                this.status = 3;
                                new Integer(this.status);
                                statusStack.addFirst(obj8);
                                if (!contentHandler2.startArray()) {
                                    return;
                                }
                                break;
                            default:
                                this.status = -1;
                                break;
                        }
                    case 1:
                        nextToken();
                        if (this.token.type == -1) {
                            contentHandler2.endJSON();
                            this.status = 6;
                            return;
                        }
                        this.status = -1;
                        Throwable th6 = th2;
                        new ParseException(getPosition(), 1, this.token);
                        throw th6;
                    case 2:
                        nextToken();
                        switch (this.token.type) {
                            case 0:
                                if (!(this.token.value instanceof String)) {
                                    this.status = -1;
                                    break;
                                } else {
                                    String key = (String) this.token.value;
                                    this.status = 4;
                                    new Integer(this.status);
                                    statusStack.addFirst(obj7);
                                    if (contentHandler2.startObjectEntry(key)) {
                                        break;
                                    } else {
                                        return;
                                    }
                                }
                            case 2:
                                if (statusStack.size() > 1) {
                                    Object removeFirst = statusStack.removeFirst();
                                    this.status = peekStatus(statusStack);
                                } else {
                                    this.status = 1;
                                }
                                if (!contentHandler2.endObject()) {
                                    return;
                                }
                                break;
                            case 5:
                                break;
                            default:
                                this.status = -1;
                                break;
                        }
                    case 3:
                        nextToken();
                        switch (this.token.type) {
                            case 0:
                                if (!contentHandler2.primitive(this.token.value)) {
                                    return;
                                }
                                break;
                            case 1:
                                this.status = 2;
                                new Integer(this.status);
                                statusStack.addFirst(obj2);
                                if (!contentHandler2.startObject()) {
                                    return;
                                }
                                break;
                            case 3:
                                this.status = 3;
                                new Integer(this.status);
                                statusStack.addFirst(obj);
                                if (!contentHandler2.startArray()) {
                                    return;
                                }
                                break;
                            case 4:
                                if (statusStack.size() > 1) {
                                    Object removeFirst2 = statusStack.removeFirst();
                                    this.status = peekStatus(statusStack);
                                } else {
                                    this.status = 1;
                                }
                                if (!contentHandler2.endArray()) {
                                    return;
                                }
                                break;
                            case 5:
                                break;
                            default:
                                this.status = -1;
                                break;
                        }
                    case 4:
                        nextToken();
                        switch (this.token.type) {
                            case 0:
                                Object removeFirst3 = statusStack.removeFirst();
                                this.status = peekStatus(statusStack);
                                if (contentHandler2.primitive(this.token.value)) {
                                    if (!contentHandler2.endObjectEntry()) {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                                break;
                            case 1:
                                Object removeFirst4 = statusStack.removeFirst();
                                new Integer(5);
                                statusStack.addFirst(obj3);
                                this.status = 2;
                                new Integer(this.status);
                                statusStack.addFirst(obj4);
                                if (!contentHandler2.startObject()) {
                                    return;
                                }
                                break;
                            case 3:
                                Object removeFirst5 = statusStack.removeFirst();
                                new Integer(5);
                                statusStack.addFirst(obj5);
                                this.status = 3;
                                new Integer(this.status);
                                statusStack.addFirst(obj6);
                                if (!contentHandler2.startArray()) {
                                    return;
                                }
                                break;
                            case 6:
                                break;
                            default:
                                this.status = -1;
                                break;
                        }
                    case 5:
                        Object removeFirst6 = statusStack.removeFirst();
                        this.status = peekStatus(statusStack);
                        if (!contentHandler2.endObjectEntry()) {
                            return;
                        }
                        break;
                    case 6:
                        return;
                }
                if (this.status == -1) {
                    Throwable th7 = th3;
                    new ParseException(getPosition(), 1, this.token);
                    throw th7;
                }
            } catch (IOException e) {
                IOException ie = e;
                this.status = -1;
                throw ie;
            } catch (ParseException e2) {
                ParseException pe = e2;
                this.status = -1;
                throw pe;
            } catch (RuntimeException e3) {
                RuntimeException re = e3;
                this.status = -1;
                throw re;
            } catch (Error e4) {
                Error e5 = e4;
                this.status = -1;
                throw e5;
            }
        } while (this.token.type != -1);
        this.status = -1;
        Throwable th8 = th4;
        new ParseException(getPosition(), 1, this.token);
        throw th8;
    }
}
