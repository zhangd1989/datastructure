package com.zhangdong.NIO;

public class CreateRollbackSQL {

	public static void main(String[] args) {

		String[] proArray = new String[] { "100", "200", "210", "220", "230", "240", "250", "270", "280", "290", "311",
				"351", "371", "431", "451", "471", "531", "551", "571", "591", "731", "771", "791", "851", "871", "891",
				"898", "931", "951", "971", "991" };

		String[] monthArr = new String[] { "202001", "202002", "202003", "202004", "202005", "202006", "202007",
				"202008", "202009", "202010", "202011", "202012" };

		for (int i = 0; i < proArray.length; i++) {
			for (int j = 0; j < monthArr.length; j++) {
				StringBuffer sqlB = new StringBuffer();
				sqlB.append("CREATE TABLE `t_busi_sensitive_log_" + proArray[i] + "_" + monthArr[j] + "` (\n");
				sqlB.append("  `SENSITIVE_ID` varchar(40) NOT NULL COMMENT '涉敏ID',\n");
				sqlB.append("  `OP_STAFF_ID` varchar(40) DEFAULT NULL COMMENT '操作员工号',\n");
				sqlB.append("  `OP_STAFF_NM` varchar(255) DEFAULT NULL COMMENT '操作员工姓名',\n");
				sqlB.append("  `ORG_BRNCH_ID` varchar(255) DEFAULT NULL COMMENT '组织ID',\n");
				sqlB.append("  `ORG_BRNCH_NM` varchar(255) DEFAULT NULL COMMENT '组织名称',\n");
				sqlB.append("  `TELEPHONE_NO` varchar(20) DEFAULT NULL COMMENT '客户号码',");
				sqlB.append("  `ATTR_CITY_CODE` varchar(10) DEFAULT NULL COMMENT '号码归属地编码',\n");
				sqlB.append("  `OP_PAGE_NM` varchar(100) DEFAULT NULL COMMENT '操作页面名称',\n");
				sqlB.append("  `OP_IP_ADDR` varchar(255) DEFAULT NULL COMMENT '操作员IP地址',\n");
				sqlB.append("  `OP_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',\n");
				sqlB.append(
						"  `CMOS_MODIFY_TIME` datetime(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)  COMMENT '修改时间',\n");
				sqlB.append("  PRIMARY KEY (`SENSITIVE_ID`) USING BTREE,\n");
				sqlB.append("  KEY `idx_cmos_modify_time` (`cmos_modify_time`) \n");
				sqlB.append(") COMMENT='涉敏信息访问日志表';\n");

				System.out.println(sqlB.toString());

			}

			System.out.println();
			System.out.println();
		}

	}

}
