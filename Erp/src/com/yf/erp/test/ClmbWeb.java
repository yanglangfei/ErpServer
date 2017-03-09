package com.yf.erp.test;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ClmbWeb {
	public static void main(String[] args) {
		try {
			initHtml("https://www.baidu.com/");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static void initHtml(String url) throws Exception{
		// 创建 chrome 浏览器
		WebClient client=new WebClient(BrowserVersion.CHROME);
		//启用js解释器
		client.getOptions().setJavaScriptEnabled(true);
		//启用css解释器
		client.getOptions().setCssEnabled(false);
		client.getOptions().setTimeout(35000);
		client.getOptions().setThrowExceptionOnScriptError(false);
		client.setAjaxController(new NicelyResynchronizingAjaxController());
		
		//访问url网站
		HtmlPage page = client.getPage(url);
		//获取form 标签
		HtmlForm form = page.getFormByName("f");
		// 获取form 表单下的input 输入框
		HtmlInput inputWD= form.getInputByName("wd");
		// 输入框设置参数
		inputWD.setValueAttribute("周星驰");
		// 获取input 按钮
		HtmlInput inputButton = form.getInputByValue("百度一下");
		//点击按钮 跳转到下个页面
		HtmlPage nextPage = inputButton.click();
		System.out.println(nextPage.asXml());
		
		client.closeAllWindows();
	}

}
