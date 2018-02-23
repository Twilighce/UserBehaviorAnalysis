package com.Twilighce.ubas.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Twilighce.ubas.service.Mapper;


public class MySQLFactory {

	private static final String CONFIGURATION_PATH = "mybatis.xml";

	private static final Map<String, SqlSessionFactory> SQLSESSIONFACTORYS = new HashMap<String, SqlSessionFactory>();

	private static final Logger LOGGER = LoggerFactory.getLogger(MySQLFactory.class);

	/**
	 * Create a mapper of environment by Mapper class
	 * 
	 * @param clazz
	 *            Mapper class
	 */
	@SuppressWarnings("unchecked")
	public static <T> T createMapper(Class<? extends Mapper> clazz) {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Mapper mapper = sqlSession.getMapper(clazz);
		return (T) MapperProxy.bind(mapper, sqlSession);
	}

	/**
	 * Mapper Proxy executing mapper method and close sqlsession
	 */
	private static class MapperProxy implements InvocationHandler {
		private Mapper mapper;
		private SqlSession sqlSession = null;

		private MapperProxy(Mapper mapper, SqlSession sqlSession) {
			this.mapper = mapper;
			this.sqlSession = sqlSession;
		}

		private static Mapper bind(Mapper mapper, SqlSession sqlSession) {
			return (Mapper) Proxy.newProxyInstance(mapper.getClass().getClassLoader(), mapper.getClass()
					.getInterfaces(), new MapperProxy(mapper, sqlSession));
		}

		/**
		 * execute mapper method and finally close single sqlSession
		 */
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

			Object object = null;
			try {
				object = method.invoke(mapper, args);
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error(e.getMessage(), e);
			} finally {
				try {
					if (this.sqlSession != null) {
						this.sqlSession.close();
						this.sqlSession = null;
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			return object;
		}
	}

	/**
	 * According to environment get SqlSessionFactory
	 * 
	 * @param environment
	 * @return SqlSessionFactory
	 */
	private static SqlSessionFactory getSqlSessionFactory() {

		String environment = SystemConfig.getProperty("dev.tag");
		SqlSessionFactory sqlSessionFactory = SQLSESSIONFACTORYS.get(environment);
		if (sqlSessionFactory != null) {
			return sqlSessionFactory;
		} else {
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(CONFIGURATION_PATH);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, environment);
				LOGGER.info(String.format("Apply for {%s} SqlSessionFactory memory successfully.", environment));
			} catch (IOException e) {
				e.printStackTrace();
				LOGGER.error(String.format("Apply for {%s} SqlSessionFactory memory error.", environment));
				LOGGER.error(String.format("Error msg is %s"), e.getMessage());
			} finally {
				IOUtils.closeQuietly(inputStream);
			}

			SQLSESSIONFACTORYS.put(environment, sqlSessionFactory);
			return sqlSessionFactory;
		}
	}
}
