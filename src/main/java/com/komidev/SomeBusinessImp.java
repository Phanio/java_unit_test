package com.komidev;

import java.util.Arrays;
import java.util.OptionalInt;

public class SomeBusinessImp {
    private  SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data){
        OptionalInt sum = Arrays.stream(data).reduce((s, a) -> s+a);
        return !sum.isEmpty()? sum.getAsInt(): 0;
    }

    public int calculateSumWithDataService(){
        OptionalInt sum = Arrays.stream(someDataService.getData()).reduce((s, e)-> s+e);
        return !sum.isEmpty()? sum.getAsInt(): 0;
    }
}
