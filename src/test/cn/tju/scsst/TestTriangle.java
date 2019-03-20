package test.cn.tju.scsst;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.cn.tju.scsst.TriangleProgram;

@RunWith(Parameterized.class)
public class TestTriangle {
	private int money;
	private Boolean expected;
	private TriangleProgram triangleProgram = null;
	
	public TestTriangle(int money, Boolean expected){
		this.money = money;
		this.expected = expected;
	}
	
	@Before
	public void setUp() {
		triangleProgram = new TriangleProgram();
	}
	
	@Parameterized.Parameters
    public static Collection<Object[]> getData(){
        return Arrays.asList(new Object[][]{
                {83, true},
                {76, true},
                {29, false},
                {100, false},
                {-8, false},
                {0, true}
        });
    }
    
	@Test
	public void testCanWeTakeOut() {
		assertEquals(this.expected, triangleProgram.canWeTakeOut(money));
	}

}
