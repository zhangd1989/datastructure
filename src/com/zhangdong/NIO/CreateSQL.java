package com.zhangdong.NIO;

public class CreateSQL {

	public static void main(String[] args) {

		String[] proArray = new String[] { "100", "200", "210", "220", "230", "240", "250", "270", "280", "290", "311",
				"351", "371", "431", "451", "471", "531", "551", "571", "591", "731", "771", "791", "851", "871", "891",
				"898", "931", "951", "971", "991" };

		String[] monthArr = new String[] { "202001", "202002", "202003", "202004", "202005", "202006", "202007",
				"202008", "202009", "202010", "202011", "202012" };

		for (int i = 0; i < proArray.length; i++) {
			for (int j = 0; j < monthArr.length; j++) {
				StringBuffer sqlB = new StringBuffer();
				sqlB.append("alter table t_busi_sensitive_log_" + proArray[i] + "_" + monthArr[j] + 
						" rename to zxdba_bak.20191220_t_busi_sensitive_log_"+ proArray[i] + "_" + monthArr[j]+";");

				System.out.println(sqlB.toString());

			}

			System.out.println();
			System.out.println();
		}

	}

}
