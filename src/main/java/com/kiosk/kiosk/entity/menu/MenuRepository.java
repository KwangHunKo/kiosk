package com.kiosk.kiosk.entity.menu;

import com.kiosk.kiosk.dto.menu.MenuModifyReq;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, String> {
    Optional<Menu> findByMenuName(String menuName);
}
