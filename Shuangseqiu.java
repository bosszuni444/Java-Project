import java.util.Random;
import java.util.Scanner;

public class Shuangseqiu{
	
	static void menu(){
		System.out.println("=============��ӭ����˫ɫ���Ʊϵͳ=============\n");
		System.out.println("\t\t1. �����Ʊ"); 
		System.out.println("\t\t2. �鿴����(�ٴι�����һ�εĺ���)");
		System.out.println("\t\t3. �˳�");
	}
	public static int selectNum() {
		Scanner input = new Scanner(System.in);
		System.out.println("ÿע2Ԫ��������Ҫ�����ע���� ");
		int in = input.nextInt();
		return in;
	}
	
    public static void main(String[] args) {
        int[] sysRedBall = new int[6];//ϵͳ���ɵĺ���
        int sysBlueBall = 0;//ϵͳ���ɵ�����
        int[] userRedBall = new int[6];//�û�ѡ��ĺ���
        int userBlueBall = 0;//�û�ѡ�������
        int redCount=0;//ѡ�еĺ������
        int blueCount=0;//ѡ�е��������
        Random r = new Random();
        int[] redBall = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
                16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
        int index = 0;
        
        while(true) {
        menu();
		Scanner sc = new Scanner(System.in);
		int mainChoose = sc.nextInt();

		if(mainChoose == 1) {
        //�û�ѡ��
			System.out.println("��ѡ�������룺��1-33��");
			Scanner in = new Scanner(System.in);
			for(int i=0;i<userRedBall.length;i++){
				userRedBall[i] = in.nextInt();
			}
			System.out.println("��ѡ��������룺��1-16��");
			userBlueBall = in.nextInt();
			selectNum();
			System.out.println("��������"+selectNum()+"ע��\t�ϼ�: "+2*selectNum()+"Ԫ��");
		}
		

        //����ϵͳ����
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
                //������
        	System.out.print("���ں������Ϊ��");
        	for(int i=0;i<sysRedBall.length;i++){
        		System.out.print(sysRedBall[i]+" ");
        	}
        	System.out.println();

        	System.out.print("�����������Ϊ��");
        	System.out.println(sysBlueBall);

        	System.out.print("��ѡ��ĺ������Ϊ��");
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
        	System.out.println("��ѡ����������Ϊ��"+userBlueBall);

        	//��֤�Ƿ��н�
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
        		System.out.println("��ϲ�㣬����һ�Ƚ�������"+selectNum()*5000000+"Ԫ\n");
        	}else if(redCount == 6 && blueCount == 0){
        		System.out.println("��ϲ�㣬���˶��Ƚ�������"+selectNum()*10000+"Ԫ\n");
        	}else if(redCount == 5 && blueCount == 1){
        		System.out.println("��ϲ�㣬�������Ƚ�������"+selectNum()*3000+"Ԫ\n");
        	}else if((redCount ==5)||(redCount == 4 && blueCount == 1)){
        		System.out.println("��ϲ�㣬�����ĵȽ�������"+selectNum()*200+"Ԫ\n");
        	}else if(redCount == 4 || (redCount == 3 && blueCount == 1)){
        		System.out.println("��ϲ�㣬������Ƚ�������"+selectNum()*10+"Ԫ\n");
        	}else if(blueCount ==1){
        		System.out.println("��ϲ�㣬�������Ƚ�������"+selectNum()*5+"Ԫ\n");
        	}else{
        		System.out.println("���ź������û���н�~\n");
        	}
        	
        	System.out.println("�н�����----\nһ�Ƚ���Ͷע�����뵱�ڿ�������ȫ����ͬ��˳���ޣ���ͬ�������н��� \r\n" + 
        			"���Ƚ���Ͷע�����뵱�ڿ��������е�6����ɫ�������ͬ�����н��� \r\n" + 
        			"���Ƚ���Ͷע�����뵱�ڿ��������е�����5����ɫ������1����ɫ�������ͬ�����н��� \r\n" + 
        			"�ĵȽ���Ͷע�����뵱�ڿ��������е�����5����ɫ�������ͬ����������4����ɫ������1����ɫ�������ͬ�����н��� \r\n" + 
        			"��Ƚ���Ͷע�����뵱�ڿ��������е�����4����ɫ�������ͬ����������3����ɫ������1����ɫ�������ͬ�����н��� \r\n" + 
        			"���Ƚ���Ͷע�����뵱�ڿ��������е�1����ɫ�������ͬ�����н���\n");
        	redCount = 0;
        	blueCount = 0;
        }
        
        if(mainChoose == 3) {
        	break;
        }
        }
    }
}