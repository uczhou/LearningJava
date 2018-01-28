package util;

import java.util.concurrent.ConcurrentLinkedQueue;

import application.Bullet;

public class BulletCollection {
	private static ConcurrentLinkedQueue<Bullet> bulletCollection;

	static {
		bulletCollection = new ConcurrentLinkedQueue<Bullet>();
	}
	
	public static boolean isEmpty(){
		return bulletCollection.size()==0;
	}
	
	public static int size(){
		return bulletCollection.size();
	}

	public static boolean addBullet(Bullet bullet) {
		if (bullet == null)
			throw new java.lang.NullPointerException();
		bulletCollection.add(bullet);
		return true;
	}

	public static ConcurrentLinkedQueue<Bullet> getBullets() {
		return bulletCollection;
	}
	
	public static boolean removeBullet(Bullet bullet){
		if(bullet==null)
			throw new java.lang.NullPointerException();
		if(!bulletCollection.contains(bullet))
			return false;
		else return bulletCollection.remove(bullet);
	}

}
