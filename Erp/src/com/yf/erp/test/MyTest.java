package com.yf.erp.test;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.Observer;
import rx.Subscriber;

public class MyTest {
	
	public static void main(String[] args) {
		/*//�����۲���
		Observable<Integer> observable=Observable.create(new OnSubscribe<Integer>() {

			@Override
			public void call(Subscriber<? super Integer> e) {
				e.onNext(5);
				e.onNext(6);
				e.onNext(7);
				e.onNext(8);
				e.onNext(9);
				e.onCompleted();
			}
		});
		
		//�����۲���
		Observer<Integer> observer=new Observer<Integer>() {

			@Override
			public void onCompleted() {
				System.out.println("onCompleted");
				
			}

			@Override
			public void onError(Throwable arg0) {
				System.out.println("onError");
				
			}

			@Override
			public void onNext(Integer arg0) {
				System.out.println("onNext:"+arg0);
				
			}
		};
		//�����۲��ߺͱ��۲���
		observable.subscribe(observer);
		
		Subscriber<Integer> subscriber=new Subscriber<Integer>() {
			
			@Override
			public void onNext(Integer arg0) {
				System.out.println("onNext2");
				
			}
			
			@Override
			public void onError(Throwable arg0) {
				System.out.println("onError2");
				
			}
			
			@Override
			public void onCompleted() {
				System.out.println("onCompleted2");
				
			}
		};
		
		observable.subscribe(subscriber);*/
		
		/*Observable.just("1","2","3").subscribe(new Action1<String>() {

			@Override
			public void call(String arg0) {
				System.out.println("call:"+arg0);
				
			}
		});*/
		
		//ֻ���������ż��
		Observable.just(1, 2,3,4,5,6,7,8,9,20).filter(new Func1<Integer, Boolean>() {

			@Override
			public Boolean call(Integer arg0) {
				// TODO Auto-generated method stub
				return arg0%2==0;
			}
		}).subscribe(new Action1<Integer>() {

			@Override
			public void call(Integer arg0) {
				System.out.println("argo:"+arg0);
				
			}
		});
		
		
	}

}
