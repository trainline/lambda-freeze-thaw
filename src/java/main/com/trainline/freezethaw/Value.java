/*
 * Copyright (c) Trainline Limited, 2016. All rights reserved.
 * See LICENSE.txt in the project root for license information
 */
package com.trainline.freezethaw;

public class Value {

    long value = 0L;

    public void setValue( long aValue ){
        value = aValue;
    }

    public long getValue(){
        return value;
    }

    public Value(){
    }

    public Value( long aValue ){
        value = aValue;
    }

}
