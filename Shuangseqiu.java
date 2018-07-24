import java.util.Random;
import java.util.Scanner;

public class Shuangseqiu{
	
	static void menu(){
		System.out.println("=============欢迎来到双色球彩票系统=============\n");
		System.out.println("\t\t1. 购买彩票"); 
		System.out.println("\t\t2. 查看开奖(再次购买上一次的号码)");
		System.out.println("\t\t3. 退出");
	}
	public static int selectNum() {
		Scanner input = new Scanner(System.in);
		System.out.println("每注2元，请输入要购买的注数： ");
		int in = input.nextInt();
		return in;
	}
	
    public static void main(String[] args) {
        int[] sysRedBall = new int[6];//系统生成的红球
        int sysBlueBall = 0;//系统生成的蓝球；
        int[] userRedBall = new int[6];//用户选择的红球
        int userBlueBall = 0;//用户选择的蓝球
        int redCount=0;//选中的红球个数
        int blueCount=0;//选中的蓝球个数
        Random r = new Random();
        int[] redBall = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
                16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
        int index = 0;
        
        while(true) {
        menu();
		Scanner sc = new Scanner(System.in);
		int mainChoose = sc.nextInt();

		if(mainChoose == 1) {
        //用户选号
			System.out.println("请选择红球号码：（1-33）");
			Scanner in = new Scanner(System.in);
			for(int i=0;i<userRedBall.length;i++){
				userRedBall[i] = in.nextInt();
			}
			System.out.println("请选择蓝球号码：（1-16）");
			userBlueBall = in.nextInt();
			selectNum();
			System.out.println("您购买了"+selectNum()+"注！\t合计: "+2*selectNum()+"元！");
		}
		

        //生成系统号码
        for(int i=0;i<sysRedBall.length;i++){
            while(true){
                index = r.nextInt(33);
                if(redBall[index] != -1){
                    sysRedBall[i] = redBall[index];
                    redBall[index] = -1;
                    break;
                }
            }
        }
        sysBlueBall = r.nextInt(16)+1;
        
        	for(int i=0;i<sysRedBall.length-1;i++){
        		for(int j=0;j<sysRedBall.length-1-i;j++){
        			if(sysRedBall[j]>sysRedBall[j+1]){
        				int temp = sysRedBall[j];
        				sysRedBall[j] = sysRedBall[j+1];
        				sysRedBall[j+1] = temp;
        			}
        		}
        	}
        	
            if(mainChoose == 2) {
                //输出结果
        	System.out.print("本期红球号码为：");
        	for(int i=0;i<sysRedBall.length;i++){
        		System.out.print(sysRedBall[i]+" ");
        	}
        	System.out.println();

        	System.out.print("本期蓝球号码为：");
        	System.out.println(sysBlueBall);

        	System.out.print("您选择的红球号码为：");
        	for(int i=0;i<userRedBall.length-1;i++){
        		for(int j=0;j<userRedBall.length-1-i;j++){
        			if(userRedBall[j]>userRedBall[j+1]){
        				int temp = userRedBall[j];
        				userRedBall[j] = userRedBall[j+1];
        				userRedBall[j+1] = temp;
        			}
        		}
        	}
        	for(int i=0;i<userRedBall.length;i++){
        		System.out.print(userRedBall[i]+" ");
        	}
        	System.out.println();
        	System.out.println("您选择的蓝球号码为："+userBlueBall);

        	//验证是否中奖
        	for(int i = 0;i<sysRedBall.length;i++){
        		for(int j=0;j<userRedBall.length;j++){
        			if(sysRedBall[i]==userRedBall[j]){
        				redCount++; 
        				break;
        			}
        		}	
        	}
        	if(sysBlueBall == userBlueBall){
        		blueCount++;
        	}
        
        	if(redCount == 6 && blueCount == 1){
        		System.out.println("恭喜你，中了一等奖，奖金"+selectNum()*5000000+"元\n");
        	}else if(redCount == 6 && blueCount == 0){
        		System.out.println("恭喜你，中了二等奖，奖金"+selectNum()*10000+"元\n");
        	}else if(redCount == 5 && blueCount == 1){
        		System.out.println("恭喜你，中了三等奖，奖金"+selectNum()*3000+"元\n");
        	}else if((redCount ==5)||(redCount == 4 && blueCount == 1)){
        		System.out.println("恭喜你，中了四等奖，奖金"+selectNum()*200+"元\n");
        	}else if(redCount == 4 || (redCount == 3 && blueCount == 1)){
        		System.out.println("恭喜你，中了五等奖，奖金"+selectNum()*10+"元\n");
        	}else if(blueCount ==1){
        		System.out.println("恭喜你，中了六等奖，奖金"+selectNum()*5+"元\n");
        	}else{
        		System.out.println("很遗憾，这次没有中奖~\n");
        	}
        	
        	System.out.println("中奖规则----\n一等奖：投注号码与当期开奖号码全部相同（顺序不限，下同），即中奖； \r\n" + 
        			"二等奖：投注号码与当期开奖号码中的6个红色球号码相同，即中奖； \r\n" + 
        			"三等奖：投注号码与当期开奖号码中的任意5个红色球号码和1个蓝色球号码相同，即中奖； \r\n" + 
        			"四等奖：投注号码与当期开奖号码中的任意5个红色球号码相同，或与任意4个红色球号码和1个蓝色球号码相同，即中奖； \r\n" + 
        			"五等奖：投注号码与当期开奖号码中的任意4个红色球号码相同，或与任意3个红色球号码和1个蓝色球号码相同，即中奖； \r\n" + 
        			"六等奖：投注号码与当期开奖号码中的1个蓝色球号码相同，即中奖。\n");
        	redCount = 0;
        	blueCount = 0;
        }
        
        if(mainChoose == 3) {
        	break;
        }
        }
    }
}