package com.axiom.hyketask.service.filter;

public interface MobileFilter <OUT, F>{
    OUT filter(F filter);
    boolean shouldCompute(F filter);
}
