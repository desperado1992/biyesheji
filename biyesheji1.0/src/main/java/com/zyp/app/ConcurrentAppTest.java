package com.zyp.app;

import org.apache.log4j.Logger;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.springframework.stereotype.Component;
@Component
public class ConcurrentAppTest
{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ConcurrentAppTest.class);



	private static int thread_num = 100;

	private static int client_num = 2000;
	
	
	public void connect(){
		

		ExecutorService exec = Executors.newCachedThreadPool();
		// 100个线程可以同时访问
		final Semaphore semp = new Semaphore( thread_num );
		// 模拟2000个客户端访问

		for( int index = 0 ; index < client_num ; index ++ )
		{

			final int NO = index;

			Runnable run = new Runnable()
			{
				public void run()
				{
					try
					{
						// 获取许可
						
						semp.acquire();
						System.out.println( "Thread:" + NO );
						
						String host = "http://localhost:8080/ssh/main.do";
						URL url = new URL( host );// 此处填写供测试的url

						HttpURLConnection connection = ( HttpURLConnection ) url.openConnection();
						 connection.setRequestMethod("POST");
//						 connection.setRequestProperty("Proxy-Connection",
//						 "Keep-Alive");
					
						connection.setDoOutput( true );
						connection.setDoInput( true );
						connection.setUseCaches(false);
						PrintWriter out = new PrintWriter( connection.getOutputStream() );
                        
						out.flush();
						out.close();
						BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
						String line = "";
						String result = "";
						int num=0;
						while ( ( line = in.readLine() ) != null )
						{
							num++;
							result += line;
							logger.info("这是第"+num+"次结果！请求完成");
						}

						

						// Thread.sleep((long) (Math.random()) * 1000);
						
						// 释放
						Thread.sleep( 1000 );
						semp.release();
						
					}
					catch ( Exception e )
					{
						e.printStackTrace();
					}
				}
			};
            logger.info("exec"+index);
			exec.execute( run );

		}

		// 退出线程池

		exec.shutdown();

		
	}
	
	public static void main(String[] args)
	{

		ExecutorService exec = Executors.newCachedThreadPool();
		// 100个线程可以同时访问
		final Semaphore semp = new Semaphore( thread_num );
		// 模拟2000个客户端访问

		for( int index = 0 ; index < client_num ; index ++ )
		{

			final int NO = index;

			Runnable run = new Runnable()
			{
				public void run()
				{
					try
					{
						// 获取许可
						
						semp.acquire();
						System.out.println( "Thread:" + NO );
						
						String host = "http://localhost:8080/ssh/index.do";
						URL url = new URL( host );// 此处填写供测试的url

						HttpURLConnection connection = ( HttpURLConnection ) url.openConnection();
						// connection.setRequestMethod("POST");
						// connection.setRequestProperty("Proxy-Connection",
						// "Keep-Alive");
						connection.setDoOutput( true );
						connection.setDoInput( true );
						PrintWriter out = new PrintWriter( connection.getOutputStream() );
                        
						out.flush();
						out.close();
						BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
						String line = "";
						String result = "";
						while ( ( line = in.readLine() ) != null )
						{
//							result += line;
						}

						 System.out.println(result);

						// Thread.sleep((long) (Math.random()) * 1000);
						
						// 释放
						Thread.sleep( 1000 );
						semp.release();
						
					}
					catch ( Exception e )
					{
						e.printStackTrace();
					}
				}
			};

			exec.execute( run );

		}

		// 退出线程池

		exec.shutdown();

	}

	
	
	
}