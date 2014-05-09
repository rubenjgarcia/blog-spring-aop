package es.rubenjgarcia.aop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.rubenjgarcia.aop.ConfigBean;
import es.rubenjgarcia.aop.Foo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConfigBean.class)
public class TestAOP {

	@Autowired
	private Foo foo;
	
	@Test
	public void test()
	{
		foo.bar();
	}
}
