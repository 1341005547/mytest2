package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilDatatest {
	@Test
	public void string2IntTest(){
		assertEquals("123",UtilData.string2Int("123"));
	}
}
