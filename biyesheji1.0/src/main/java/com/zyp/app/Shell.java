package com.zyp.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;
@Component
public class Shell
{

	public String execShell( String command , String decodeType )
	{
		StringBuilder result = new StringBuilder();
		InputStream is = null;
		BufferedReader br = null;
		try
		{
			Process process = null;

			process = Runtime.getRuntime().exec( command );

			is = process.getInputStream();

			br = new BufferedReader( new InputStreamReader( is , decodeType ) );

			String inString = "";
			while ( ( inString = br.readLine() ) != null )
			{
				result.append( inString + "\n" );
			}

			if ( result.length() > 0 )
			{
				result.delete( result.length() - 2 , result.length() - 1 );
			}
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				br.close();
				is.close();
			}
			catch ( IOException e )
			{
				e.printStackTrace();
			}
		}
		return result.toString();
	}

}
