package com.smalwe.lambda;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferredReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
