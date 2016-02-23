package com.ganqiang.weixinpub;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class WeiXinServlet extends HttpServlet{
	

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(WeiXinServlet.class);
	private static final String log4j = System.getProperty("user.dir")
			+ "/conf/log4j.conf";
	
	static{
		PropertyConfigurator.configure(log4j);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info("===========start====================");
		String str = "";
		String contenxt = request.getAttribute("Content").toString();
		if(contenxt.contains("伟华")){
			str += "张伟华！";
		}else if(contenxt.contains("振华")){
			str += "赵振华！";
		}else if(contenxt.contains("小平")){
			str += "平杰峰！";
		}else if(contenxt.contains("大牛") || contenxt.contains("过量") || contenxt.contains("郭亮")){
			str += "大牛！";
		}else if(contenxt.contains("老五") || contenxt.contains("老武") || contenxt.contains("亚文")){
			str += "蛋糕！";
		}else if(contenxt.contains("小草") || contenxt.contains("刘劲草")){
			str += "老草！";
		}else if(contenxt.contains("段子")){
			str += "三九寒天，办公室里很多人都患上重感冒，生病的人于是都提出请病假， 防止病情扩散出去。领导觉得很有道理，就让没病的人回家了。";
		}else{
			str = "关键词不对，请输入　段子　两字";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<xml>");
		out.println("<ToUserName><![CDATA[toUser]]></ToUserName>");
		out.println("<FromUserName><![CDATA[fromUser]]></FromUserName>");
		out.println("<CreateTime>"+Calendar.getInstance().getTime().toString()+"</CreateTime>");
		out.println("<MsgType><![CDATA[text]]></MsgType>");
		out.println("<Content><![CDATA[你好]]>,");
		out.println(str);
		out.println("<HTML>");
		out.println("<HTML>");
		out.println("</Content>");
		out.println("</xml>");
		logger.info("===========finish====================");
	}
	
	
	
//	public static void main(String... args) throws Exception {
//		
//		Server server = new Server();
//		Connector connector = new SocketConnector();
//		connector.setPort(80);
//		server.setConnectors(new Connector[] { connector });
//		Handler handler = new HelloHandler();
//		server.setHandler(handler);
//		server.start();
//		server.join();
//	}
//	
//	public static class HelloHandler extends AbstractHandler {
//
//
//		@Override
//		public void handle(String target, HttpServletRequest request,
//                HttpServletResponse response, int dispatch) throws IOException,
//                ServletException {
////	    Request base_request = (request instanceof Request) ? (Request) request
////	            : HttpConnection.getCurrentConnection().getRequest();
////	    base_request.setHandled(true);
//			String contenxt = request.getAttribute("Content").toString();
//			String str = "<xml>"
//						+"<ToUserName><![CDATA[toUser]]></ToUserName>"
//						+"<FromUserName><![CDATA[fromUser]]></FromUserName>"
//						+"<CreateTime>"+Calendar.getInstance().getTime().toString()+"</CreateTime>"
//						+"<MsgType><![CDATA[text]]></MsgType>"
//						+"<Content><![CDATA[你好]]>,";
//			if(contenxt.contains("伟华")){
//				str += "张伟华！";
//			}else if(contenxt.contains("振华")){
//				str += "赵振华！";
//			}else if(contenxt.contains("大牛") || contenxt.contains("过量") || contenxt.contains("郭亮")){
//				str += "大牛！";
//			}else if(contenxt.contains("老五") || contenxt.contains("老武") || contenxt.contains("亚文")){
//				str += "蛋糕！";
//			}else if(contenxt.contains("小草") || contenxt.contains("刘劲草")){
//				str += "老草！";
//			}else if(contenxt.contains("段子")){
//				str += "三九寒天，办公室里很多人都患上重感冒，生病的人于是都提出请病假， 防止病情扩散出去。领导觉得很有道理，就让没病的人回家了。";
//			}else{
//				str = "关键词不对，请输入　段子　两字";
//			}
//			str += "</Content></xml>";
//			System.out.println("asaadfasdf");
//	    response.setContentType("text/html");
//	    response.setStatus(HttpServletResponse.SC_OK);
//	    response.getWriter().println(str);
//        }
//
//
//    }

}
