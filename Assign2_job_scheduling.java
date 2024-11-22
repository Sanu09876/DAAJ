import java.util.*;
public class MaxProfit{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of jobs: ");
        int numJobs = sc.nextInt();
        
        int[][]jobDetails = new int[numJobs][2];
        int maxDeadline = -1;
        
        for(int i=0;i<numJobs;i++){
            System.out.print("Enter the profit for "+ (i+1) + " job");
            int profit=sc.nextInt();
            System.out.print("Enter the deadline for "+ (i+1) + " job");
            int deadline = sc.nextInt();
            
            jobDetails[i][0] = profit;
            jobDetails[i][1] = deadline;
            if(deadline>maxDeadline) maxDeadline = deadline;
        }
        
        int[] jobSchedule = new int[maxDeadline+1];
        Arrays.sort(jobDetails, (x,y)->Integer.compare(y[0],x[0]));
        
        for(int i=0;i<numJobs;i++){
            int jobProfit = jobDetails[i][0];
            int jobDeadline = jobDetails[i][1];
            
            if(jobSchedule[jobDeadline]==0){
                jobSchedule[jobDeadline] = jobProfit;
            }else{
                for(int j=jobDeadline-1;j>=1;j--){
                    if(jobSchedule[j]==0){
                        jobSchedule[j] = jobProfit;
                        break;
                    }
                }
            }
        }
        
        int totalProfit = 0;
        System.out.println("The output is given below: ");
        for(int i=1;i<maxDeadline+1;i++){
            System.out.println("Slot "+ i + " "+jobSchedule[i]);
            totalProfit+=jobSchedule[i];
        }
        System.out.print(totalProfit);
        sc.close();
    }
}