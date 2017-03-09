package com.yf.erp.test;
import java.util.List;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author ���ʷ�
 *    2017��3��9��  ����6:05:14
 *    
 *     HtmlUnite ����   
 */
public class ClimbHtml {
	public static void main(String[] args) {
		try {
			initHtml("http://baidu.com/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initHtml(String url) throws Exception {
		// ���� chrome �����
		WebClient client = new WebClient(BrowserVersion.CHROME);
		// ����js������
		client.getOptions().setJavaScriptEnabled(false);
		// ����css������
		client.getOptions().setCssEnabled(false);
		// js ���д��� �����׳��쳣
		client.getOptions().setThrowExceptionOnScriptError(false);
		//����ajax����
		client.setAjaxController(new NicelyResynchronizingAjaxController());
		// ����cookie����
		client.setCookieManager(new CookieManager());
		//�����ض���
		client.getOptions().setRedirectEnabled(true);
		// �ȴ�js��Ⱦִ�� (ms)
		client.waitForBackgroundJavaScript(1000*5);

		// ����url��վ
		HtmlPage page = client.getPage(url);
		
		// ��ȡform ��ǩ
		HtmlForm form = page.getFormByName("f");
		// ��ȡform ���µ�input �����
		HtmlInput inputWD = form.getInputByName("wd");
		// ��������ò���    Ҳ��������ͼƬurl�������ϴ�ͼƬ
		inputWD.setValueAttribute("��ѧ��");
		// ��ȡinput ��ť
		HtmlInput inputButton = form.getInputByValue("�ٶ�һ��");
		// �����ť ��ת���¸�ҳ��
		HtmlPage nextPage = inputButton.click();
		client.waitForBackgroundJavaScript(1000*4);
		
		// ��ȡ class='list'��ǩ�µ�div �µ�class='imgshadow' ��div
		List xPath = nextPage.getByXPath("//div[@class='list']/div/div[@class='imgshadow']");
		System.out.println(nextPage.asText());
		//��ȡҳ�������е�����
		List<HtmlAnchor> links = nextPage.getAnchors();
		//querySelector(".i")  ����ѡ������ȡ��ǩ
		for(HtmlAnchor link : links){
			String href = link.getHrefAttribute();
			System.out.println("href:"+href+"\n");
		}

		client.closeAllWindows();
	}

}
