import java.util.ArrayList;
/**
 * ��¼���ͣ����ڱ���Aho-Corasick�㷨����ʱ�ҵ���ƥ����Ϣ��
 * @author �����
 * @version 2006��3��27��
 */
public class Record {

        int site;	/*���ڼ�¼��ƥ��ģʽ��T�г��ֵ���ʼλ�á���Ϊ
                      Aho-Corasick�㷨�����ÿ��λ�õģ����ÿ����¼ֻ
                        ����һ��λ�á�*/
        ArrayList name = new ArrayList(); /*���ڼ�¼�ü�¼�����λ��
                                                 ����Ӧ������ģʽ*/
        /*��ע�⣺
         *���������Ϣ����Կ���������ÿ����¼���Զ�Ӧ���ģʽ����ÿ����¼ȴ
          ֻ����һ��λ�á���˻���ڶ����¼��λ�ã���Ӧһ��ģʽ�������*/

        /**
         * ��¼�Ĺ��췽��������ƥ���ַ�����T�е���ʼλ�úͶ�Ӧ������ģʽ����
           һ���¼�¼��
         * @param st - ����ƥ���ģʽ����T�е���ʼλ�á�
         * @param pos - ����ƥ�������ģʽ��P�еı�š�
         */
        Record (int st, ArrayList pos) {
                site = st;			//��site����st��
                Position p;         //��һ��Position����p������pos��
                for(int i =0; i<pos.size(); i++) { //����pos�е�ÿһ��
                        p = (Position) pos.get(i); //Position�����
                        name.add(p);               //�����������ӵ�name��
                }
        }
}
