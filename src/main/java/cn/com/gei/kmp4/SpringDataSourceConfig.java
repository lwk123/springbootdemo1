package cn.com.gei.kmp4;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = { "cn.com.gei.kmp4.kaoqinmgr" }, sqlSessionFactoryRef = "springSqlSessionFactory")
public class SpringDataSourceConfig {

	@Primary
	@Bean(name = "springDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource sendDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "springTransactionManager")
	public DataSourceTransactionManager transactionManager(@Qualifier("springDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Primary
	@Bean(name = "springSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("springDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factoryBean.setMapperLocations(resolver.getResources("classpath:*/kaoqinmgr/mapper/*.xml"));
		return factoryBean.getObject();
	}

}
