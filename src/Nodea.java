import java.util.ArrayList;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Nodea {
  /*����������ִ�����ͬǰ׺����Ϊ��ǰ׺�еķ�����������Ψһ��λ�ã�����
           һ��ArrayList��positions����¼����ͬ������P�������ֵ�λ��*/
        ArrayList positions = new ArrayList();
        char v;	                        //���������ķ���
        Nodea nv;	                //ʧЧ�����иý��Ķ�Ӧ��㣨��ַ��
        ArrayList sons = new ArrayList();	/*������¼�ýڵ����е�
                                                    ���ӽ�㣨��ַ��*/
        int ID;	  /*Ϊ�˷�����Ϊ�жϹؼ������Ľ����Ƿ���ȷ��Ϊÿ���������
                      һ��ID�����жϽ��֮��Ĺ�ϵ��ע���Ժ����ɾ�����Խ��
                      ����Ӱ��*/
        int level;	/*������ڵĲ�⡣Ϊ����AC�㷨���ܵõ�Pi��T�еĿ�ʼλ��
                        ����������λ���õ�ǰT��λ�úż�ȥ��ǰ���Ĳ�μ��ɵ�
                        ����*/

        /**
         *���췽������ʼ��һ������㣬nvָ�����㱾��
         */
        Nodea(){
                v = 'r';                         //���ķ����Ǹ�
                nv = this;                       //����ʧЧ������������
                level = 0;
        }

        /**
         * ���췽�������ݵ�ǰ��������ʼ��һ����㣨ͨ���Ƕ��ӣ�
         * @param c - ����
         */
        Nodea(char c) {
                v = c;	                      //����ķ���Ϊc
        }

        /**
         * �÷�������ͬǰ׺�еķ�����P�г��ֵ���λ�ñ�������
         * @param posit - ������P�е�λ��
         */
        public void setPos(int posit) {
                Position posrec = new Position(); //�½�һ��Position����
                posrec.position = posit;	//�ö��������Ϊ����posit
                positions.add(posrec);	//�����������뵽positions�С�
        }

        /**
         * �÷���Ϊ������һ���¶���
         * @param newSon - �¶���
         */
        public void addSon(Nodea newSon) {
                sons.add(newSon);	          //add������ArrayList�ṩ
        }

        /**
         * �÷�����������ķ����ڽ������ж����в�ѯ�Ƿ��Ѿ��д���÷��ŵĶ�
         ���ӳ��֡����򷵻ظö��ӣ���ַ�������򷵻ؿ�
         * @param c - Ҫ��ѯ�ķ���
         * @return son - ��ѯ������鵽�򷵻ظö��ӣ�����Ϊ��
         */
        public Nodea searchSon(char c) {
                Nodea son = null;
                for(int i=0;i<sons.size();i++){
                        son = (Nodea)sons.get(i);	//��ѯÿһ������
                        if(son.v==c)				//������ӵ��ַ���cһ��
                                break;					//�ж�ѭ��
                        else
                                son = null;				//�������Ϊ��
                }
                return son;						//���ز�ѯ���
        }

}
