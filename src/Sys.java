import java.io.*;
;
/**
 * �Զ����ϵͳ�࣬�������õķ����������ȡ�
 * @author ���������Ȩ
 * @version 2006��3��27��
 */
public class Sys {

        Queue Q = new Queue();	         //���ñ���������Q
        int idcounter = 1;	                     //���ñ���������IDֵ�ӷ���

        /**
         * ���뷽�����Ӽ��̶���һ���ַ��������ظ��ַ���
         * @return ������ַ���
         * @throws IOException
         */
        public String readStr() throws IOException {
                BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
                return sb.readLine();
        }

        /**
         * ���뷽�����Ӽ��̶���һ���������������������
         * @return ���������
         * @throws IOException
         */
        public int readInt() throws IOException {
                String s = readStr();
                return Integer.parseInt(s);
        }
        /**
         * ����������������Aho-Corasick�㷨�Ľ��
         * ������Ǳ����е�Q���У����б����˼�¼Aho-Corasick��������Ϣ��
           Record�����I��������෽��ACsearch()����
         */

        public int[][] out() {
                       Position p;          //Position��ı��������ڶ�ȡ�����λ��
                       Record I;            //Record��ı��������ڶ�ȡ��¼����Ϣ
                       int i=0;               //����i�û�ѭ������
                       int[][] all=new int[2][Q.size()+1];    //#############�д��޸�############################33

                       while(Q.size()!=0) {                 //�����в���ʱ��ѭ��
                               I = Q.popI();                    //��ȡ���׵ļ�¼
                               p = (Position)I.name.get(0); //��ȡ��ģʽ�š�
                               all[0][i]=p.position;
                               all[1][i]=I.site;
                               i++;
                       }
                       all[0][i]=0;
                       all[1][i]=0;
                       return(all);
               }

        /**
         * ���������������ַ���P��ÿ�λ��ֵ���ʼλ�úͳ��ȣ��ڹؼ�����trie��
           ���������������ݹ�ؽ�����Ӧ�ķ�֧��
         * @param P - �Ӽ��̶�����ַ���
         * @param i - ׼��������Ӵ�����ʼλ�ã���ĳһ�λ����У�
         * @param r - δ�����Ӵ��ĳ���
         * @param trie - �Ѿ����ֽ����Ĺؼ�����������������ַ��
         * @param pid - ��ʾ�������ڴ������P�е��ĶΣ���Ŵ�1��ʼ���ò���
                        ����Ϊ��������㣬��ʵֻҪ���ֽ��������κ�ʱ�򶼿�
                        �Լ��������
         */
        public void build(String P, int i, int r, int pid, Nodea trie) {
                if(r>0){           //�������û�ж�����ַ�����ִ����������
                        Nodea son = trie.searchSon(P.charAt(i)); /*��trie��
                                              �����в����Ƿ���P��λ��i���ַ�����*/
                        if(son == null) {			         //���û�еĻ�
                                son = new Nodea(P.charAt(i));    /*����λ�ú��ַ�
                                                                       ����һ���¶���
                                                                       ���*/
           /*ע�⣬�����������ID��صĻ�����ɾ����*/
                                son.ID = idcounter;            //�½���IDΪid
                                idcounter++;           //Ȼ��id+1�Բ�����һ��ID��

                                trie.addSon(son);     //���½�����trie�Ķ��ӵ���
                        }
                        if(r==1) {	         //����������ε����һ���ַ�����
                                son.setPos(pid);	//�ڸý���б��汾�εĶκš�
                        }
                        build(P, i+1, r-1, pid, son); /*��son��Ϊ������������
                                                  ������P����һ��λ�õ��ַ���
                                                  ��������δ���Ӵ�����-1*/

                }
        }

