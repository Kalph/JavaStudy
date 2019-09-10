package game.model.dao;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import game.model.vo.player;

public class GameDao{

	
	@SuppressWarnings("unchecked")
	public ArrayList<player> fileOpen() {
		ArrayList<player> tree = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save.dat"))) {
			tree =  (ArrayList<player>) ois.readObject();
			System.out.println(tree);
		} catch (IOException e) {
			System.out.println("save.dat ������ �ε����� ���߽��ϴ�.");
		} catch (ClassNotFoundException e) {
			System.out.println("HashMap<String, player>���� ĳ���� �� �� �����ϴ�.");
		}

		return tree;
	}
	
	public void fileSave(ArrayList<player> tree)  {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.dat"))){
			oos.writeObject(tree);
			JOptionPane.showMessageDialog(null, "���������� ����Ǿ����ϴ�.");
			
		} catch (IOException e) {
			System.out.println("���忡 �����Ͽ����ϴ�.");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���忡 �����Ͽ����ϴ�.");
		}
		
	}

	
	
}