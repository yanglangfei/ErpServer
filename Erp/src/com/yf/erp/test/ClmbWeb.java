package com.yf.erp.test;

import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ClmbWeb {
	public static void main(String[] args) {
		try {
			initHtml("http://baidu.com/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initHtml(String url) throws Exception {
		// 创建 chrome 浏览器
		WebClient client = new WebClient(BrowserVersion.CHROME);
		// 启用js解释器
		client.getOptions().setJavaScriptEnabled(false);
		// 启用css解释器
		client.getOptions().setCssEnabled(false);
		// js 运行错误 ，不抛出异常
		client.getOptions().setThrowExceptionOnScriptError(false);
		//启用ajax代理
		client.setAjaxController(new NicelyResynchronizingAjaxController());
		// 启用cookie管理
		client.setCookieManager(new CookieManager());
		//启用重定向
		client.getOptions().setRedirectEnabled(true);
		// 等待js渲染执行 (ms)
		client.waitForBackgroundJavaScript(1000*50);

		// 访问url网站
		HtmlPage page = client.getPage(url);
		
		// 获取form 标签
		HtmlForm form = page.getFormByName("f");
		// 获取form 表单下的input 输入框
		HtmlInput inputWD = form.getInputByName("wd");
		// 输入框设置参数    也可以设置图片url，用于上传图片
		inputWD.setValueAttribute("张学友");
		// 获取input 按钮
		HtmlInput inputButton = form.getInputByValue("百度一下");
		// 点击按钮 跳转到下个页面
		HtmlPage nextPage = inputButton.click();
		client.waitForBackgroundJavaScript(1000*4);
		
		// 获取 class='list'标签下的div 下的class='imgshadow' 的div
		List xPath = nextPage.getByXPath("//div[@class='list']/div/div[@class='imgshadow']");
		System.out.println(nextPage.asText());
		//获取页面中所有的链接
		List<HtmlAnchor> links = nextPage.getAnchors();
		//querySelector(".i")  根据选择器获取标签
		for(HtmlAnchor link : links){
			String href = link.getHrefAttribute();
			System.out.println("href:"+href+"\n");
		}

		client.closeAllWindows();
	}

}
