import java.util.ArrayList;
/**
 * �������ͣ��������в�α���ʱ������ʹ��Ľ�㣨��ַ����
 * @author �����
 * @version 2006��3��27��
 */
public class Queue {

        ArrayList Q = new ArrayList(); 	 //��������ʼ��һ��ArrayList

        /**
         * ���еĲ��뷽�������ڶ�β����һ�������
         * @param node - �����
         */
        public void insert(Nodea node) {
                Q.add(node);                  //add��ArrayList�ṩ��
        }

        /**
         * ���еĲ��뷽�������ڶ�β����һ����¼AC�㷨������Ϣ�Ľ��
         * @param I - Record���͵Ľ��
         */
        public void insert(Record I) {
                Q.add(I);
        }

        /**
         * ���еĵ������������Ӷ��׶�ȡ��ɾ��һ�������
         * @return ���׵������
         */
        public Nodea popfront() {
                Nodea node;		      //��һ����������͵ı���node
                if(Q.size()==0)		  //size��ArrayList�ṩ��.���QΪ����
                        node = null;	          //nodeΪ��ֵ
                else {						  //����
                        node = (Nodea)Q.get(0);	  //node���ڶ��׽ڵ�
                        Q.remove(0);	          //�������׽��ɾ����
                }
                return node;                  //����node
        }

        /**
         * ���еĵ����������Ӷ��׶�ȡ��ɾ��һ��Record���͵Ľڵ㡣
         * @return ���׵�Record�����
         */
        public Record popI() {
                Record I;				//��һ��Record���͵ı���I
        /*��Ϊ����ʱ�Ѿ���֤���в�Ϊ�գ����������Ͳ������ж�ֱ�Ӵ�����*/
                I = (Record)Q.get(0);	//I���ڶ��׽��
                Q.remove(0);            //�����׽ڵ�ɾ��
                return I;               //����I
        }

        /**
         * ���еĳ��ȷ���������ArrayList�ṩ��size()�������ض��г���
         * @return ���г���
         */
        public int size() {
                return Q.size();
        }

        /**
         * ���е��������������ArrayList�ṩ��clear()������ն���
         */
        public void clear() {
                Q.clear();
        }
}