        /**
         * ����ʧЧ���ӵķ��������ݶ���Q�е����ݺ�����trie��εؽ�����ÿ����
           ���ʧЧ����
         * @param trie - �ؼ�������������ַ��
         */
        public void failLink(Nodea trie) {
                int i;                      //����i�����Ժ��ѭ������
                int level = 1;              /*����level���ڼ������Ρ�
                                                  ͬʱ��������Զ���ڼ���������
                                                  ��Ρ������ǵ�һ�㡣*/
                Q.clear();	                //ϵͳ�������㱸��

                Nodea son;					//����һ����������͵ı���son
                for(i=0;i<trie.sons.size();i++) {   //��ʼ����һ����
                        son = (Nodea)trie.sons.get(i);  /*ÿһ����㣬��
                                                              ���Ķ���*/
                        son.nv = trie;	         //��ʧЧ����ָ������
                        son.level = level;       //����Ϊ1����Ϊ�ǵ�һ�㣩
                        Q.insert(son);           //���ö��Ӳ�����С�
                }
                level++;                     //���level��1�����á�

                Nodea Nodea = new Nodea();		 //�½�һ�������
                Nodea.v = 'L';                /*�ý����ַ�Ϊ��L������
                                               ���ֲ������ʾ����һ�㡣
                                                    �÷��������ж�ÿһ��
                                                    �����Ƿ�����Ա����
                                                level��ֵ��*/
                Q.insert(Nodea);              //���ýڵ������С�
                Nodea w;                      //����һ����������͵ı���w

                while(Q.size()!=0) {         //�����в�Ϊ��ʱ
                        Nodea = Q.popfront();     //�������еĶ��׽��
                        if(Nodea.v != 'L') {      //����ý�㲻�ǡ��ֲ������
                                for(i=0;i<Nodea.sons.size();i++) {//�Ըý���
                                        son = (Nodea)Nodea.sons.get(i);/*ÿһ������
                                                                         �������²���*/
                                        w = Nodea.nv;     /*��������Ӹ��ף������׽�㣩
                                                           ��ʧЧ����*/
/*��������������ע�ͣ���������Ӳ���������û�б궨�ö����ַ��Ķ��ӣ���*/
                                        while (w!=trie&&w.searchSon(son.v)==null)
                                                w=w.nv;      //���ſ����ʧЧ���ӵ�ʧЧ����
/*���Կ�����ѭ��ֹͣ������ʧЧ����ָ������������ڱ궨�ö����ַ��Ķ���*/
                                        if(w.searchSon(son.v)!=null) {/*���w����
                                                                   �궨��son�ַ��Ķ���*/
                                                son.nv = w.searchSon(son.v); /*��son
                                                                         ��ʧЧ����ָ��궨��
                                                                      son�ַ���w�Ķ���*/
                                        }
                                        else         //���򣬼�w�Ķ����в����������ı궨
                                                son.nv = trie; //���son��ʧЧ����ָ������
/*����������if����ע�ͣ������son����ÿ���ֶεĽ�����㣬����ʧЧ��������
   ��ָ��ĳ��Pi��ĩ�˽�㣨��һ��ֱ��ָ�򣩣����son��positions�в���-1��
   ��ʾͨ�����son�����ʧЧ���ӵĻ������ܹ��ҵ�һ������ĳ��ģʽ�Ľ�㣬����
   ����ڵ��ģʽ��β�ڵ��Ƿ�����Ҷ��*/
                                        if(son.positions.size()==0&&son.nv.positions.size()!=0)
                                                son.setPos(-1);

                                        son.level = level; //��levelֵ���浽son��ȥ��
                                        Q.insert(son);	  /*���ö��ӱ����ڶ����У��Ա�
                                                               ��һ�����Ĳ�α���*/
                                }
                        }
                        else { //���򣬼����е��׽���ǡ��ֲ����L�Ļ���
                                if(Q.size() != 0) { /*�������Ƿ�Ϊ�գ����յ����Ķ���
                                                         �Ƿ������һ����㣬�������*/
                                        level++;		//level��1�����ñ�����һ����
                                        Q.insert(Nodea); /*������С��ֲ�����Ľ���ٲ嵽
                                                             ��β��������βǰ�Ķ���ͬ�Բ�
                                                             ������㣬��Ŷ��Ǹղż�1��
                                                             ��level*/
                                }
                        }
                }
        }

        /**
         * Aho-Corasick�������������ݹؼ�����trie���ַ���T���д���
         * @param T - ������ַ���
         * @param trie - �����Ĺؼ�����
         */
        public void ACsearch(String T, Nodea trie) {
                int i;                                //����i����ѭ������
                Position p;                   //Position���p�����ݴ�λ��
                Nodea Nodea = trie;            //�����Nodea�ȵ�������trie
                Nodea son;                    //��������son�Ժ��á�
                Record I;                    //Record���ͱ������ڱ�����
                Q.clear();                   //�������㱸��
                for (i=0; i<T.length(); i++) { //����T�е�ÿһ���ַ�T(i)
                        son = Nodea.searchSon(T.charAt(i)); /*����Nodea�Ķ���
                                                             ����û�б궨T(i)��*/
                        while(son  == null) {      //���û�еĻ�
                                if(Nodea == trie)       //���Nodea��������
                                        break;             //��������
                                Nodea = Nodea.nv;        //����Nodea��������ʧЧ����
                                son = Nodea.searchSon(T.charAt(i)); /*����������
                                                                    ������Ѱ��T(i)*/
                        }

                        if(Nodea == trie&&son == null) /*���Nodea������������
                                                   �ղ������ˣ�����son�Ż�Ϊ�գ�*/
                                continue;         /*��������ѭ����������T����һ��
                                                   �ַ�*/
                        Nodea =  son;          //Nodea�������Ǹ��궨T(i)�Ķ���
                        if(Nodea.positions.size()!= 0) { /*����ý����ܴ���
                                                               һ��ģʽPi*/
                                p = (Position)Nodea.positions.get(0); /*���
                                                                  positions��
                                                                       ��λ���ж����
                                                                       ����Ƿ�ֱ�Ӵ�
                                                                       ����ĳ��ģʽ*/
                                if(p.position != -1) { /*���positions����λ����
                                                       -1������ζ�Ÿý��ֱ�Ӵ�����
                                                           ĳ��ģʽPi�Ļ�*/
/*��������������ע�ͣ����ý���������ģʽ��T�е���ʼλ�ü��㲢��¼��I�У�
   ͬʱ���ý���������ģʽ��Ҳ��¼������*/
                                        I = new Record(i+2-Nodea.level, Nodea.positions);
                                        Q.insert(I);             //��I�����ڶ����С�
                                }
                                son = Nodea.nv;            //������Nodea��ʧЧ����
/*��������������ע�ͣ���������Ӳ�Ϊ�ն��Ҳ�ָ����ڵ㣬���ҿ��ܴ�����ĳ��
   ģʽ�Ļ��������ѭ������ѭ���ҵ������������ӵ������п���ģʽ*/
                                while(son != null && son != trie&&son.positions.size()!=0) {
                                        p = (Position)son.positions.get(0);/*����
                                                                  ���ӵ�positions��λ*/
                                        if(p.position != -1) { /*�����λ����-1������
                                                             ʧЧ����ֱ�Ӵ�����ĳ��ģʽ����*/
/*��������������ע�ͣ����ý���������ģʽ��T�е���ʼλ�ü��㲢��¼��I�У�
   ͬʱ���ý���������ģʽ��Ҳ��¼������*/
                                                I = new Record(i+2-son.level, son.positions);
                                                Q.insert(I);     //��I�����ڶ����С�
                                                son = son.nv;    //����������ʧЧ����
                                        }
                                }
                        }
                }
        }
}
