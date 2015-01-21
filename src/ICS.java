

/**
 * <p>Title: �Ǳȶ���Ľ����Ǳȶ��㷨</p>
 * <p>Description: �������ж����бȶ�</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author ��Ȩ
 * @version 2007��1��9��
 */

public class ICS {
  public static void illustrate(){
    System.out.println("The command should be");
    System.out.println("  Improvecenterstar inputfile [0/1]");
    System.out.println("    -0: center star method for multiple sequence alignment");
    System.out.println("    -1: improved center star method for multiple sequence alignment(default)");
  }
  public static void main(String args[]){
    try{
      //long t1 = System.currentTimeMillis();



      boolean improved = true; //���improvedΪtrue����ʹ�øĽ����Ǳȶ��㷨������ʹ��ԭʼ���Ǳȶ��㷨
      if(args.length==2&&args[1].equals("0"))
        improved = false;
      else if(args.length==2&&args[1].equals("1"))
        improved = true;
      else if(args.length!=1){
        illustrate();
        System.exit(0);
      }
      MSA program = new MSA("D://gjs//xl//test//data//small//1.fasta");
      if (improved == true) //ʹ�øĽ�����Ǳȶ��㷨
        program.runforimproved();
      else if (improved == false) //ʹ��ԭʼ�Ǳȶ��㷨
        program.runforold();

      //long t2 = System.currentTimeMillis();
      //System.out.print("��������ʱ����");
      //System.out.print(t2 - t1);
      //System.out.println("����");
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
        }
}
