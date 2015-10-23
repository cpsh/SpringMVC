package com.cpsh.model.rmi;

import java.io.Serializable;

public class MMSubmitRes implements Serializable {

public static int SUCCESS = 2000;
public static int QUEUE_IS_FULL = 2001;
public static int VALIDATION_ERROR = 2002;
public static int AUTHORITY_FAILED = 2003;

public static String SUCCESS_TEXT = "�ɹ�";
public static String QUEUE_IS_FULL_TEXT = "���Ͷ����������Ժ�����";
public static String VALIDATION_ERROR_TEXT = "�����Ϣ����Ϲ淶��ʽ";
public static String AUTHORITY_FAILED_TEXT = "��֤ʧ�ܣ�����д��Ч���û��������";

	
private String transactionID;
private int statusCode;
private String statusText;
private String messageID;
/**
 * @return Returns the messageID.
 */
public String getMessageID() {
	return messageID;
}
/**
 * @param messageID The messageID to set.
 */
public void setMessageID(String messageID) {
	this.messageID = messageID;
}
/**
 * @return Returns the statusCode.
 */
public int getStatusCode() {
	return statusCode;
}
/**
 * @param statusCode The statusCode to set.
 */
public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}
/**
 * @return Returns the statusText.
 */
public String getStatusText() {
	return statusText;
}
/**
 * @param statusText The statusText to set.
 */
public void setStatusText(String statusText) {
	this.statusText = statusText;
}
/**
 * @return Returns the transactionID.
 */
public String getTransactionID() {
	return transactionID;
}
/**
 * @param transactionID The transactionID to set.
 */
public void setTransactionID(String transactionID) {
	this.transactionID = transactionID;
}

public String toString(){
	return "transactionID:"+transactionID+",messageID="+messageID+",statusCode="+statusCode+",statusText="+statusText;
}

}
