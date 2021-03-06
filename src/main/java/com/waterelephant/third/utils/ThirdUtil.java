package com.waterelephant.third.utils;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

import com.waterelephant.entity.BwOrder;
import com.waterelephant.entity.BwOverdueRecord;
import com.waterelephant.utils.CommUtils;

/**
 * 统一对外接口 - 工具类（code0091）
 * 
 * 
 * Module:
 * 
 * ThirdUtil.java
 * 
 * @author liuDaodao
 * @since JDK 1.8
 * @version 1.0
 * @description: <描述>
 */
public class ThirdUtil {

	// 订单状态映射
	private static Map<String, String> ORDER_STATUS_MAP = new HashMap<>();
	// 审核状态映射
	private static Map<String, String> APPROVE_STATUS_MAP = new HashMap<>();
	// 账单状态映射
	private static Map<String, String> BILL_STATUS_MAP = new HashMap<>();
	// 连连状态码
	private static Map<String, String> LIANLIAN_CODE_MAP = new HashMap<>();
	// 展期利率
	private static Map<String, String> DEFER_RATE_MAP = new HashMap<>();
	static {

	}

	static {
		DEFER_RATE_MAP.put("1", "0.27");
		DEFER_RATE_MAP.put("2", "0.30");
		DEFER_RATE_MAP.put("3", "0.33");

		ORDER_STATUS_MAP.put("9", "170");
		ORDER_STATUS_MAP.put("13", "180");
		ORDER_STATUS_MAP.put("6", "200");
		ORDER_STATUS_MAP.put("7", "110");
		ORDER_STATUS_MAP.put("8", "110");
		ORDER_STATUS_MAP.put("4", "100");
		ORDER_STATUS_MAP.put("11", "100");
		ORDER_STATUS_MAP.put("12", "100");
		ORDER_STATUS_MAP.put("14", "100");
		ORDER_STATUS_MAP.put("5", "100");

		APPROVE_STATUS_MAP.put("7", "40");
		APPROVE_STATUS_MAP.put("8", "40");
		APPROVE_STATUS_MAP.put("4", "10");
		APPROVE_STATUS_MAP.put("11", "10");
		APPROVE_STATUS_MAP.put("12", "10");
		APPROVE_STATUS_MAP.put("14", "10");
		APPROVE_STATUS_MAP.put("9", "10");
		APPROVE_STATUS_MAP.put("5", "10");
		APPROVE_STATUS_MAP.put("6", "10");
		APPROVE_STATUS_MAP.put("13", "10");

		BILL_STATUS_MAP.put("9", "1");
		BILL_STATUS_MAP.put("6", "2");
		BILL_STATUS_MAP.put("13", "3");

		LIANLIAN_CODE_MAP.put("0000", "交易成功");

		LIANLIAN_CODE_MAP.put("1000", "支付授权令牌失效或错误");
		LIANLIAN_CODE_MAP.put("1001", "商户请求签名错误");
		LIANLIAN_CODE_MAP.put("1002", "支付服务超时，请重新支付");
		LIANLIAN_CODE_MAP.put("1003", "正在支付中,请稍后");
		LIANLIAN_CODE_MAP.put("1004", "商户请求参数校验错误");
		LIANLIAN_CODE_MAP.put("1005", "支付处理失败");
		LIANLIAN_CODE_MAP.put("1006", "用户中途取消支付操作");
		LIANLIAN_CODE_MAP.put("1007", "网络链接繁忙");
		LIANLIAN_CODE_MAP.put("1008", "银行卡号无效");
		LIANLIAN_CODE_MAP.put("1009", "暂停商户支付服务，请联系连连银通客服");
		LIANLIAN_CODE_MAP.put("1014", "日累计金额或笔数超限");
		LIANLIAN_CODE_MAP.put("1016", "余额不足");
		LIANLIAN_CODE_MAP.put("1019", "单笔金额超限");
		LIANLIAN_CODE_MAP.put("1100", "无效卡号");
		LIANLIAN_CODE_MAP.put("1101", "卡已挂失");
		LIANLIAN_CODE_MAP.put("1102", "无此发卡方");
		LIANLIAN_CODE_MAP.put("1103", "您的卡已过期或者您输入的有效期不正确");
		LIANLIAN_CODE_MAP.put("1104", "卡密码错误  ");
		LIANLIAN_CODE_MAP.put("1105", "卡号在黑名单中");
		LIANLIAN_CODE_MAP.put("1106", "允许的输入 PIN 次数超限");
		LIANLIAN_CODE_MAP.put("1107", "交易成功");
		LIANLIAN_CODE_MAP.put("1108", "您输入的证件号、姓名或手机号有误");
		LIANLIAN_CODE_MAP.put("1109", "卡号和证件号不符");
		LIANLIAN_CODE_MAP.put("1110", "卡状态异常");
		LIANLIAN_CODE_MAP.put("1111", "交易异常，支付失败");

		LIANLIAN_CODE_MAP.put("1112", "证件号有误");
		LIANLIAN_CODE_MAP.put("1113", "持卡人姓名有误");
		LIANLIAN_CODE_MAP.put("1114", "手机号有误");
		LIANLIAN_CODE_MAP.put("1115", "该卡未预留手机号");
		LIANLIAN_CODE_MAP.put("1200", "用户选择的银行暂不支持，请重新选择其他银行进行支付/签约");
		LIANLIAN_CODE_MAP.put("1900", "短信码校验错误");
		LIANLIAN_CODE_MAP.put("1901", "短信码已失效");
		LIANLIAN_CODE_MAP.put("2004", "签约处理中");
		LIANLIAN_CODE_MAP.put("2005", "原交易已在进行处理，请勿重复提交");
		LIANLIAN_CODE_MAP.put("2006", "交易已过期");
		LIANLIAN_CODE_MAP.put("2007", "交易已支付成功");
		LIANLIAN_CODE_MAP.put("2008", "交易处理中");
		LIANLIAN_CODE_MAP.put("3001", "非法商户");
		LIANLIAN_CODE_MAP.put("3002", "商户无此业务权限");
		LIANLIAN_CODE_MAP.put("3003", "用户签约失败");
		LIANLIAN_CODE_MAP.put("3004", "用户解约失败");
		LIANLIAN_CODE_MAP.put("3005", "暂时不支持该银行卡支付 ");
		LIANLIAN_CODE_MAP.put("3006", "无效的银行卡信息");
		LIANLIAN_CODE_MAP.put("3007", "用户信息查询失败");
		LIANLIAN_CODE_MAP.put("4000", "解约失败，请联系发卡行");
		LIANLIAN_CODE_MAP.put("5001", "卡 bin 校验失败");
		LIANLIAN_CODE_MAP.put("5002", "原始交易不存在");
		LIANLIAN_CODE_MAP.put("5003", "退款金额错误");
		LIANLIAN_CODE_MAP.put("5004", "商户状态异常，无法退款");
		LIANLIAN_CODE_MAP.put("5005", "退款失败，请重试");

		LIANLIAN_CODE_MAP.put("5006", "商户账户余额不足");
		LIANLIAN_CODE_MAP.put("5007", "累计退款金额大于原交易金额");
		LIANLIAN_CODE_MAP.put("5008", "原交易未成功");
		LIANLIAN_CODE_MAP.put("5501", "大额行号查询失败");
		LIANLIAN_CODE_MAP.put("5502", "信用卡不支持提现");
		LIANLIAN_CODE_MAP.put("6001", "卡余额不足");
		LIANLIAN_CODE_MAP.put("6002", "该卡号未成功进行首次验证");
		LIANLIAN_CODE_MAP.put("8000", "用户信息不存在");
		LIANLIAN_CODE_MAP.put("8001", "用户状态异常");
		LIANLIAN_CODE_MAP.put("8888", "交易申请成功,需要再次进行验证");
		LIANLIAN_CODE_MAP.put("8901", "没有签约记录 ");
		LIANLIAN_CODE_MAP.put("8911", "没有风控记录");
		LIANLIAN_CODE_MAP.put("9901", "请求报文非法");
		LIANLIAN_CODE_MAP.put("9902", "请求参数错误");
		LIANLIAN_CODE_MAP.put("9903", "请求参数错误");
		LIANLIAN_CODE_MAP.put("9904", "支付参数和原创建支付单参数不一致");
		LIANLIAN_CODE_MAP.put("9091", "创建支付失败");
		LIANLIAN_CODE_MAP.put("9092", "业务信息非法");
		LIANLIAN_CODE_MAP.put("9093", "无对应的支付单信息");
		LIANLIAN_CODE_MAP.put("9094", "请求银行扣款失败");
		LIANLIAN_CODE_MAP.put("9700", "短信验证码错误");
		LIANLIAN_CODE_MAP.put("9701", "短信验证码和手机不匹配");
		LIANLIAN_CODE_MAP.put("9702", "验证码错误次数超过最大次数,请重新获取进行验证");
		LIANLIAN_CODE_MAP.put("9703", "短信验证码失效,请重新获取");
		LIANLIAN_CODE_MAP.put("9704", "短信发送异常,请稍后重试");
		LIANLIAN_CODE_MAP.put("9902", "接口调用异常");

		LIANLIAN_CODE_MAP.put("9910", "风险等级过高");
		LIANLIAN_CODE_MAP.put("9911", "金额超过指定额度");
		LIANLIAN_CODE_MAP.put("9912", "该卡不支持");
		LIANLIAN_CODE_MAP.put("9913", "该卡已签约成功");
		LIANLIAN_CODE_MAP.put("9970", "银行系统日切处理中");
		LIANLIAN_CODE_MAP.put("9999", "系统错误");
		LIANLIAN_CODE_MAP.put("9990", "银行交易出错");
		LIANLIAN_CODE_MAP.put("9907", "银行编码与卡不一致");
		LIANLIAN_CODE_MAP.put("9000", "银行维护中，请稍后再试");
	}

