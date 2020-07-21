package com.change.jmh;

import org.openjdk.jmh.annotations.*;


/**
 * @Author: qiaodong
 * @Date: 2020/6/23 18:29
 */
public class PSTest {

    @Benchmark
    @Warmup(iterations = 1,time = 3)
    @Fork(5)
    @BenchmarkMode(Mode.Throughput)
    @Measurement(iterations = 1,time = 3)
    public void testForEach() {
        PS.foreach();
    }

}
