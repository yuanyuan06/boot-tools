package yuan.yuan.boot_tools.junit.mock;


import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import yuan.yuan.boot_tools.LoggerClass;

public class FirstMock extends LoggerClass {
	
	@Test
	public void testMock() {
		// 模拟LinkedList 的一个对象  
		LinkedList<String> mockedList = mock(LinkedList.class);
		
		// 模拟调用返回值
		when(mockedList.get(0)).thenReturn("first");
		
		// 模拟调用返回异常
		when(mockedList.get(1)).thenThrow(new RuntimeException());
		
		// ? 清空事件触发异常
		doThrow(new RuntimeException()).when(mockedList).clear();
//		mockedList.clear();
		
		
		when(mockedList.get(anyInt())).thenReturn("element");
		
		logger.debug(mockedList.get(89999));
		
		// 调用add一次
		mockedList.add("once"); 
		mockedList.add("twice"); 
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");
		
		// 重置mock
		reset(mockedList);
		
		boolean mockFlag = Mockito.mockingDetails(mockedList).isMock();
		
		List spyList = spy(new LinkedList<>());
		
		boolean spyFlag = Mockito.mockingDetails(mockedList).isSpy();
		
		boolean spyFlag1 = Mockito.mockingDetails(spyList).isSpy();
		logger.debug("isMock:{}, isSpy:{}, isSpy:{}", mockFlag, spyFlag, spyFlag1);
		
		logger.debug(mockedList.get(0));
		logger.debug(mockedList.get(1));
	}
}