	public static String convertOrderStatus(Long oriStatus) {
		if (oriStatus == null) {
			return null;
		}

		return ORDER_STATUS_MAP.get(String.valueOf(oriStatus));
	}

	public static String convertApproveStatus(Long oriStatus) {
		if (oriStatus == null) {
			return null;
		}

		return APPROVE_STATUS_MAP.get(String.valueOf(oriStatus));
	}

	public static String convertBillStatus(Long oriStatus) {
		if (oriStatus == null) {
			return null;
		}

		return BILL_STATUS_MAP.get(String.valueOf(oriStatus));
	}

	// 根据rong360的银行code转成平台自己的code
	public static String convertToBankCode(String openBank) {
		String bankCode = "";
		switch (openBank) {
		case "CCB":
			// 建设银行
			bankCode = "0105";
			break;
		case "CEB":
			// 光大银行
			bankCode = "0303";
			break;
		case "PSBC":
			// 邮政银行
			bankCode = "0403";
			break;
		case "HXB":
			// 华夏银行
			bankCode = "0304";
			break;
		case "ABC":
			// 农业银行
			bankCode = "0103";
			break;
		case "BOCOM":
			// 交通银行
			bankCode = "0301";
			break;
		case "COMM":
			// 交通银行
			bankCode = "0301";
			break;
		case "BOC":
			// 中国银行
			bankCode = "0104";
			break;
		case "CITIC":
			// 中信实业银行
			bankCode = "0302";
			break;
		case "SPDB":
			// 上海浦东发展银行
			bankCode = "0310";
			break;
		case "ICBC":
			// 中国工商银行
			bankCode = "0102";
			break;
		case "CIB":
			// 兴业银行
			bankCode = "0309";
			break;
		case "PINGAN":
			// 平安银行股份有限公司
			bankCode = "0307";
			break;
		case "CMB":
			// 招商银行
			bankCode = "0308";
			break;
		case "CMBC":
			// 中国民生银行
			bankCode = "0305";
			break;
		case "GDB":
			// 广东发展银行
			bankCode = "0306";
			break;
		default:
			bankCode = "0000";
			break;
		}
		return bankCode;
	}

