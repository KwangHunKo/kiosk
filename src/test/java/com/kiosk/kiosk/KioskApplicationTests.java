package com.kiosk.kiosk;

import com.kiosk.kiosk.dto.menu.MenuAddReq;
import com.kiosk.kiosk.dto.menu.MenuModifyReq;
import com.kiosk.kiosk.service.menu.MenuService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
class KioskApplicationTests {

	@Autowired
	MenuService menuService;

	//@Test
	@DisplayName("메뉴추가 테스트")
	void addMenu() throws FileNotFoundException {
		String fileDir = "/static/espresso.jpg";
		FileInputStream fis = new FileInputStream(fileDir);
		//MenuAddReq req = new MenuAddReq("에스프레소", 3000L);
		try {
		//	menuService.addMenu(req);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	//@Test
	void modifyMenu(){
		MenuModifyReq req = new MenuModifyReq("에스프레소","플랫화이트", 5000L);
		try{
			menuService.modifyMenu(req);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	void deleteMenu(){
		String menuName = "에스프레소";
		try{
			menuService.deleteMenu(menuName);
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
}
