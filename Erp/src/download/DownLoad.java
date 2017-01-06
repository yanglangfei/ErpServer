package download;

import java.awt.Paint;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uu.http.client.HttpClient;
import com.uu.http.html.HTMLParser;
import com.uu.http.html.dom.Document;
import com.uu.http.html.dom.Element;
import com.uu.http.html.dom.Node;
import com.uu.http.html.parser.Elements;
import com.yf.erp.util.HttpUtil;

public class DownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.flush();
		out.close();
	}
	
	
	
	public static void main(String[] args) throws IOException {
		String url="http://image.so.com/i?ie=utf-8&src=hao_360so&q=zh";

		String res=new HttpClient().get(url, "UTF-8");
		Document doc=HTMLParser.parse(res);
		Element select = doc.select(".name").first();
		String attr = select.attr("href");
		System.out.println("res:"+doc.body());
	}

}
