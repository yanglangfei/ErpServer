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
					System.out.println("请输入要添加的数据(name)");
					which=scanner.next();
					Position position=new Position();
					position.setName(which);
					System.out.println("请输入要添加的数据(deptId)");
					which=scanner.next();
					position.setDeptId(Integer.parseInt(which));
					AddPositionService service=new AddPositionService();
					int res=service.addPosition(position);
					if(res>0){
						System.out.println("添加成功,输入11退出推荐操作");
					}else{
						System.out.println("添加失败");
					}
					which=scanner.next();
				}
			}else if("2".equals(which)){
				while (!"*".equals(which)) {
					System.out.println("请输入删除数据id");
					which=scanner.next();
					DelPositionService service=new DelPositionService();
					int res=service.delPosition(Integer.parseInt(which));
					if(res>0){
						System.out.println("删除成功，输入*退出删除操作");
					}else{
						System.out.println("删除失败");
					}
					which=scanner.next();
				}
				
			}else if("3".equals(which)){
				while (!"#".equals(which)) {
					System.out.println("输入要更新数据id");
					which=scanner.next();
					Position position=new Position();
					position.setId(Integer.parseInt(which));
					System.out.println("输入要更新的数据(name)");
					which=scanner.next();
					position.setName(which);
					System.out.println("请输入要更新的数据(deptId)");
					which=scanner.next();
					position.setDeptId(Integer.parseInt(which));
					UpdatePositionService service=new UpdatePositionService();
					int res=service.updatePosition(position);
					if(res>0){
						System.out.println("更新成功，输入#退出更新操作");
					}else{
						System.out.println("更新失败");
					}
					which=scanner.next();
				}
			}else if("4".equals(which)){
				PositionListService service=new PositionListService();
				List<Position> positions = service.querryPosition();
				System.out.println("查询成功:");
				if(positions.size()>0){
					for(Position position :positions){
						System.out.println("id:"+position.getId()+"\t");
						System.out.println("name:"+position.getName()+"\t");
						System.out.println("deptId:"+position.getDeptId()+"\n");
					}
				}else{
					System.out.println("暂无数据");
				}
				which=scanner.next();
			}else if("5".equals(which)){
				System.out.println("输入1添加数据\n输入2删除数据\n输入3修改数据\n输入4查询数据\n输入5显示帮助");
				which=scanner.next();
			}
		}
		System.out.println("停止操作");
		scanner.close();
	}
	
	@Test
	public void myTest(){
		System.out.println("myTest");
	}
}
