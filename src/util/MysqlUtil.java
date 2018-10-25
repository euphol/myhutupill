package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MysqlUtil {
	public static void backup(String mysqlPath,String backupfile) throws IOException{
		String commandFormat="\"%s/bin/mysqldump.exe\" -u%s -p%s -hlocalhost -P%d %s -r \"%s\"";
		
		String command=String.format(commandFormat, mysqlPath,DBUtil.loginName,DBUtil.password,DBUtil.port,DBUtil.database,backupfile);
		Runtime.getRuntime().exec(command);
		
	}
	public static void recover(String mysqlPath,String recoverfile){
		String commandFormat="\"%s/bin/mysql.exe\" -u%s -p%s %s";
		String command=String.format(commandFormat,mysqlPath,DBUtil.loginName,DBUtil.password,DBUtil.database);
		OutputStream out=null;
		BufferedReader br=null;
		OutputStreamWriter writer=null;
		try {
			Process p=Runtime.getRuntime().exec(command);
			out=p.getOutputStream();
			br=new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile)));
			String inStr;
			String outStr;
			StringBuffer sb=new StringBuffer("");
			while((inStr=br.readLine())!=null){
				sb.append(inStr+"\r\n");
			}
			outStr=sb.toString();
			writer=new OutputStreamWriter(out,"gbk");
			writer.write(outStr);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out!=null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(writer!=null)
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	public static void main(String[] args) throws IOException {
		String mysqlPath="C:/Program Files (x86)/MySQL/MySQL Server 5.5";
		String file="h:/test.sql";
		recover(mysqlPath, file);
	}
}
