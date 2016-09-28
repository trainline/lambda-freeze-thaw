/*
 * Copyright (c) Trainline Limited, 2016. All rights reserved.
 * See LICENSE.txt in the project root for license information
 */
package com.trainline.freezethaw;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;

public class FreezeThawLambda implements RequestHandler<Value, Value>{

    final static Logger log = Logger.getLogger(FreezeThawLambda.class);

    public FreezeThawLambda(){
        log.info("FreezeThawLambda created.");
        startBackgroundThread();
    }



    public Value handleRequest(Value request, Context context){
        log.info("request value:" + request.getValue());
        return new Value( request.getValue() * 2);
    }



    private void startBackgroundThread(){
        log.info("Starting background thread.");
        new Thread(){
            public void run(){
                int i = 0;
                while( true ){
                    long start = System.nanoTime();
                    FreezeThawLambda.sleep(1000);
                    long stop = System.nanoTime();
                    log.info( "background thread alive, iteration: " + ++i + " slept for: " + duration(start, stop));
                }
            }
        }.start();
    }



    private static long duration(long start, long stop){
        return (stop - start) / 1_000_000;
    }



    private static void sleep(long millis) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException x){
        }
    }


    public static void main(String ... args){
        new FreezeThawLambda();
    }
}
