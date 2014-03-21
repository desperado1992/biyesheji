package com.zyp.jasypt;



import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)//让junit工作在spring环境中
@ContextConfiguration({	"classpath:spring.xml","classpath:spring-mvc.xml","classpath:spring-hibernate.xml"})//在classes中spring的配置文件
//transactionManager表示在spring配置文件中所声明的事务对象mvn install -Dmaven.test.skip=true  
//defaultRollback=true表示操作会自动回滚，这样你在单元测试中所作的操作都不会影响数据库中的数据
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class JasyptTest
{
//	@Resource
//	FreemarkerService freemarkerService;
	
	@Test
	public void testEncode(){
	 BasicTextEncryptor encryptor = new BasicTextEncryptor();  
     encryptor.setPassword("zhuyuping");  
     String encrypted = encryptor.encrypt("jdbc:mysql://localhost:3306/biyesheji?createDatabaseIfNotExist=true&autoReconnectForPools=true&useUnicode=true&characterEncoding=UTF-8&useServerPrepStmts=true");  
     System.out.println(encrypted);
     

	
	}
	@Test
	public void testcreateTop(){
		
//		freemarkerService.createTop();
		
	}
	
}