	/**
	 * 判断职业类别
	 *
	 * @author GuoKun
	 * @param key
	 * @return
	 * @author GuoKun
	 */
	public static String getWorkType(String key) throws Exception {
		String workPeriod = null;
		if (StringUtils.isBlank(key)) {
			workPeriod = "1年以内";
		} else {
			switch (key) {
			case "1":
				workPeriod = "企业主";
				break;
			case "2":
				workPeriod = "个体户";
				break;
			case "3":
				workPeriod = "工薪族";
				break;
			case "4":
				workPeriod = "学生";
				break;
			case "5":
				workPeriod = "自由职业";
				break;
			default:
				workPeriod = "未知";
				break;
			}
		}

		return workPeriod;
	}

	/**
	 * 工具类 - 创建随机密码（code00961）
	 *
	 * @author GuoKun
	 * @return
	 */
	public static String getRandomPwd() throws Exception {
		char[] r = getChar();
		Random rr = new Random();
		char[] pw = new char[6];
		for (int i = 0; i < pw.length; i++) {
			int num = rr.nextInt(62);
			pw[i] = r[num];
		}
		return new String(pw);
	}

	public static char[] getChar() throws Exception {
		char[] passwordLit = new char[62];
		char fword = 'A';
		char mword = 'a';
		char bword = '0';
		for (int i = 0; i < 62; i++) {
			if (i < 26) {
				passwordLit[i] = fword;
				fword++;
			} else if (i < 52) {
				passwordLit[i] = mword;
				mword++;
			} else {
				passwordLit[i] = bword;
				bword++;
			}
		}
		return passwordLit;
	}

