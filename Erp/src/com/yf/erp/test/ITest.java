package com.yf.erp.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.yf.erp.bean.Position;
import com.yf.erp.service.AddPositionService;
import com.yf.erp.service.DelPositionService;
import com.yf.erp.service.PositionListService;
import com.yf.erp.service.UpdatePositionService;

public class ITest {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String which=scanner.next();
		while (!"0".equals(which)) {
			if("1".equals(which)){
				while (!"11".equals(which)) {
					System.out.println("������Ҫ��ӵ�����(name)");
					which=scanner.next();
					Position position=new Position();
					position.setName(which);
					System.out.println("������Ҫ��ӵ�����(deptId)");
					which=scanner.next();
					position.setDeptId(Integer.parseInt(which));
					AddPositionService service=new AddPositionService();
					int res=service.addPosition(position);
					if(res>0){
						System.out.println("��ӳɹ�,����11�˳��Ƽ�����");
					}else{
						System.out.println("���ʧ��");
					}
					which=scanner.next();
				}
			}else if("2".equals(which)){
				while (!"*".equals(which)) {
					System.out.println("������ɾ������id");
					which=scanner.next();
					DelPositionService service=new DelPositionService();
					int res=service.delPosition(Integer.parseInt(which));
					if(res>0){
						System.out.println("ɾ���ɹ�������*�˳�ɾ������");
					}else{
						System.out.println("ɾ��ʧ��");
					}
					which=scanner.next();
				}
				
			}else if("3".equals(which)){
				while (!"#".equals(which)) {
					System.out.println("����Ҫ��������id");
					which=scanner.next();
					Position position=new Position();
					position.setId(Integer.parseInt(which));
					System.out.println("����Ҫ���µ�����(name)");
					which=scanner.next();
					position.setName(which);
					System.out.println("������Ҫ���µ�����(deptId)");
					which=scanner.next();
					position.setDeptId(Integer.parseInt(which));
					UpdatePositionService service=new UpdatePositionService();
					int res=service.updatePosition(position);
					if(res>0){
						System.out.println("���³ɹ�������#�˳����²���");
					}else{
						System.out.println("����ʧ��");
					}
					which=scanner.next();
				}
			}else if("4".equals(which)){
				PositionListService service=new PositionListService();
				List<Position> positions = service.querryPosition();
				System.out.println("��ѯ�ɹ�:");
				if(positions.size()>0){
					for(Position position :positions){
						System.out.println("id:"+position.getId()+"\t");
						System.out.println("name:"+position.getName()+"\t");
						System.out.println("deptId:"+position.getDeptId()+"\n");
					}
				}else{
					System.out.println("��������");
				}
				which=scanner.next();
			}else if("5".equals(which)){
				System.out.println("����1�������\n����2ɾ������\n����3�޸�����\n����4��ѯ����\n����5��ʾ����");
				which=scanner.next();
			}
		}
		System.out.println("ֹͣ����");
		scanner.close();
	}
	
	@Test
	public void myTest(){
		System.out.println("myTest");
	}
}
