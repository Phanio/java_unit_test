package com.komidev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.util.Assert;

public class SomeBusinessTests {

    private SomeBusinessImp business = new SomeBusinessImp();
    private SomeDataService someDataServiceMock = Mockito.mock(SomeDataService.class);

    @BeforeEach
    public void init(){
        business.setSomeDataService(someDataServiceMock);
    }

    @Test
    public void calculateSumOfData(){
        SomeBusinessImp someBusinessImp = new SomeBusinessImp();
        int actualResult = someBusinessImp.calculateSum(new int[]{2,6});
        int expectedResult = 8;
        Assertions.assertEquals(expectedResult, actualResult);
    }
   @Test
    public void calculateSumWithOneElement(){
        SomeBusinessImp someBusinessImp = new SomeBusinessImp();
        int actualResult = someBusinessImp.calculateSum(new int[]{2});
        int expectedResult = 2;
        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void calculateSumWithEmptyElement(){
        SomeBusinessImp someBusinessImp = new SomeBusinessImp();
        int actualResult = someBusinessImp.calculateSum(new int[]{});
        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    /**
     * Unit test with stub concept
     */
    @Test
    public void calculateSumWithDataService(){
       SomeBusinessImp someBusinessImp = new SomeBusinessImp();
       someBusinessImp.setSomeDataService(stubSomeDataService);
       int actualtResult = someBusinessImp.calculateSumWithDataService();
       Assertions.assertEquals(6,actualtResult);
    }

    /**
     * Unit test with Mockito
     */
    @Test
    public void calculateSumWithMockObjetDataService(){
        Mockito.when(someDataServiceMock.getData()).thenReturn(new int[]{3,3});
        int actualResult = business.calculateSumWithDataService();
        Assertions.assertEquals(6,actualResult);
    }

    @Test
    public void calculateSumOfEmptyDataService(){
        Mockito.when(someDataServiceMock.getData()).thenReturn(new int[]{});
        int actualResult = business.calculateSumWithDataService();
        Assertions.assertEquals(0, actualResult);
    }
    private StubSomeDataService stubSomeDataService = new StubSomeDataService();
}

class StubSomeDataService implements SomeDataService{

    @Override
    public int[] getData() {
        return new int[]{2,4};
    }
}
