package org.shaded.apache.http.io;

import java.io.IOException;
import org.shaded.apache.http.HttpException;
import org.shaded.apache.http.HttpMessage;

public interface HttpMessageParser {
    HttpMessage parse() throws IOException, HttpException;
}
