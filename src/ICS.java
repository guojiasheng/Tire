

/**
 * <p>Title: 星比对与改进的星比对算法</p>
 * <p>Description: 用来进行多序列比对</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author 邹权
 * @version 2007年1月9日
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



      boolean improved = true; //如果improved为true，则使用改进的星比对算法；否则使用原始的星比对算法
      if(args.length==2&&args[1].equals("0"))
        improved = false;
      else if(args.length==2&&args[1].equals("1"))
        improved = true;
      else if(args.length!=1){
        illustrate();
        System.exit(0);
      }
      MSA program = new MSA("D://gjs//xl//test//data//small//1.fasta");
      if (improved == true) //使用改进后的星比对算法
        program.runforimproved();
      else if (improved == false) //使用原始星比对算法
        program.runforold();

      //long t2 = System.currentTimeMillis();
      //System.out.print("程序运行时间是");
      //System.out.print(t2 - t1);
      //System.out.println("毫秒");
    }
    catch(Exception ex){
      System.out.println(ex.getMessage());
    }
        }
}
