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
		// ���� chrome �����
		WebClient client=new WebClient(BrowserVersion.CHROME);
		//����js������
		client.getOptions().setJavaScriptEnabled(true);
		//����css������
		client.getOptions().setCssEnabled(false);
		client.getOptions().setTimeout(35000);
		client.getOptions().setThrowExceptionOnScriptError(false);
		client.setAjaxController(new NicelyResynchronizingAjaxController());
		
		//����url��վ
		HtmlPage page = client.getPage(url);
		//��ȡform ��ǩ
		HtmlForm form = page.getFormByName("f");
		// ��ȡform ���µ�input �����
		HtmlInput inputWD= form.getInputByName("wd");
		// ��������ò���
		inputWD.setValueAttribute("���ǳ�");
		// ��ȡinput ��ť
		HtmlInput inputButton = form.getInputByValue("�ٶ�һ��");
		//�����ť ��ת���¸�ҳ��
		HtmlPage nextPage = inputButton.click();
		System.out.println(nextPage.asXml());
		
		client.closeAllWindows();
	}

}
