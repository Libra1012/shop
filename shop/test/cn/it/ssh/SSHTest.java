package cn.it.ssh;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.impl.CategoryServiceImpl;

/***
 * @Title:SSHTest
 * @author venus
 *采用spring的注解形式，仅仅支持spring3.1及以后版本
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-*.xml")
public class SSHTest {

	@Resource
	private Date date;
	
	@Resource
	private CategoryService categoryService;
	
	@Test //测试spring IOC 的开发环境
	public void springIoc(){
		System.out.println(date);
	}
	
	@Test //测试hibernate 的开发环境,因为没有整合
	public void hibernate(){	
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.save(new Category("男士休闲", true));
	}
	
	@Test //测试update
	public void hibernateAndSpring(){	
		categoryService.update(new Category(1, "女士休闲", false));
	}
}
