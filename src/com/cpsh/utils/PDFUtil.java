package com.cpsh.utils;

import java.awt.Dimension;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;

/**
 * 
 * 项目名称: 51auto<br/>
 * 类名称: com.jiuxing.utils.PDFUtil<br/>
 * 创建人: zhang hao<br/>
 * 创建时间: 2013-9-18 下午6:27:42<br/>
 *
 * 类描述：PDF转换工具<br/>
 * 类用法：<br/>
 *
 */
public class PDFUtil {
	// A4
	protected static Dimension format = PD4Constants.A4;
	// 页边距
	protected static int topValue = 1;
	protected static int leftValue = 1;
	protected static int rightValue = 1;
	protected static int bottomValue = 1;
	// 页边距单位 mm
	protected static String unitsValue = "mm";
	// 宽度
	protected static int userSpaceWidth = 1130;

	/**
	 * 方法名称: PDFUtil.convert2PDF<br/>
	 * 创建人: zhang hao<br/>
	 * 创建时间: 2013-9-12 下午4:50:22<br/>
	 *
	 * 方法描述：将url对应页面转换为pdf文件<br/>
	 * 用法：TODO<br/>
	 * 
	 * @return void -- <br/>
	 *
	 * @param urlstring url,要有http://，没有的会自动补充
	 * @param output pdf文件名
	 * @throws IOException<br/>
	 *
	 */
	public static void convert2PDF(String urlstring, File output) throws IOException {
		if (urlstring.length() > 0) {
			if (!urlstring.startsWith("http://")
					&& !urlstring.startsWith("file:")) {
				urlstring = "http://" + urlstring;
			}

			java.io.FileOutputStream fos = new java.io.FileOutputStream(output);

			PD4ML pd4ml = new PD4ML();

			try {
				pd4ml.setPageSize(pd4ml.changePageOrientation(format));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//设置页边距
			if (unitsValue.equals("mm")) {
				pd4ml.setPageInsetsMM(new Insets(topValue, leftValue,
						bottomValue, rightValue));
			} else {
			 pd4ml.setPageInsets(new Insets(1, 1, 1, 1));
			}
			// 字体,classes下有fonts文件夹 且有
			pd4ml.useTTF("java:fonts", true);
			pd4ml.setDefaultTTFs("KaiTi_GB2312", "KaiTi_GB2312", "KaiTi_GB2312");
			pd4ml.enableDebugInfo();
			pd4ml.setHtmlWidth(userSpaceWidth);
			pd4ml.render(urlstring, fos);
		}
	}
}
