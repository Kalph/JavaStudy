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
			System.out.println("save.dat 파일을 로드하지 못했습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("HashMap<String, player>으로 캐스팅 할 수 없습니다.");
		}

		return tree;
	}
	
	public void fileSave(ArrayList<player> tree)  {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.dat"))){
			oos.writeObject(tree);
			JOptionPane.showMessageDialog(null, "성공적으로 저장되었습니다.");
			
		} catch (IOException e) {
			System.out.println("저장에 실패하였습니다.");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "저장에 실패하였습니다.");
		}
		
	}

	
	
}