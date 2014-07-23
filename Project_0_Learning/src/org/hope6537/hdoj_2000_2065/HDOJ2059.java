package org.hope6537.hdoj_2000_2065;

import java.util.Scanner;

public class HDOJ2059 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (s.hasNext()) {
			double L = s.nextDouble(); // �����������ܳ���
			double N = s.nextDouble(); // ���վ�ĸ���
			double C = s.nextDouble(); // �綯���������Ժ�����ʻ�ľ���
			double T = s.nextDouble(); // ÿ�γ������Ҫ��ʱ��
			double VR = s.nextDouble();
			double VT1 = s.nextDouble();
			double VT2 = s.nextDouble();
			double[] n = new double[(int) (N + 1)];// ������������
			for (int i = 0; i < N; i++) {
				n[i] = s.nextInt();
			}
			n[(int) N] = L;
			// input done
			double rabbitSec = (L * 1.0 / VR);// �������ӵ����ʱ��
			double lengthT = 0; // �����ڹ��Ѿ���ʻ�����
			double turtleSec = 0; // �ӵ����뿪ʼ �ڹ����
			double rideSec = C / VT1;// �����ڹ�ÿ�γ�����֮����ʻC�������õ�ʱ��
			int Ncount = 0;// �����ļ���վ�ĸ���
			double leftCLength = C;//���Ǽ�¼�ϴ�û���ͺ��������ܶ�Զ
			while (lengthT < L) {
				// ����ڹ�û�����յ� ��ѭ��
				if (leftCLength <= (n[Ncount]-lengthT)) {
					// ����ڹ���γ��������̲����ҵ���һ�����վ
					turtleSec = rabbitSec + turtleSec;
					// ��ô��Ūû��
					double leftLength = n[Ncount] - C;
					turtleSec = turtleSec + leftLength * 1.0 / VT2 + T;
					// Ȼ���ߵ�����վ ���ȴ�������
					Ncount++;
					// ͬʱ����վ�ĸ���++
					lengthT = n[Ncount - 1];// ͬʱ��¼���
					continue;
				} else if (leftCLength > (n[Ncount]-lengthT)) {
					// �����ʣ�µĵ繻������һ������վ����ô����Ҫ�����³�ʣ�µĵ繻�������ߵ����¸�����վ
					// ����ܣ��ǾͿ������¸�����վ������
					// �³�����˷ѵ�ʱ���Ƿ�Ȳ��³����Ȼ���ƹ�ȥ��ʱ���
					// ����࣬�Ǿ�һ���Ƴ�
					// ������࣬��ô���ط��ͳ��
					
					//�����վ�����յ� ��ôֱ�ӳ��ȥ
					if(Ncount == N){
						lengthT = n[Ncount];
						turtleSec = turtleSec + leftCLength/VT1;
						continue;
					}
					
					//����Լ���վ��ȡ����̬��
					double length1 = lengthT + leftCLength; //���ǻ��ܲ������ʻ�������
					double sec_ingore = leftCLength/VT1;//���ǲ������ʻ��ʱ����
					
					//����Լ���վ��ȡ����̬��ȥ���ͣ���������һ������վ�������׼��������ʱ��
					double sec_engage = rideSec + T;
					
					if(length1>lengthT+n[Ncount+1]){
						//�������ֱ�ӿ������¸�����վ����ô������һ��ѭ���������Ƿ������¸�����վ����
						leftCLength = C-n[Ncount+1]; //��¼�������¸�����վ����ʣ���ܶ�Զ
						lengthT = n[Ncount+1];
						turtleSec = sec_ingore + turtleSec;
						Ncount+=2;//���¸�����վ����
						continue;
					}else{
						//�������һ��û���� ��ô���㵽���¸�����վ��·��
						double leftLength = n[Ncount+1] - length1;
						//�ó��Ƶ����¸�����վ��ʱ��
						sec_ingore = sec_ingore + leftLength*1.0/VT2;
						if(leftLength > C){
							//�������Ҳ�ܲ���  �ǿ϶�������ͼ���
							leftLength = leftLength - C;//���Ǽ��ͺ��������Ż�û���˵�ʣ�µ����
							sec_engage = sec_engage + leftLength*1.0/VT2;//�����������Ƴ��������¸�����վ��·��
							lengthT =  n[Ncount+1];//�������¸�����վ
							Ncount += 2;//������������վ
							continue;
						}
						else{
							//���������ֱ������  ����ʣ����Ҫ�Ƶ�·��
							double runLength = C - leftLength;
							//ͬʱ���Ƴ���ʱ�����
							sec_engage = sec_engage + runLength/VT1 + rideSec;
						}
						
						
						if(sec_ingore>sec_engage){
							//������ӵ�ʱ����ڼ��͵�ʱ�� ��ô������ʵ�ļ��Ͱ�
							lengthT =  n[Ncount+1]   ; //��¼����ܵ����¸�����վ�����
							turtleSec = sec_engage + turtleSec;//ͬʱ��¼ʱ��
							
						}else{
							//��������͵�ʱ��С�ڵ��ڼ��͵�ʱ�� �ǾͶ��ƻᳵ
							lengthT =  n[Ncount+1] ;
							turtleSec = turtleSec + sec_ingore;
						}
						Ncount += 2;//������������վ
						continue;
					}
					
					
				}
			}
			System.out.println(rabbitSec>turtleSec?"Good job,rabbit!":"What a pity rabbit!");

		}
	}
}
