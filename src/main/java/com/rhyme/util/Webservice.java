package com.rhyme.util;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Webservice {
	private final Log log = LogFactory.getLog(Webservice.class);

	public String callSapReturnIBelnr(String sapXml) {
		String sapUrl = "";
		String account = "";
		String password = "";
		String authAccountAndPassword = new String(Base64.encodeBase64((account + ":" + password).getBytes()));
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient httpClient = httpClientBuilder.build();
		try {
			HttpPost httpPost = new HttpPost(sapUrl);
			// 配置超时时间
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(1000)
					.setConnectionRequestTimeout(1000).setSocketTimeout(1000).setRedirectsEnabled(true).build();
			httpPost.setConfig(requestConfig);
			httpPost.setHeader("Pragma", "no-cache");
			httpPost.setHeader("Cache-Control", "no-cache");
			httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
			httpPost.setHeader("Authorization", "Basic " + authAccountAndPassword);
			// SOAP 1.1版本可能需要该参数
			httpPost.setHeader("SOAPAction",
					"urn:sap-com:document:sap:soap:functions:mc-style:ZHLY_ACC_DOCUMENT_POST_SERVICE:ZhlyAccDocumentPostRequest");
			httpPost.setHeader("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			StringEntity data = new StringEntity(new String(sapXml.getBytes("UTF-8")), Charset.forName("UTF-8"));
			httpPost.setEntity(data);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			if (response != null && response.getStatusLine().getStatusCode() == 200) {
				HttpEntity httpEntity = response.getEntity();
				String retStr = EntityUtils.toString(httpEntity, "utf-8");
				Document responseDocument = DocumentHelper.parseText(retStr.toString());
				Element root = responseDocument.getRootElement();
				return root.element("Body").element("ZhlyAccDocumentPostResponse").element("IBelnr").getText()
						.toString();
			} else {
				log.info("[调用SAP系统失败,参数如下]  " + sapXml);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("解析sap生成凭证编号返回数据格式出错...");
		} finally {
			try {
				if (httpClient != null) {
					// 释放资源
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
}
