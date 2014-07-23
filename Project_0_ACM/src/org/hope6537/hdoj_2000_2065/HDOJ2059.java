package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2059 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			double L = s.nextDouble(); // 代表赛道的总长度
			double N = s.nextDouble(); // 充电站的个数
			double C = s.nextDouble(); // 电动车冲满电以后能行驶的距离
			double T = s.nextDouble(); // 每次充电所需要的时间
			double VR = s.nextDouble();
			double VT1 = s.nextDouble();
			double VT2 = s.nextDouble();
			double[] n = new double[(int) (N + 1)];// 距离起点的米数
			for (int i = 0; i < N; i++) {
				n[i] = s.nextInt();
			}
			n[(int) N] = L;
			// input done
			double rabbitSec = (L * 1.0 / VR);// 这是兔子到达的时间
			double lengthT = 0; // 这是乌龟已经行驶的里程
			double turtleSec = 0; // 从第零秒开始 乌龟出发
			double rideSec = C / VT1;// 这是乌龟每次充满电之后行驶C距离所用的时间
			int Ncount = 0;// 经过的加油站的个数
			double leftCLength = C;//这是记录上次没加油后还能坐车跑多远
			while (lengthT < L) {
				// 如果乌龟没到达终点 则循环
				if (leftCLength <= (n[Ncount]-lengthT)) {
					// 如果乌龟这次充满电的里程不够找到下一个充电站
					turtleSec = rabbitSec + turtleSec;
					// 那么先弄没电
					double leftLength = n[Ncount] - C;
					turtleSec = turtleSec + leftLength * 1.0 / VT2 + T;
					// 然后走到加油站 并等待充满电
					Ncount++;
					// 同时加油站的个数++
					lengthT = n[Ncount - 1];// 同时记录里程
					continue;
				} else if (leftCLength > (n[Ncount]-lengthT)) {
					// 如果车剩下的电够经过下一个加油站，那么他需要衡量下车剩下的电够不够他走到下下个加油站
					// 如果能，那就开到下下个加油站来处理
					// 下车充电浪费的时间是否比不下车充电然后推过去的时间多
					// 如果多，那就一会推车
					// 如果不多，那么到地方就充电
					
					//如果下站就是终点 那么直接冲过去
					if(Ncount == N){
						lengthT = n[Ncount];
						turtleSec = turtleSec + leftCLength/VT1;
						continue;
					}
					
					//如果对加油站采取无视态度
					double length1 = lengthT + leftCLength; //这是还能策马狂奔行驶的里程数
					double sec_ingore = leftCLength/VT1;//这是策马狂奔行驶的时间数
					
					//如果对加油站采取积极态度去加油，这是在下一个加油站加油完毕准备出发的时间
					double sec_engage = rideSec + T;
					
					if(length1>lengthT+n[Ncount+1]){
						//如果他能直接开到下下个加油站，那么交给下一次循环处理他是否在下下个加油站加油
						leftCLength = C-n[Ncount+1]; //记录开到下下个加油站还能剩余跑多远
						lengthT = n[Ncount+1];
						turtleSec = sec_ingore + turtleSec;
						Ncount+=2;//下下个加油站走起
						continue;
					}else{
						//如果开到一半没油了 那么计算到下下个加油站的路程
						double leftLength = n[Ncount+1] - length1;
						//得出推到下下个加油站的时间
						sec_ingore = sec_ingore + leftLength*1.0/VT2;
						if(leftLength > C){
							//如果加油也跑不完  那肯定在这里就加油
							leftLength = leftLength - C;//这是加油后跑着跑着还没油了的剩下的里程
							sec_engage = sec_engage + leftLength*1.0/VT2;//连带开车再推车到达下下个加油站的路程
							lengthT =  n[Ncount+1];//到达下下个加油站
							Ncount += 2;//经过两个加油站
							continue;
						}
						else{
							//如果加油能直接跑完  这是剩下需要推的路程
							double runLength = C - leftLength;
							//同时将推车的时间加上
							sec_engage = sec_engage + runLength/VT1 + rideSec;
						}
						
						
						if(sec_ingore>sec_engage){
							//如果无视的时间大于加油的时间 那么还是老实的加油吧
							lengthT =  n[Ncount+1]   ; //记录这次跑到下下个加油站的里程
							turtleSec = sec_engage + turtleSec;//同时记录时间
							
						}else{
							//如果不加油的时间小于等于加油的时间 那就多推会车
							lengthT =  n[Ncount+1] ;
							turtleSec = turtleSec + sec_ingore;
						}
						Ncount += 2;//经过两个加油站
						continue;
					}
					
					
				}
			}
			System.out.println(rabbitSec>turtleSec?"Good job,rabbit!":"What a pity rabbit!");

		}
	}
}
