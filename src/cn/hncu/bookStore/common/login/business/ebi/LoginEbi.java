package cn.hncu.bookStore.common.login.business.ebi;

public interface LoginEbi {
	/**
	 * ���ܣ������ж�������û��������������ݿ��е������Ƿ�ƥ��
	 * 
	 * @param userName �û���
	 * @param pwd ��Ӧ�û�������
	 * 
	 * @return ���ƥ���򷵻�null��
	 * 			��ƥ��ͷ��ض�Ӧ�Ĵ�����Ϣ�������ڴ��û�����������벻��ȷ
	 */
	public String login(String userName,String pwd);
}
