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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = { "cn.com.gei.kmp4.krp" }, sqlSessionFactoryRef = "krpSqlSessionFactory")
public class KRPSpringDataSourceConfig {

	@Bean(name = "krpDataSource")
	@ConfigurationProperties(prefix = "krp.datasource")
	public DataSource sendDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "krpTransactionManager")
	public DataSourceTransactionManager transactionManager(@Qualifier("krpDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "krpSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("krpDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factoryBean.setMapperLocations(resolver.getResources("classpath:*/krp/mapper/*.xml"));
		return factoryBean.getObject();
	}

}