	/**
	 * 工具类 - 计算年龄（code0091）
	 *
	 * @author GuoKun
	 * @param idCard
	 * @return
	 */
	public static int getAgeByIdCard(String idCard) throws Exception {
		Calendar c = Calendar.getInstance();
		int age = 0;
		int year = c.get(Calendar.YEAR);
		String ageNum = idCard.substring(6, 10);
		age = year - Integer.parseInt(ageNum);

		return age;
	}

	/**
	 * 工具类 - 判断性别（code0091）
	 *
	 * @author GuoKun
	 * @param idCard
	 * @return
	 */
	public static int getSexByIdCard(String idCard) throws Exception {
		int sex = 0;
		String sexNum = idCard.substring(idCard.length() - 2, idCard.length() - 1);
		if ((Integer.parseInt(sexNum)) % 2 == 0) {
			sex = 0;
		} else {
			sex = 1;
		}
		return sex;
	}

	/**
	 * 判断工作年限
	 *
	 * @author GuoKun
	 * @param key
	 * @return
	 */
	public static String getWorkPeriod(String key) throws Exception {
		String workPeriod = null;
		if (StringUtils.isBlank(key)) {
			workPeriod = "1年以内";
		} else {
			switch (key) {
			case "1":
				workPeriod = "0-5个月";
				break;
			case "2":
				workPeriod = "6-11个月";
				break;
			case "3":
				workPeriod = "1-3年";
				break;
			case "4":
				workPeriod = "3-5年";
				break;
			case "5":
				workPeriod = "7年以上";
				break;
			default:
				workPeriod = "1年以内";
				break;
			}
		}

		return workPeriod;
	}

	/**
	 * 工具类 - 短信编辑（code0091）
	 *
	 * @author GuoKun
	 * @param pwd
	 * @return
	 */
	public static String getMsg(String pwd) throws Exception {
		String pattern = "尊敬的用户您好，恭喜您成功注册，您的登录密码为：{0}，您还可以登录   t.cn/Rj5Q1FU  查看最新的借款进度哦！";
		String msg = MessageFormat.format(pattern, new Object[] { pwd });
		return msg;
	}

	/**
	 * 
	 * 展期的各项费用计算
	 * 
	 * @param bwOrder
	 * @param overdueRecord
	 * @param type
	 * @param rolloverNumber
	 * @return
	 */
	public static Double getDeferFee(BwOrder bwOrder, BwOverdueRecord overdueRecord, String type, int rolloverNumber) {
		BigDecimal credit = new BigDecimal(bwOrder.getCreditLimit());
		BigDecimal manageFee = new BigDecimal(0);
		if ("manage_fee".equals(type)) {
			return manageFee.doubleValue();
		}
		BigDecimal interest = credit.multiply(new BigDecimal(DEFER_RATE_MAP.get(String.valueOf(rolloverNumber))));
		if ("interest".equals(type)) {
			return interest.doubleValue();
		}
		BigDecimal overdueFee = CommUtils.isNull(overdueRecord) ? new BigDecimal(0)
				: new BigDecimal(overdueRecord.getOverdueAccrualMoney());
		if ("overdue_fee".equals(type)) {
			return overdueFee.doubleValue();
		}
		BigDecimal otherFee = new BigDecimal(0);
		if ("other_fee".equals(type)) {
			return otherFee.doubleValue();
		}
		BigDecimal defeAmount = manageFee.add(interest).add(overdueFee).add(otherFee);
		if ("defer_amount".equals(type)) {
			return defeAmount.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		}

		BigDecimal afterManageFee = new BigDecimal(0);
		if ("after_manage_fee".equals(type)) {
			return afterManageFee.doubleValue();
		}
		BigDecimal afterInterest = new BigDecimal(0);
		if ("after_interest".equals(type)) {
			return afterInterest.doubleValue();
		}
		BigDecimal afterOtherFee = new BigDecimal(0);
		if ("after_other_fee".equals(type)) {
			return afterOtherFee.doubleValue();
		}
		BigDecimal afterDeferAmount = credit.add(afterInterest).add(afterManageFee).add(afterOtherFee);
		if ("after_defer_amount".equals(type)) {
			return afterDeferAmount.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		return 0D;
	}

	public static String convertLian2Msg(String code) {
		if (StringUtils.isBlank(code)) {
			return "系统异常";
		}
		return LIANLIAN_CODE_MAP.get(code);
	}
}
