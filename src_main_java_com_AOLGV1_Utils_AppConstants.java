package com.AOLGV1.Utils;
public class AppConstants 
	{
		public static final String ENV 					="PROD";
		public static final String CURRENT_DIR = System.getProperty("user.dir");
		public static final String APP_URL_PROD			="\\classes\\A.html";
		public static final String APP_URL_DEV			="\\src\\main\\resources\\A.html";
		public static final String REPORT_PROD			="\\classes\\Report.txt";
		public static final String REPORT_DEV			="\\src\\main\\resources\\Report.txt";
		
		public static final String ALERT_PROD			="\\classes\\Alert.txt";
		public static final String ALERT_DEV			="\\src\\main\\resources\\Alert.txt";
		
		
  	    public static final String BROWSER_OPTIONS		 ="--headless";
		public static final String XPATH_IFRAME_1	  	 ="arul";
		public static final String XPATH_IFRAME_2	  	 ="iframe:nth-child(1)";
		public static final String XPATH_IFRAME_3	  	 ="//*[contains(@id, 'tradingview')]";
		public static final String XPATH_TIMESERIES	  	 ="(//*[@class='submenu apply-common-tooltip'])[1]";
		public static final String XPATH_TIMESERIES30	 ="//*[@class='charts-popup-list intervals-list favored-list']/span[@class='item'][3]";
		public static final String XPATH_CHARTMENU   	 ="(//*[@class='submenu apply-common-tooltip'])[2]";
		public static final String XPATH_LOADCHART   	 ="//*[@class='charts-popup-list narrow favored-list chart-style-popup']/a[@class='item'][2]";
		public static final String XPATH_INDICATORMENU 	 ="//*[@class='button toggle-caption indicators apply-common-tooltip']";
		public static final String XPATH_LOADINDICATOR 	 ="//*[@class='tv-insert-indicator-dialog__items-list']//*[@title='SuperTrend']";
		public static final String XPATH_MODALCLOSE	 	 ="//*[@class='tv-dialog__close js-dialog__close']";
		public static final String ARGS					 ="arguments[0].click();";
		public static final String XPATH_OPEN		  	 ="(//*[@class='pane-legend-item-value-wrap'])[1]\r\n";
		public static final String XPATH_HIGH		  	 ="(//*[@class='pane-legend-item-value-wrap'])[2]\r\n";
		public static final String XPATH_LOW		  	 ="(//*[@class='pane-legend-item-value-wrap'])[3]\r\n";
		public static final String XPATH_CLOSE		  	 ="(//*[@class='pane-legend-item-value-wrap'])[4]\r\n";
		public static final String XPATH_TRENDLINE	  	 ="(//*[@class='pane-legend-item-value pane-legend-line'])[1]";
		public static final String PATTERN_GREEN     	 ="rgba(0, 128, 0, 1)";
		public static final String PATTERN_RED 	    	 ="rgba(128, 0, 0, 1)";
		public static final String CSS_ATTRIBUTE_COLOR 	 ="color";
		public static final String BULLISH				 ="Bullish Reversal";
		public static final String BULLISH_ALERT		 ="Bullish";
		public static final String BEARISH				 ="Bearish Reversal";
		public static final String KILLCHROME_WIN 		 ="TASKKILL /IM chrome.exe /F";
		public static final String KILLCHROMEDRIVER_WIN	 ="TASKKILL /IM chromedriver.exe /F";
		public static final String KILLCHROME_UNIX 		 ="killall chrome";
		public static final String KILLCHROMEDRIVER_UNIX ="killall chromedriver";
		public static final String SENDER_USERID		 ="aruldineshmcx@gmail.com";
		public static final String SENDER_PASSWORD		 ="m416@GOOGLE";
        public static final String SENDER_HOST_KEY     	 ="mail.smtp.host";
 		public static final String SENDER_HOST_VALUE 	 ="smtp.gmail.com";
 		public static final String SENDER_PORT_KEY		 ="mail.smtp.port";
 		public static final String SENDER_PORT_VALUE	 ="465";
 		public static final String SENDER_AUTH_KEY		 ="mail.smtp.auth";
 		public static final String SENDER_AUTH_VALUE	 ="true";
 		public static final String SENDER_SOCKET_KEY	 ="mail.smtp.socketFactory.port";
 		public static final String SENDER_SOCKET_VALUE	 ="465";
 		public static final String SENDER_CLASS_KEY		 ="mail.smtp.socketFactory.class";
 		public static final String SENDER_CLASS_VALUE	 ="javax.net.ssl.SSLSocketFactory";
   	    public static final String RCVR_USERID 			 ="aruldineshmcx@outlook.com";
        public static final String RCVR_PASSWORD 		 ="m416@OUTLOOK";
        public static final String RCVR_STORE 			 ="imaps";
        public static final String RCVR_IMAP_HOST		 ="imap-mail.outlook.com";
        public static final String RCVR_INBOX 			 = "Inbox";
		public static final String ARUL	  				 ="//*[@id='arul']";
		public static final String OS_WINDOWS   		 ="windows";
		public final static String SYSTEM_OS 			 = System.getProperty("os.name").toLowerCase();
		public static final String REPORT 	     		= "C:\\Application\\Report.txt";
		public static final String VOICE_ACCOUNT_SID = "ACf001227f6022e75a3abac48bc6204f67";
		public static final String VOICE_AUTH_TOKEN = "3060c4d53dd2d8706c656b166888c986";
		public static final String VOICE_TO = "+919688833363";
		public static final String VOICE_FROM = "+916380298498";
		public static final String VOICE_FROM_SL ="+918825486832";
		public static final String VOICE_URI = "http://demo.twilio.com/docs/voice.xml";

	}
