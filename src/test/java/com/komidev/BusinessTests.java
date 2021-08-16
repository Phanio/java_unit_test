package com.komidev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BusinessTests {

    @InjectMocks
    private SomeBusinessImp business;
    @Mock
    private SomeDataService someDataServiceMock;


    @Test
    public void calculateSumWithDataService(){
        Mockito.when(someDataServiceMock.getData()).thenReturn(new int[]{3,3});
        Assertions.assertEquals(6,business.calculateSumWithDataService());
    }

    @Test
    public void calculateSumDataServiceWithOneElement(){
        Mockito.when(someDataServiceMock.getData()).thenReturn(new int[]{5});
        Assertions.assertEquals(5, business.calculateSumWithDataService());
    }

    @Test
    public void calculateSumWithEmptyDataService(){
        Mockito.when(someDataServiceMock.getData()).thenReturn(new int[]{});
        Assertions.assertEquals(0, business.calculateSumWithDataService());
    }
}


